package com.example.gabriel.jsonplaceholder.data.remote

import com.example.gabriel.jsonplaceholder.data.local.entity.post.Post
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User
import io.reactivex.Observable
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("posts")
    fun fetchAllPosts(): Observable<List<Post>>

    @GET("users")
    fun fetchAllUsers(): Observable<List<User>>
}