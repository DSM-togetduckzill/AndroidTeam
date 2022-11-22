package com.example.tugedeongjilproject.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivitySplashBinding
import com.example.tugedeongjilproject.login.SignInActivity
import com.example.tugedeongjilproject.login.SignInViewModel
import com.example.tugedeongjilproject.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Splash : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash){

    private val signInViewModel: SignInViewModel by viewModels()
    private var autoSignIn = false

    override fun initView() {

        signInViewModel.autoSignIn()

        Handler(Looper.getMainLooper()).postDelayed({
            if(autoSignIn) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, 1000)
    }

    override fun observeEvent() {
        signInViewModel.signInSuccess.observe(this){
            autoSignIn = true
        }
    }

}