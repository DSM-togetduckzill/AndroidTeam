package com.example.tugedeongjilproject.chat

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.tugedeongjilproject.R

class ChatAdapter(private val context: Context, private val chatList: List<ChatData>): BaseAdapter() {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_chat,null)

        val tvItemChatTitle: TextView = view.findViewById(R.id.tv_item_chat_title)
        val tvItemChatContent: TextView = view.findViewById(R.id.tv_item_chat_content)

        tvItemChatTitle.text = chatList[p0].title
        tvItemChatContent.text = chatList[p0].content

        return view
    }

    override fun getItem(p0: Int): Any = chatList[p0]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = chatList.size

}