package com.example.androidstudy.ui.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudy.R
import com.example.androidstudy.ui.presentation.models.Item

class RecyclerAdapter(private val onItemClick: (Item) -> Unit) : ListAdapter<Item, RecyclerAdapter.ItemViewHolder>(
    ItemDiffCallBack()
) {

    class ItemViewHolder(itemView: View, private val onItemClick: (Item) -> Unit) : RecyclerView.ViewHolder(itemView){
        val topTextView : TextView = itemView.findViewById(R.id.news_info_title_text)
        val bottomTextView : TextView = itemView.findViewById(R.id.news_info_description_text)
        val imageview : ImageView = itemView.findViewById(R.id.news_image)

        fun bind(item: Item) {
            topTextView.text = item.title
            bottomTextView.text = item.description
            imageview.setImageResource(item.imageRes)
            itemView.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item,parent,false)
        return ItemViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener{
            val item = getItem(position)
            onItemClick(item)
        }
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