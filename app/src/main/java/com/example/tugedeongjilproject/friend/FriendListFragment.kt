package com.example.tugedeongjilproject.friend

import android.content.Intent
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.chat.ChatData
import com.example.tugedeongjilproject.databinding.FragmentFriendListBinding
import com.example.tugedeongjilproject.util.WebViewHeader
import com.example.tugedeongjilproject.util.WebViewHelperActivity
import com.example.tugedeongjilproject.util.image.buddha
import com.example.tugedeongjilproject.util.image.canner
import com.example.tugedeongjilproject.util.image.cat
import com.example.tugedeongjilproject.util.image.heart
import com.example.tugedeongjilproject.util.webViewHeader
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FriendListFragment : BaseFragment<FragmentFriendListBinding>(R.layout.fragment_friend_list){

    private val friendListViewModel: FriendListViewModel by viewModels()

    private val friendList = arrayListOf<FriendListData>().apply {
        add(FriendListData(cat,"김기영","우리집 고양이 영웅이"))
        add(FriendListData(heart,"김민성","땡땡아 사랑해~~!"))
        add(FriendListData(null,"문정민","잘가고"))
        add(FriendListData(buddha,"오상우","인생이란 뭘까.."))
        add(FriendListData(canner,"임세현","준호야 죽어도 코드는 남아"))
        add(FriendListData(heart,"주보미","나도"))
    }

    override fun initView() {
        binding.run {
            tvFriend.text = "친구("+friendList.size+")"
            rvFriend.run {
                layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
                rvFriend.setHasFixedSize(true)
            }
            composeView.webViewHeader(headerText = "친구")
        }
    }

    override fun observeEvent() {}

    override fun onResume() {
        super.onResume()
        binding.run {
            rvFriend.adapter = FriendListAdapter(friendList, this@FriendListFragment)
        }
    }

    fun startChat(name: String){
        val intent = Intent(requireContext(), WebViewHelperActivity::class.java)
        intent.putExtra("url","https://togetduckzill-fontend.vercel.app/chat")
        intent.putExtra("header",name)
        intent.putExtra("add",true)
        startActivity(intent)
    }
}