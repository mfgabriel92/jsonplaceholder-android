package com.example.gabriel.jsonplaceholder.data.local.entity.post

import androidx.recyclerview.widget.DiffUtil

class PostDiffCallback : DiffUtil.ItemCallback<PostWithUser>() {
    override fun areItemsTheSame(oldItem: PostWithUser, newItem: PostWithUser): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostWithUser, newItem: PostWithUser): Boolean {
        return oldItem == newItem
    }
}