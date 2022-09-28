package com.example.tugedeongjilproject.login

import android.graphics.Paint
import android.view.WindowManager
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivitySignInBinding

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    override fun initView() {

        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        binding.run {

            tvSignUp.paintFlags = Paint.UNDERLINE_TEXT_FLAG

            btnSignIn.setOnClickListener {

            }

            tvSignUp.setOnClickListener {

            }
        }
    }

    override fun observeEvent() {}
}