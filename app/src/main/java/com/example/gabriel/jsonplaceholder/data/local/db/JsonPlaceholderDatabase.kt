package com.example.gabriel.jsonplaceholder.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gabriel.jsonplaceholder.data.local.PostDao
import com.example.gabriel.jsonplaceholder.data.local.UserDao
import com.example.gabriel.jsonplaceholder.data.local.entity.post.Post
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User

@Database(
    entities = [
        User::class,
        Post::class
    ],
    version = 2,
    exportSchema = false
)
abstract class JsonPlaceholderDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun postDao(): PostDao
}