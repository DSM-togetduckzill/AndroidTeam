package com.example.tugedeongjilproject.home

import android.content.Intent
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.base.BaseFragment
import com.example.tugedeongjilproject.databinding.FragmentHomeBinding
import com.example.tugedeongjilproject.home.room.EnterRoomActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val popularList = listOf(
        HomeData(null,20,"스파이더맨"),
        HomeData(null,10,"지브리"),
        HomeData(null,5,"자프 화이팅!!")
    )

    private val newList = listOf(
        HomeData(null,0,"지브라"),
        HomeData(null,0,"지브라"),
        HomeData(null,0,"지브라"),
        HomeData(null,0,"지브라")
    )

    override fun initView() {

        tvSecondSetting()

        binding.run {

            val popularAdapter = PopularAdapter(requireActivity(),popularList)
            mainListView.adapter = popularAdapter

            mainRecyclerview.apply {
                adapter = NewAdapter(newList)
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                setHasFixedSize(true)
            }

            mainFirstLayout.setOnClickListener {
            }
            mainSecondLayout.setOnClickListener {
                startActivity(Intent(requireActivity(), EnterRoomActivity::class.java))
            }
        }
    }

    override fun observeEvent() {}

    private fun tvSecondSetting(){
        binding.run {
            val textData = SpannableStringBuilder(tvSecond.text.toString())

            textData.setSpan(ForegroundColorSpan(Color.parseColor("#F9820F")),2,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            textData.setSpan(ForegroundColorSpan(Color.parseColor("#F9820F")),6,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            tvSecond.text = textData
        }
    }
}