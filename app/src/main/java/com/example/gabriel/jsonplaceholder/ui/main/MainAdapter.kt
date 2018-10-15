package com.example.gabriel.jsonplaceholder.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gabriel.jsonplaceholder.data.local.entity.post.Post
import com.example.gabriel.jsonplaceholder.data.local.entity.post.PostDiffCallback
import com.example.gabriel.jsonplaceholder.databinding.PostListItemBinding

class MainAdapter(val context: Context) : ListAdapter<Post, MainAdapter.ViewHolder>(PostDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = getItem(position)

        holder.apply {
            bind(post)
            itemView.tag = post
        }
    }

    inner class ViewHolder(private val binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(p: Post) {
            binding.apply {
                post = p
                executePendingBindings()
            }
        }
    }
}