package com.example.tugedeongjilproject.friend

import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.databinding.FragmentFriendListBinding
import com.example.tugedeongjilproject.util.WebViewHeader
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
            composeView.apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    WebViewHeader(
                        btnBack = false,
                        onBackPressed = {  },
                        headerText = "친구",
                        btnMenu = false
                    )
                }
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