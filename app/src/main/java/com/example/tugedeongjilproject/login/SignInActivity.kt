package com.example.tugedeongjilproject.login

import android.content.Intent
import android.graphics.Paint
import androidx.activity.viewModels
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivitySignInBinding
import com.example.tugedeongjilproject.main.MainActivity
import com.example.tugedeongjilproject.signup.SignUpActivity

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private val signInViewModel: SignInViewModel by viewModels()

    override fun initView() {
        binding.run {

            tvSignUp.paintFlags = Paint.UNDERLINE_TEXT_FLAG

            btnSignIn.setOnClickListener {
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
            }

            tvSignUp.setOnClickListener {
                startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            }
        }
    }

    override fun observeEvent() {}
}