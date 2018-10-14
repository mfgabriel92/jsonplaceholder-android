package com.example.gabriel.jsonplaceholder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User
import io.reactivex.Single

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun fetchAll(): Single<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<User>)
}