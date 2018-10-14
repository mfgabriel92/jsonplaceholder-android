package com.example.gabriel.jsonplaceholder.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User
import com.example.gabriel.jsonplaceholder.data.local.entity.user.UserDiffCallback
import com.example.gabriel.jsonplaceholder.databinding.UserListItemBinding

class MainAdapter(val context: Context) : ListAdapter<User, MainAdapter.ViewHolder>(UserDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)

        holder.apply {
            bind(user)
            itemView.tag = user
        }
    }

    inner class ViewHolder(private val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(u: User) {
            binding.apply {
                user = u
                executePendingBindings()
            }
        }
    }
}