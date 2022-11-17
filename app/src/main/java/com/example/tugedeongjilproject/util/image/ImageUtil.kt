package com.example.tugedeongjilproject.util.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.tugedeongjilproject.R
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream
import java.lang.Exception

fun uriToMultipart(context: Context, filePath: String, uri: Uri): MultipartBody.Part {
    val file = File(filePath)
    var inputStream: InputStream? = null
    try {
        inputStream = context.contentResolver.openInputStream(uri)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    val bitmap = BitmapFactory.decodeStream(inputStream)
    val byteArrayOutputStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream)
    val requestFile =
        byteArrayOutputStream.toByteArray().toRequestBody("image/jpg".toMediaTypeOrNull())
    val body = MultipartBody.Part.createFormData("file", file.name, requestFile)
    return body
}

fun loadImage(imageView: ImageView, url: String?) {
    if(!url.isNullOrEmpty()){
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.clipToOutline = true //imageView background 적용을 위한 속성
        Glide.with(imageView)
            .load(url)
            .error(R.drawable.img_profile_base)
            .into(imageView)
    }else{
        Glide.with(imageView)
            .load(R.drawable.img_profile_base)
            .into(imageView)
    }
}