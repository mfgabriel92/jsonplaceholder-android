package com.example.gabriel.jsonplaceholder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gabriel.jsonplaceholder.data.local.entity.post.Post
import io.reactivex.Single

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    fun fetchAll(): Single<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<Post>)
}