package com.example.tugedeongjilproject.util

import android.content.Intent
import android.webkit.WebViewClient
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivityWebViewHelperBinding
import com.example.tugedeongjilproject.login.SignInActivity
import kotlin.properties.Delegates

class WebViewHelperActivity : BaseActivity<ActivityWebViewHelperBinding>(R.layout.activity_web_view_helper){

    private lateinit var url: String
    private lateinit var header: String
    private var backBoolean by Delegates.notNull<Boolean>()
    private var addBoolean by Delegates.notNull<Boolean>()

    override fun initView() {

        url = intent.getStringExtra("url") ?: ""
        header = intent.getStringExtra("header") ?: ""
        backBoolean = intent.getBooleanExtra("back",true)
        addBoolean = intent.getBooleanExtra("add",false)

        binding.run {
            if(url.isNotEmpty()){
                webViewSetting(webView, url,this@WebViewHelperActivity)
            }

            tvHeader.text = header

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

}