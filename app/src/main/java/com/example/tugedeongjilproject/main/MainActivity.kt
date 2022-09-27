package com.example.tugedeongjilproject.main

import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseActivity
import com.example.tugedeongjilproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), BottomNavigationView.OnNavigationItemSelectedListener {

    private var bottomNavigationView: BottomNavigationView? = null

    override fun initView() {
        binding.mainPager.adapter = ViewPagerAdapter(this)

        binding.mainPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.mainNavigation.menu.getItem(position).isChecked = true
                }
            }
        )

        binding.mainNavigation.setOnNavigationItemSelectedListener(this)

        binding.mainPager.isUserInputEnabled = false

        bottomNavigationView = binding.mainNavigation
        bottomNavigationView!!.setOnNavigationItemSelectedListener(this)
        bottomNavigationView!!.selectedItemId = R.id.menu_home
    }

    override fun observeEvent() {}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.run {
            when (item.itemId) {
                R.id.menu_home -> {
                    mainPager.currentItem = 0
                    return true
                }
                R.id.menu_chat -> {
                    mainPager.currentItem = 1
                    return true
                }
                R.id.menu_friend -> {
                    mainPager.currentItem = 2
                    return true
                }
                R.id.menu_my -> {
                    mainPager.currentItem = 3
                    return true
                }
            }
            return false
        }
    }
}