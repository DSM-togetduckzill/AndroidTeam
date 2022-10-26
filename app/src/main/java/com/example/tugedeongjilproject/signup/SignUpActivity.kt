package com.example.tugedeongjilproject.signup

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.webkit.JavascriptInterface
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivitySignUpBinding
import com.example.tugedeongjilproject.login.SignInActivity
import com.example.tugedeongjilproject.util.webViewSetting
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream
import java.lang.Exception

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up){

    private lateinit var imageFile: File

    override fun initView() {
        val url = "https://togetduckzill-fontend.vercel.app/"

        binding.run {
            webViewSetting(webView, url)
            webView.addJavascriptInterface(WebAppInterface(this@SignUpActivity),"android")

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

    class WebAppInterface(signUpActivity: SignUpActivity){
        private val signUpActivity = signUpActivity
        private var imageFile : String? = null

        @JavascriptInterface
        fun signUpNext(){
            signUpActivity.gotoLogin()
        }

        @JavascriptInterface
        fun getImage(): String?{
            selectGallery()
            return imageFile
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
                imageUri?.let{
                     imageFile = getRealPathFromURI(it)
                }
            }
        }

        private fun getRealPathFromURI(uri: Uri): String{
            val buildName = Build.MANUFACTURER
            if(buildName.equals("Xiaomi")) {
                return uri.path!!
            }
            var columnIndex = 0
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = signUpActivity.contentResolver.query(uri, proj, null, null, null)
            if(cursor!!.moveToFirst()) {
                columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            }
            val result = cursor.getString(columnIndex)
            cursor.close()

            return result
        }

        private fun byte2HexStr(byte: Byte){
            val sb = StringBuffer()
        }
    }

    companion object{
        const val REVIEW_MIN_LENGTH = 10
        const val REQ_GALLERY = 1

        const val PARAM_KEY_IMAGE = "image"
        const val PARAM_KEY_PRODUCT_ID = "product_id"
        const val PARAM_KEY_REVIEW = "review_content"
        const val PARAM_KEY_RATING = "rating"
    }

    private val imageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->

        if(result.resultCode == RESULT_OK) {
            val imageUri = result.data?.data

            imageUri?.let {
                imageFile = File(getRealPathFromURI(it))
            }
        }
    }

    private fun getRealPathFromURI(uri: Uri): String{
        val buildName = Build.MANUFACTURER
        if(buildName.equals("Xiaomi")) {
            return uri.path!!
        }
        var columnIndex = 0
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri, proj, null, null, null)
        if(cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        val result = cursor.getString(columnIndex)
        cursor.close()

        return result
    }

}