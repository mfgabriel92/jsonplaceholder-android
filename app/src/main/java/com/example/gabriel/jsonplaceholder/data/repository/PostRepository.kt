package com.example.gabriel.jsonplaceholder.data.repository

import android.util.Log
import com.example.gabriel.jsonplaceholder.data.local.PostDao
import com.example.gabriel.jsonplaceholder.data.local.entity.post.Post
import com.example.gabriel.jsonplaceholder.data.remote.JsonPlaceholderApi
import io.reactivex.Observable
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: JsonPlaceholderApi, private val dao: PostDao) {
    fun fetchAllPosts(): Observable<List<Post>> {
        return api.fetchAllPosts().doOnNext {
            Log.d("PostRepository", it.toString())
            dao.insert(it)
        }
    }
}