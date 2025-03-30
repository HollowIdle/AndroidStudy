package com.example.androidstudy.ui.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidstudy.R
import com.example.androidstudy.ui.domain.models.DomainPost

class RecyclerAdapter(
    private val items : List<DomainPost>,
    private val onItemClick: (DomainPost) -> Unit) : ListAdapter<DomainPost, RecyclerAdapter.ItemViewHolder>(ItemDiffCallBack())
{

    class ItemViewHolder(
        itemView: View,
        private val items : List<DomainPost>,
        private val onItemClick: (DomainPost) -> Unit) : RecyclerView.ViewHolder(itemView)
    {
        val topTextView : TextView = itemView.findViewById(R.id.news_info_title_text)
        val bottomTextView : TextView = itemView.findViewById(R.id.news_info_description_text)
        val imageview : ImageView = itemView.findViewById(R.id.news_image)

        fun bind(post: DomainPost) {
            topTextView.text = post.title
            bottomTextView.text = post.description

            Glide.with(imageview.context)
                .load("${post.urlToImage}")
                .into(imageview)

            itemView.setOnClickListener {
                onItemClick(post)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item,parent,false)

        return ItemViewHolder(view, items, onItemClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ItemDiffCallBack : DiffUtil.ItemCallback<DomainPost>(){
    override fun areItemsTheSame(oldPost: DomainPost, newPost: DomainPost): Boolean {
        return oldPost.id == newPost.id
    }

    override fun areContentsTheSame(oldPost: DomainPost, newPost: DomainPost): Boolean {
        return oldPost == newPost
    }
}