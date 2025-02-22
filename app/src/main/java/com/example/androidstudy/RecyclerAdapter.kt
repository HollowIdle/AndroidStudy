package com.example.androidstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter() : ListAdapter<Item,RecyclerAdapter.ItemViewHolder>(ItemDiffCallBack()) {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val topTextView : TextView = itemView.findViewById(R.id.title_text)
        val bottomTextView : TextView = itemView.findViewById(R.id.description_text)
        val imageview : ImageView = itemView.findViewById(R.id.news_image)

        fun bind(item: Item) {
            topTextView.text = item.title
            bottomTextView.text = item.description
            imageview.setImageResource(item.imageRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ItemDiffCallBack : DiffUtil.ItemCallback<Item>(){
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}