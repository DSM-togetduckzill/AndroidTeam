package com.example.tugedeongjilproject.util

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.util.Base64
import android.webkit.GeolocationPermissions
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.ByteArrayOutputStream

fun webViewSetting(
    webView: WebView,
    url: String,
    webViewHelperActivity: WebViewHelperActivity
){
    webView.run {
       // webViewClient = WebViewClient()

        webViewClient = WebViewClient()
        webChromeClient = object : WebChromeClient(){
            override fun onGeolocationPermissionsShowPrompt(
                origin: String?,
                callback: GeolocationPermissions.Callback?
            ) {
                super.onGeolocationPermissionsShowPrompt(origin, callback)
                callback?.invoke(origin,true,false)
            }
        }

        addJavascriptInterface(WebAppInterface(webViewHelperActivity, webView),"android")

        settings.run {
            allowFileAccess = true
            javaScriptEnabled = true
        }


        loadUrl(url)
    }
}

class WebAppInterface(
    webViewHelperActivity: WebViewHelperActivity,
    webView: WebView
){
    private val webViewHelperActivity = webViewHelperActivity
    private lateinit var bitmap: Bitmap

    @JavascriptInterface
    fun signUpNext(){
        webViewHelperActivity.gotoLogin()
    }

    @JavascriptInterface
    fun makeRoomFinish() {
        webViewHelperActivity.makeRoomFinish()
    }

    @JavascriptInterface
    fun openGallery(){
        return selectGallery()
    }

    private fun selectGallery(){
        val writePermission = ContextCompat.checkSelfPermission(
            webViewHelperActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val readPermission = ContextCompat.checkSelfPermission(
            webViewHelperActivity, Manifest.permission.READ_EXTERNAL_STORAGE
        )

        if(writePermission == PackageManager.PERMISSION_DENIED ||
            readPermission == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(webViewHelperActivity,
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE), REQ_GALLERY)
        } else {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*"
            )

            imageResult.launch(intent)
        }
    }

    private val imageResult = webViewHelperActivity.registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->

        if(result.resultCode == AppCompatActivity.RESULT_OK) {
            val imageUri = result.data?.data

            imageUri.let {
                bitmap = if(Build.VERSION.SDK_INT < 28){
                    MediaStore.Images.Media.getBitmap(
                        webViewHelperActivity.contentResolver,
                        it
                    )
                }else {
                    val source = ImageDecoder.createSource(webViewHelperActivity.contentResolver,it!!)
                    ImageDecoder.decodeBitmap(source)
                }

            }
        }

        try {
            webView.evaluateJavascript("javascript:window.dispatchEvent(new CustomEvent(\"getImage\",{detail:\"${bitmap.toBase64().replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(),"")}\"}))",null)
        } catch (e: Exception){
            Toast.makeText( webViewHelperActivity,"사진을 선택해 주세요", Toast.LENGTH_SHORT).show()
        }
    }

    private val DefaultQuality: Int = 100

    private fun Bitmap.toBase64(): String {
        val byteArrayOutputStream = ByteArrayOutputStream()

        bitmap.compress(Bitmap.CompressFormat.PNG, DefaultQuality, byteArrayOutputStream)

        val byteArray = byteArrayOutputStream.toByteArray()

        return Base64.encodeToString(byteArray, 0)
    }

    companion object{
        const val REQ_GALLERY = 1
    }
}

fun WebView.executeScript(
    functionName: String,
    params: List<Any> = emptyList(),
    onResult: (value: String) -> Unit = {}
){
    val sb = StringBuilder()
    sb.append("javascript:")
        .append(functionName)
        .append("(")
        .append(params.joinToString(", "))
        .append(")")
    evaluateJavascript(sb.toString(),onResult)

}