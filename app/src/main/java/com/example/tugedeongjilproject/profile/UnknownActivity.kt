package com.example.tugedeongjilproject.profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.tugedeongjilproject.databinding.UnknownProfileBinding
import com.example.tugedeongjilproject.dialog.CustomDialogFragment
import com.example.tugedeongjilproject.util.webViewHeader

class UnknownActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = UnknownProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = CustomDialogFragment()
        val btn= arrayOf("취소","확인")

        val name = intent.getStringExtra("name") ?: ""

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
                "context" to "신고 시 대화 내용 검토 후 신고 처리 됩니다.",
                "btnData" to btn
            )
            dialog.setButtonClickListener(object: CustomDialogFragment.OnButtonClickListener {
                override fun onButton1Clicked() {
                    //아무일도 x
                }
                override fun onButton2Clicked() {
                    //확인
                    //신고
                    Toast.makeText(this@UnknownActivity, "신고되었습니다.", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.show(supportFragmentManager, "CustomDialog")
        }

        binding.forthBox.setOnClickListener {
            dialog.arguments= bundleOf(
                "title" to "차단하시겠습니까?",
                "context" to "상대방을 차단하면 더 이상 해당 유저와 매칭 및 채팅이 불가능합니다.",
                "btnData" to btn
            )
            dialog.setButtonClickListener(object: CustomDialogFragment.OnButtonClickListener {
                override fun onButton1Clicked() {
                    //아무일도 x
                }
                override fun onButton2Clicked() {
                    //확인
                    //차단
                    Toast.makeText(this@UnknownActivity, "차단되었습니다.", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.show(supportFragmentManager, "CustomDialog")
        }

        binding.forthBox.setOnClickListener {
            dialog.arguments= bundleOf(
                "title" to "채팅방을 나가시겠습니까?",
                "context" to "나가기를 하면 대화내용이 모두 삭제되고 채팅목록에서도 삭제됩니다.",
                "btnData" to btn
            )
            dialog.setButtonClickListener(object: CustomDialogFragment.OnButtonClickListener {
                override fun onButton1Clicked() {
                    //아무일도 x
                }
                override fun onButton2Clicked() {
                    //확인
                    //익명 채팅 목록에서 삭제
                    Toast.makeText(this@UnknownActivity, "차단되었습니다.", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.show(supportFragmentManager, "CustomDialog")
        }

        binding.composeView.webViewHeader(
            btnBack = true,
            onBackPressed = { finish() },
            headerText = name
        )
    }
}