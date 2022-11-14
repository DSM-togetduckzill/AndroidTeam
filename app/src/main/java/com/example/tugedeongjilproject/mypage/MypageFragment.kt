package com.example.tugedeongjilproject.mypage

import android.content.Intent
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.os.bundleOf
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.databinding.FragmentMypageBinding
import com.example.tugedeongjilproject.login.SignInActivity
import com.example.tugedeongjilproject.main.MainActivity

class MypageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage){


    override fun initView() {

        val mainActivity = activity as MainActivity

        binding.run {

            secondBox.setOnClickListener {
                // 프로필 수정 화면 띄우기
            }

            thirdBox.setOnClickListener {
                // 로그아웃
                val intent = Intent(requireActivity(), SignInActivity::class.java)
                mainActivity.finish()
                startActivity(intent)
            }

        }
    }

    override fun observeEvent() {
    }
}