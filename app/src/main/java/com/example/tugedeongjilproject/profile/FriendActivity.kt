package com.example.tugedeongjilproject.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.tugedeongjilproject.databinding.FriendProfileBinding
import com.example.tugedeongjilproject.dialog.CustomDialogFragment
import com.example.tugedeongjilproject.util.webViewHeader


class FriendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FriendProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name") ?: ""

        binding.thirdBox.setOnClickListener {
            val dialog = CustomDialogFragment()
            val btn= arrayOf("취소","확인")
            dialog.arguments= bundleOf(
                "title" to "삭제하시겠습니까?",
                "context" to "친구를 삭제하면 더이상 채팅을 할 수 없습니다.",
                "btnData" to btn
            )
            dialog.setButtonClickListener(object: CustomDialogFragment.OnButtonClickListener {
                override fun onButton1Clicked() {
                    //아무일도 x
                }
                override fun onButton2Clicked() {
                    //확인
                    //삭제..?
                    Toast.makeText(this@FriendActivity, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
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