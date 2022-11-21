package com.example.tugedeongjilproject.chat

import android.content.Intent
import android.view.ViewGroup
import android.widget.ListView
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.databinding.FragmentChatBinding
import com.example.tugedeongjilproject.util.WebViewHelperActivity
import com.example.tugedeongjilproject.util.image.SON
import com.example.tugedeongjilproject.util.image.SPIDER_MAN2
import com.example.tugedeongjilproject.util.image.angstart
import com.example.tugedeongjilproject.util.image.beomjoedosi
import com.example.tugedeongjilproject.util.image.buddha
import com.example.tugedeongjilproject.util.image.canner
import com.example.tugedeongjilproject.util.image.cat
import com.example.tugedeongjilproject.util.image.heart
import com.example.tugedeongjilproject.util.image.masterE
import com.example.tugedeongjilproject.util.image.overwatch
import com.example.tugedeongjilproject.util.image.yungyesang
import com.example.tugedeongjilproject.util.webViewHeader

class ChatFragment : BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {

    private val readyList = arrayListOf<ChatData>(
        ChatData(beomjoedosi,"범죄도시","니 내 눈지 아니 ~"),
        ChatData(yungyesang,"윤계상","돈 받으러 왔는데 뭐 그런거까지"),
        ChatData(SON,"손흥민 화이팅!!", "우리나라 축구의 자존심"),
    )

    private val noNameList = arrayListOf<ChatData>(
        ChatData(null,"교회를 영어로","누구게~?"),
        ChatData(overwatch,"내 오른손의 흑염룡","오버워치2 같이 할래?"),
        ChatData(SPIDER_MAN2,"랜덤랜덤",""),
        ChatData(null,"불건전한 닉네임의 소환사","나는 어린 18세 팔로우 해줘"),
        ChatData(angstart,"익명이","앙스타 신카이 카나타"),
        ChatData(masterE,"떡튀순","나의 검은 당신의 것이오.."),
    )

    private val friendList = arrayListOf<ChatData>(
        ChatData(cat,"김기영","아니 준호 우리팀 애들 자프 너무 안해"),
        ChatData(canner,"임세현","준호야 코드 pr봐줘 ^^"),
        ChatData(null,"문정민","너랑은 끝이야!"),
        ChatData(buddha,"오상우","또 나만 갈구지 진짜"),
        ChatData(heart,"김민성","아니 준호야.."),
    )

    override fun initView() {
        val readyAdapter = ChatAdapter(requireContext(), readyList, this)
        val noNameAdapter = ChatAdapter(requireContext(), noNameList, this)
        val friendAdapter = ChatAdapter(requireContext(), friendList, this)

        binding.run {

            composeView.webViewHeader(headerText = "채팅")

            tvReady.text = "대기중인방("+readyList.size+")"
            listReady.adapter = readyAdapter
            setListViewHeight(listReady, readyList)

            tvNoName.text = "익명("+noNameList.size+")"
            listNoName.adapter = noNameAdapter
            setListViewHeight(listNoName, noNameList)

            tvFriend.text = "친구("+friendList.size+")"
            listFriend.adapter = friendAdapter
            setListViewHeight(listFriend, friendList)

        }
    }

    override fun observeEvent() {}

    private fun setListViewHeight(listView: ListView, list: List<ChatData>) {

        var totalHeight = 0

        for(i in list.indices){
            totalHeight += 230
        }
        val params: ViewGroup.LayoutParams = listView.layoutParams
        params.height = totalHeight
        listView.layoutParams = params

        listView.requestLayout()
    }

    fun startChat(name: String){
        val intent = Intent(requireContext(), WebViewHelperActivity::class.java)
        intent.putExtra("url","https://togetduckzill-fontend.vercel.app/chat")
        intent.putExtra("header",name)
        intent.putExtra("add",true)
        startActivity(intent)
    }

}