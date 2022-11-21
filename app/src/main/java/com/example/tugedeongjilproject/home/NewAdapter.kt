package com.example.tugedeongjilproject.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.tugedeongjilproject.R
import com.example.tugedeongjilproject.util.image.loadImage

class NewAdapter(private val newList: List<HomeData>?): RecyclerView.Adapter<NewAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_new,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewAdapter.CustomViewHolder, position: Int) {
        holder.tvItemNew.text = newList!![position].name
        loadImage(holder.imgItemNew, newList[position].imageUrl)

        holder.itemHomeNew.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = newList!!.size

    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgItemNew: ImageView = view.findViewById(R.id.img_item_new)
        val tvItemNew: TextView = view.findViewById(R.id.tv_item_new)
        val itemHomeNew: ConstraintLayout = view.findViewById(R.id.item_home_new)
    }
}