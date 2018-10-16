package com.example.gabriel.jsonplaceholder.data.repository

import com.example.gabriel.jsonplaceholder.data.local.PostDao
import com.example.gabriel.jsonplaceholder.data.local.entity.post.PostWithUser
import com.example.gabriel.jsonplaceholder.data.remote.JsonPlaceholderApi
import io.reactivex.Observable
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: JsonPlaceholderApi, private val dao: PostDao) {
    fun fetchAllPostsAndUsers(): Observable<List<PostWithUser>> {
        return dao.fetchAllPostsAndUsers().doOnError {
            api.fetchAllPosts().doOnNext { posts -> dao.insert(posts) }
        }
    }
}