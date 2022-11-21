package com.example.tugedeongjilproject.chat

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.util.image.loadImage

class ChatAdapter(
    private val context: Context,
    private val chatList: List<ChatData>,
    private val chatFragment: ChatFragment,
    private val clickable: Boolean = true,
    private val unknown: Boolean = true
    ): BaseAdapter() {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_chat,null)

        val tvItemChatTitle: TextView = view.findViewById(R.id.tv_item_chat_title)
        val tvItemChatContent: TextView = view.findViewById(R.id.tv_item_chat_content)
        val imgItemMain: ImageView = view.findViewById(R.id.img_item_main)

        tvItemChatTitle.text = chatList[p0].title
        tvItemChatContent.text = chatList[p0].content
        loadImage(imgItemMain, chatList[p0].imageUrl)

        if(clickable){
            view.setOnClickListener {
                chatFragment.startChat(tvItemChatTitle.text.toString(),unknown)
            }
        }


        return view
    }

    override fun getItem(p0: Int): Any = chatList[p0]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = chatList.size

}