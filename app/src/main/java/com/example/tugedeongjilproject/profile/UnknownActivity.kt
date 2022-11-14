package com.example.tugedeongjilproject.profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.tugedeongjilproject.databinding.UnknownProfileBinding
import com.example.tugedeongjilproject.dialog.CustomDialogFragment

class UnknownActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = UnknownProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = CustomDialogFragment()
        val btn= arrayOf("취소","확인")

        binding.secondBox.setOnClickListener {
            dialog.arguments= bundleOf(
                "title" to "공개하시겠습니까?",
                "context" to "익명을 공개하면 상대방에게 자신의 프로필이 보여지게 됩니다.",
                "btnData" to btn
            )
            dialog.setButtonClickListener(object: CustomDialogFragment.OnButtonClickListener {
                override fun onButton1Clicked() {
                    //아무일도 x
                }
                override fun onButton2Clicked() {
                    //확인
                    //친구프로필로 전환
                }
            })
            dialog.show(supportFragmentManager, "CustomDialog")
        }

        binding.thirdBox.setOnClickListener {
            dialog.arguments= bundleOf(
                "title" to "신고하시겠습니까?",
                "context" to "상대방을 신고하면 대화 내용 검토 후 신고 처리 됩니다.",
                "btnData" to btn
            )
            dialog.setButtonClickListener(object: CustomDialogFragment.OnButtonClickListener {
                override fun onButton1Clicked() {
                    //아무일도 x
                }
                override fun onButton2Clicked() {
                    //확인 눌렀을 때
                    //신고..?
                    Toast.makeText(this@UnknownActivity, "신고되었습니다.", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.show(supportFragmentManager, "CustomDialog")
        }
    }
}