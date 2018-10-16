package com.example.gabriel.jsonplaceholder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gabriel.jsonplaceholder.data.local.entity.post.Post
import com.example.gabriel.jsonplaceholder.data.local.entity.post.PostWithUser
import io.reactivex.Observable

@Dao
interface PostDao {
    @Query("SELECT p.id, p.title, p.body, u.name, u.username FROM posts p INNER JOIN users u ON p.userId = u.id")
    fun fetchAllPostsAndUsers(): Observable<List<PostWithUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<Post>)
}