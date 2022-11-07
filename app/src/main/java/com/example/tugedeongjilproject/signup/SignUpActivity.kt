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
import android.widget.Toast
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
        val url = "https://togetduckzill-fontend.vercel.app/signup"

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
                    bitmap = if(Build.VERSION.SDK_INT < 28){
                        MediaStore.Images.Media.getBitmap(
                            signUpActivity.contentResolver,
                            it
                        )
                    }else {
                        val source = ImageDecoder.createSource(signUpActivity.contentResolver,it!!)
                        ImageDecoder.decodeBitmap(source)
                    }

                }
            }

            try {
                signUpBinding.webView.evaluateJavascript("javascript:window.dispatchEvent(new CustomEvent(\"getImage\",{detail:\"${bitmap.toBase64().replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(),"")}\"}))",null)
            } catch (e: Exception){
                Toast.makeText( signUpActivity,"사진을 선택해 주세요", Toast.LENGTH_SHORT).show()
            }
        }

        private val DefaultQuality: Int = 100

        private fun Bitmap.toBase64(): String {
            val byteArrayOutputStream = ByteArrayOutputStream()

            bitmap.compress(Bitmap.CompressFormat.PNG, DefaultQuality, byteArrayOutputStream)

            val byteArray = byteArrayOutputStream.toByteArray()

            return Base64.encodeToString(byteArray, 0)
        }
    }

    companion object{
        const val REQ_GALLERY = 1
    }
}