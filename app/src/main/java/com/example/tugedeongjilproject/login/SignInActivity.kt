package com.example.tugedeongjilproject.login

import android.content.Intent
import android.graphics.Paint
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivitySignInBinding
import com.example.tugedeongjilproject.main.MainActivity

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    override fun initView() {

        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        binding.run {

            tvSignUp.paintFlags = Paint.UNDERLINE_TEXT_FLAG

            btnSignIn.setOnClickListener {
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                finish()
            }

            tvSignUp.setOnClickListener {

            }
        }
    }

    override fun observeEvent() {}
}