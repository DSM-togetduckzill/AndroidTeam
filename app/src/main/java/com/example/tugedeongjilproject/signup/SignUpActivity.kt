package com.example.tugedeongjilproject.signup

import android.content.Intent
import android.webkit.JavascriptInterface
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivitySignUpBinding
import com.example.tugedeongjilproject.login.SignInActivity
import com.example.tugedeongjilproject.main.MainActivity
import com.example.tugedeongjilproject.util.webViewSetting

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up){
    override fun initView() {
        val url = "https://togetduckzill-fontend.vercel.app/signup"

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
        val signUpActivity = signUpActivity

        @JavascriptInterface
        fun signUpNext(){
            signUpActivity.gotoLogin()
        }
    }



}