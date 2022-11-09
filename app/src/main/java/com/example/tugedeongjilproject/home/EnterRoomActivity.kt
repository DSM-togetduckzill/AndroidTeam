package com.example.tugedeongjilproject.home

import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivityEnterRoomBinding

class EnterRoomActivity : BaseActivity<ActivityEnterRoomBinding>(R.layout.activity_enter_room) {
    override fun initView() {
        binding.run {
            btnBack.setOnClickListener {
                finish()
            }
            constraintEnterRoomSecond.setOnClickListener {

            }
        }
    }

    override fun observeEvent() {
    }
}