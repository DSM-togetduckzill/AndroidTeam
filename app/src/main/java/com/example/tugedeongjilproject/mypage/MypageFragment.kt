package com.example.tugedeongjilproject.mypage

import android.content.Intent
import androidx.fragment.app.viewModels
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.databinding.FragmentMypageBinding
import com.example.tugedeongjilproject.login.SignInActivity
import com.example.tugedeongjilproject.login.SignInViewModel
import com.example.tugedeongjilproject.main.MainActivity
import com.example.tugedeongjilproject.util.WebViewHelperActivity
import com.example.tugedeongjilproject.util.image.KIMJUNHO
import com.example.tugedeongjilproject.util.image.loadImage
import com.example.tugedeongjilproject.util.webViewHeader
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MypageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage){

    private val signInViewModel: SignInViewModel by viewModels()

    override fun initView() {

        val mainActivity = activity as MainActivity

        binding.run {

            secondBox.setOnClickListener {
                val intent = Intent(requireContext(), WebViewHelperActivity::class.java)
                intent
                    .putExtra("url","https://togetduckzill-fontend.vercel.app/modify_profile")
                    .putExtra("header","프로필 수정").putExtra("","")
                startActivity(intent)
            }

            thirdBox.setOnClickListener {
                // 로그아웃
                signInViewModel.deleteAutoSignIn()
                val intent = Intent(requireActivity(), SignInActivity::class.java)
                mainActivity.finish()
                startActivity(intent)
            }

            loadImage(imageView, KIMJUNHO)

            composeView.webViewHeader(headerText = "MY")

        }
    }

    override fun observeEvent() {
    }
}