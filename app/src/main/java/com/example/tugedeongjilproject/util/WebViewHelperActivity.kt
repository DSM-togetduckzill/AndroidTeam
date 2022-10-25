package com.example.tugedeongjilproject.util

import android.webkit.WebViewClient
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivityWebViewHelperBinding

class WebViewHelperActivity : BaseActivity<ActivityWebViewHelperBinding>(R.layout.activity_web_view_helper){
    override fun initView() {
        binding.webView.run {
            webViewClient = WebViewClient()

            settings.javaScriptEnabled = true
            //addJavascriptInterface()

            loadUrl("https://togetduckzill-fontend.vercel.app/")
        }

    }

    class WebAppInterface() {
    }

    override fun observeEvent() {}

}