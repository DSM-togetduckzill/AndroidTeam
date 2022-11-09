package com.example.tugedeongjilproject.login

import android.content.Intent
import android.graphics.Paint
import androidx.activity.viewModels
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivitySignInBinding
import com.example.tugedeongjilproject.main.MainActivity
import com.example.tugedeongjilproject.util.WebViewHelperActivity

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private val signInViewModel: SignInViewModel by viewModels()

    override fun initView() {
        binding.run {

            tvSignUp.paintFlags = Paint.UNDERLINE_TEXT_FLAG

            btnSignIn.setOnClickListener {
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
            }

            tvSignUp.setOnClickListener {
                val intent = Intent(this@SignInActivity, WebViewHelperActivity::class.java)
                intent.putExtra("url","https://togetduckzill-fontend.vercel.app/signup")
                startActivity(intent)
            }
        }
    }

    override fun observeEvent() {}
}