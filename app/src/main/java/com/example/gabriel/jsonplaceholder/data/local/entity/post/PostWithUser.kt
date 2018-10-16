package com.example.gabriel.jsonplaceholder.data.local.entity.post

data class PostWithUser(
    val id: Int,
    val title: String,
    val body: String,
    val name: String,
    val username: String
)