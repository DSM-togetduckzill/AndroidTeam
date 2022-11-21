package com.example.tugedeongjilproject.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.util.image.SPIDER_MAN
import com.example.tugedeongjilproject.util.image.loadImage

class PopularAdapter(private val context: Context, private val popularList: List<HomeData>?): BaseAdapter() {

    @SuppressLint("ViewHolder", "InflateParams", "SetTextI18n")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_home_popular,null)

        val tvItemMainTopNum = view.findViewById<TextView>(R.id.tv_item_home_top_num)
        val tvItemMainBottom = view.findViewById<TextView>(R.id.tv_item_home_bottom)
        val imgItemHome = view.findViewById<ImageView>(R.id.img_item_home)
        val btnItemMain = view.findViewById<Button>(R.id.btn_item_main)

        tvItemMainTopNum.text = popularList!![p0].num.toString()+"명"
        tvItemMainBottom.text = popularList[p0].name
        loadImage(imgItemHome, popularList[p0].imageUrl)

        btnItemMain.setOnClickListener {
            Toast.makeText(context, tvItemMainBottom.text.toString()+"방 참여 신청을 성공하셨습니다!", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun getItem(p0: Int): Any = popularList!![p0]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = popularList!!.size
}