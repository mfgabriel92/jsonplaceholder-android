package com.example.gabriel.jsonplaceholder.data.repository

import com.example.gabriel.jsonplaceholder.data.local.UserDao
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User
import com.example.gabriel.jsonplaceholder.data.remote.JsonPlaceholderApi
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: JsonPlaceholderApi, private val dao: UserDao) {
    fun fetchAllUsers(): Observable<List<User>> {
        return api.fetchAllUsers().doOnNext {
            dao.insert(it)
        }
    }
}