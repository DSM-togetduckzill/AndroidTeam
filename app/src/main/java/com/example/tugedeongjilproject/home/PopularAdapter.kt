package com.example.tugedeongjilproject.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.example.tugedeongjilproject.R

class PopularAdapter(private val context: Context, private val popularList: List<HomeData>?): BaseAdapter() {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_home_popular,null)

        val tvItemMainTopNum = view.findViewById<TextView>(R.id.tv_item_home_top_num)
        val tvItemMainBottom = view.findViewById<TextView>(R.id.tv_item_home_bottom)
        val btnItemMain = view.findViewById<Button>(R.id.btn_item_main)

        tvItemMainTopNum.text = popularList!![p0].num.toString()
        tvItemMainBottom.text = popularList[p0].name

        btnItemMain.setOnClickListener {

        }

        return view
    }

    override fun getItem(p0: Int): Any = popularList!![p0]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = popularList!!.size
}