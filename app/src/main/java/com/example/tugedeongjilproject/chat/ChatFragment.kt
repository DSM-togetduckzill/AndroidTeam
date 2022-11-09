package com.example.tugedeongjilproject.chat

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.databinding.FragmentChatBinding
import com.example.tugedeongjilproject.util.webViewHeader

class ChatFragment : BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {

    private val readyList = arrayListOf<ChatData>(
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),

        )

    private val noNameList = arrayListOf<ChatData>(
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),

        )

    private val friendList = arrayListOf<ChatData>(
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),
        ChatData(null,"제목","본문"),

        )

    override fun initView() {
        val readyAdapter = ChatAdapter(requireContext(), readyList)
        val noNameAdapter = ChatAdapter(requireContext(), noNameList)
        val friendAdapter = ChatAdapter(requireContext(), friendList)

        binding.run {

            composeView.webViewHeader(headerText = "채팅")

            listReady.adapter = readyAdapter
            setListViewHeight(listReady)

            listNoName.adapter = noNameAdapter
            setListViewHeight(listNoName)

            listFriend.adapter = friendAdapter
            setListViewHeight(listFriend)

        }
    }

    override fun observeEvent() {}

    private fun setListViewHeight(listView: ListView) {
        val listAdapter = listView.adapter ?: return

        var totalHeight = 0
        val desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.width, View.MeasureSpec.AT_MOST)

        for(i in 0 until listAdapter.count){
            val listItem = listAdapter.getView(i,null,listView)
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
            totalHeight += listItem.measuredHeight-80
            Log.d("TAG", "setListViewHeight: $totalHeight")
        }
        val params: ViewGroup.LayoutParams = listView.layoutParams

        params.height = totalHeight
        listView.layoutParams = params

        listView.requestLayout()
    }

}