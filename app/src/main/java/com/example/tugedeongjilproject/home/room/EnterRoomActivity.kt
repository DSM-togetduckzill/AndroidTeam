package com.example.tugedeongjilproject.home.room

import android.content.Intent
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivityEnterRoomBinding
import com.example.tugedeongjilproject.util.WebViewHelperActivity

class EnterRoomActivity : BaseActivity<ActivityEnterRoomBinding>(R.layout.activity_enter_room) {
    override fun initView() {
        binding.run {
            btnBack.setOnClickListener {
                finish()
            }
            constraintEnterRoomSecond.setOnClickListener {
                val intent = Intent(this@EnterRoomActivity, WebViewHelperActivity::class.java)
                intent.putExtra("url","https://togetduckzill-fontend.vercel.app/make_room")
                intent.putExtra("header","방 생성하기")
                startActivity(intent)
            }
        }
    }

    override fun observeEvent() {
    }
}