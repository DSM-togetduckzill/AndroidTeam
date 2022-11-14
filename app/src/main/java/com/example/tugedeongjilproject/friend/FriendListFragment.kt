package com.example.tugedeongjilproject.friend

import android.content.Intent
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.databinding.FragmentFriendListBinding
import com.example.tugedeongjilproject.util.WebViewHeader
import com.example.tugedeongjilproject.util.WebViewHelperActivity
import com.example.tugedeongjilproject.util.webViewHeader
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FriendListFragment : BaseFragment<FragmentFriendListBinding>(R.layout.fragment_friend_list){

    private val friendListViewModel: FriendListViewModel by viewModels()

    private val friendList = arrayListOf<FriendListData>().apply {
        add(FriendListData("","제목","본문"))
    }

    override fun initView() {
        binding.run {
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