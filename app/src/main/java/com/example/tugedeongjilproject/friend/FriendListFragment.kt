package com.example.tugedeongjilproject.friend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.databinding.FragmentFriendListBinding

class FriendListFragment : BaseFragment<FragmentFriendListBinding>(R.layout.fragment_friend_list){

    private val friendList = arrayListOf<FriendListData>().apply {
        add(FriendListData("","제목","본문"))
    }

    override fun initView() {
        binding.run {
            rvFriend.run {
                layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
                rvFriend.setHasFixedSize(true)
            }
        }
    }

    override fun observeEvent() {}

    override fun onResume() {
        super.onResume()
        binding.run {
            rvFriend.adapter = FriendListAdapter(friendList)
        }
    }
}