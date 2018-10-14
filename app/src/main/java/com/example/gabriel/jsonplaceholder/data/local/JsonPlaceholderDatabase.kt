package com.example.gabriel.jsonplaceholder.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User

@Database(
    entities = [
        User::class
    ],
    version = 1,
    exportSchema = false
)
abstract class JsonPlaceholderDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}