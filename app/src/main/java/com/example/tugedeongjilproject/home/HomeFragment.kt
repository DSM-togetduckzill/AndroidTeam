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
import com.example.tugedeongjilproject.util.WebViewHelperActivity
import com.example.tugedeongjilproject.util.image.KIMJUNHO
import com.example.tugedeongjilproject.util.image.KIMUICHAN
import com.example.tugedeongjilproject.util.image.OHJEONGSU
import com.example.tugedeongjilproject.util.image.SON
import com.example.tugedeongjilproject.util.image.SPIDER_MAN
import com.example.tugedeongjilproject.util.image.YANGJIWON
import com.example.tugedeongjilproject.util.image.ZIBRI
import com.example.tugedeongjilproject.util.image.loadImage

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val popularList = listOf(
        HomeData(SPIDER_MAN,20,"스파이더맨"),
        HomeData(ZIBRI,10,"지브리"),
        HomeData(SON,5,"손흥민 화이팅!!")
    )

    private val newList = listOf(
        HomeData(KIMUICHAN,0,"김의찬"),
        HomeData(KIMJUNHO,1,"김준호"),
        HomeData(YANGJIWON,2,"양지원"),
        HomeData(OHJEONGSU,3,"오정수")
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
                val intent = Intent(requireActivity(), WebViewHelperActivity::class.java)
                intent.putExtra("url","https://togetduckzill-fontend.vercel.app/spider")
                intent.putExtra("header", "랜덤랜덤")
                intent.putExtra("add",true)
                startActivity(intent)
            }
            mainSecondLayout.setOnClickListener {
                startActivity(Intent(requireActivity(), EnterRoomActivity::class.java))
            }

            loadImage(imgMainFirst, SPIDER_MAN)
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