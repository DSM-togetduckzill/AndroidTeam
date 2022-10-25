package com.example.tugedeongjilproject.util

import android.webkit.GeolocationPermissions
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.tugedeongjilproject.signup.SignUpActivity

fun webViewSetting(
    webView: WebView,
    url: String
){
    webView.run {
        webViewClient = WebViewClient()

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = object : WebChromeClient(){
            override fun onGeolocationPermissionsShowPrompt(
                origin: String?,
                callback: GeolocationPermissions.Callback?
            ) {
                super.onGeolocationPermissionsShowPrompt(origin, callback)
                callback?.invoke(origin,true,false)
            }
        }

        settings.run {
            javaScriptEnabled = true
        }


        loadUrl(url)
    }
}