package com.example.tugedeongjilproject.util

import android.content.Intent
import android.widget.Toast
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivityWebViewHelperBinding
import com.example.tugedeongjilproject.login.SignInActivity
import com.example.tugedeongjilproject.profile.FriendActivity
import com.example.tugedeongjilproject.profile.UnknownActivity
import kotlin.properties.Delegates

class WebViewHelperActivity : BaseActivity<ActivityWebViewHelperBinding>(R.layout.activity_web_view_helper){

    private lateinit var url: String
    private lateinit var header: String
    private var unknown by Delegates.notNull<Boolean>()
    private var backBoolean by Delegates.notNull<Boolean>()
    private var addBoolean by Delegates.notNull<Boolean>()

    override fun initView() {

        url = intent.getStringExtra("url") ?: ""
        header = intent.getStringExtra("header") ?: ""
        unknown = intent.getBooleanExtra("unknown", true)
        backBoolean = intent.getBooleanExtra("back",true)
        addBoolean = intent.getBooleanExtra("add",false)


        binding.run {
            if(url.isNotEmpty()){
                webViewSetting(webView, url,this@WebViewHelperActivity)
            }

            composeView.webViewHeader(
                btnBack = backBoolean,
                onBackPressed = { finish() },
                headerText = header,
                btnMenu = addBoolean
            ) {
                if (!unknown) {
                    startActivity(Intent(this@WebViewHelperActivity, UnknownActivity::class.java))
                } else {
                    startActivity(Intent(this@WebViewHelperActivity, FriendActivity::class.java))
                }
            }
        }
    }

    override fun observeEvent() {}

    fun gotoLogin(){
        showToastShort("회원가입을 성공했습니다")
        finish()
    }

    fun makeRoomFinish() {
        showToastShort("방 생성을 성공했습니다")
        finish()
    }

}