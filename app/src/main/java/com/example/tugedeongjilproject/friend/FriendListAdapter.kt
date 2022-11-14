package com.example.tugedeongjilproject.friend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugedeongjilproject.R

class FriendListAdapter(
    private val arrayList: ArrayList<FriendListData>,
    private val friendListFragment: FriendListFragment
    ): RecyclerView.Adapter<FriendListAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.tvItemChatTitle.text = arrayList[position].title
        holder.tvItemChatContent.text = arrayList[position].content
        holder.view.setOnClickListener {
            friendListFragment.startChat(holder.tvItemChatTitle.text.toString())
        }
    }

    override fun getItemCount(): Int = arrayList.size

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgItemMain = itemView.findViewById<ImageView>(R.id.img_item_main)
        val tvItemChatTitle = itemView.findViewById<TextView>(R.id.tv_item_chat_title)
        val tvItemChatContent = itemView.findViewById<TextView>(R.id.tv_item_chat_content)
        val view = itemView
    }

}