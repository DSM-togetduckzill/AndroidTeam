package com.example.tugedeongjilproject.signup

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.util.Base64
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivitySignUpBinding
import com.example.tugedeongjilproject.login.SignInActivity
import com.example.tugedeongjilproject.util.executeScript
import com.example.tugedeongjilproject.util.webViewSetting
import kotlinx.coroutines.delay
import java.io.ByteArrayOutputStream
import java.io.File

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up){

    //private lateinit var imageFile: File

    override fun initView() {
        val url = "https://togetduckzill-fontend.vercel.app/"

        binding.run {
            webViewSetting(webView, url)
            webView.addJavascriptInterface(WebAppInterface(
                this@SignUpActivity,
                this
            ),"android")

            btnBack.setOnClickListener {
                finish()
            }
        }

    }

    override fun observeEvent() {}

    fun gotoLogin(){
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }

    class WebAppInterface(
        signUpActivity: SignUpActivity,
        signUpBinding: ActivitySignUpBinding
    ){
        private val signUpActivity = signUpActivity
        private var imageFile : String? = null
        private val getImage = "getImage"
        private lateinit var bitmap: Bitmap

        @JavascriptInterface
        fun signUpNext(){
            signUpActivity.gotoLogin()
        }

        @JavascriptInterface
        fun openGallery(){
            return selectGallery()
        }

        private fun selectGallery(){
            val writePermission = ContextCompat.checkSelfPermission(
                signUpActivity,Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            val readPermission = ContextCompat.checkSelfPermission(
                signUpActivity, Manifest.permission.READ_EXTERNAL_STORAGE
            )

            if(writePermission == PackageManager.PERMISSION_DENIED ||
                    readPermission == PackageManager.PERMISSION_DENIED){
                ActivityCompat.requestPermissions(signUpActivity,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
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

        private val imageResult = signUpActivity.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result ->

            if(result.resultCode == RESULT_OK) {
                val imageUri = result.data?.data

                imageUri.let {
                    if(Build.VERSION.SDK_INT < 28){
                        bitmap = MediaStore.Images.Media.getBitmap(
                            signUpActivity.contentResolver,
                            it
                        )
                    }else {
                        val source = ImageDecoder.createSource(signUpActivity.contentResolver,it!!)
                        bitmap = ImageDecoder.decodeBitmap(source)
                    }

                }
            }

            signUpBinding.webView.evaluateJavascript("javascript:window.dispatchEvent(new CustomEvent(\"getImage\",{detail:\"${bitmapToBase64(bitmap).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(),"")}\"}))",null)

//            signUpBinding.webView.executeScript(
//                functionName = "window.dispatchEvent",
//                params = listOf("new CustomEvent(\"getImage\",{detail:\"${bitmapToBase64(bitmap)}\"})")
//            )
//            signUpBinding.webView.executeScript(
//                functionName = "window.dispatchEvent",
//                params = listOf(imageFile!!)
//            )

        }

        private fun bitmapToBase64(bitmap: Bitmap): String{
            val byteArrayOutputStream = ByteArrayOutputStream()

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)

            val byteArray = byteArrayOutputStream.toByteArray()

            return Base64.encodeToString(byteArray, 0)
        }

//        private fun getRealPathFromURI(uri: Uri): String{
//            val buildName = Build.MANUFACTURER
//            if(buildName.equals("Xiaomi")) {
//                return uri.path!!
//            }
//            var columnIndex = 0
//            val proj = arrayOf(MediaStore.Images.Media.DATA)
//            val cursor = signUpActivity.contentResolver.query(uri, proj, null, null, null)
//            if(cursor!!.moveToFirst()) {
//                columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
//            }
//            val result = cursor.getString(columnIndex)
//            cursor.close()
//
//            return result
//        }
//
//        private fun byte2HexStr(byte: Byte){
//            val sb = StringBuffer()
//        }
    }

    companion object{
        const val REVIEW_MIN_LENGTH = 10
        const val REQ_GALLERY = 1

        const val PARAM_KEY_IMAGE = "image"
        const val PARAM_KEY_PRODUCT_ID = "product_id"
        const val PARAM_KEY_REVIEW = "review_content"
        const val PARAM_KEY_RATING = "rating"
    }
}