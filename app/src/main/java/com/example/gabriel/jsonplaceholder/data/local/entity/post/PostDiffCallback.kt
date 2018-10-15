package com.example.gabriel.jsonplaceholder.data.local.entity.post

import androidx.recyclerview.widget.DiffUtil

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.pid == newItem.pid
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}