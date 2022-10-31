package com.example.tugedeongjilproject.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tugedeongjilproject.chat.ChatAdapter
import com.example.tugedeongjilproject.chat.ChatFragment
import com.example.tugedeongjilproject.home.HomeFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> ChatFragment()
            2 -> HomeFragment()
            else -> HomeFragment()
        }
    }

}