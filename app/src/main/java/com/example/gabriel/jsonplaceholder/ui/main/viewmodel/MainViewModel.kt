package com.example.gabriel.jsonplaceholder.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gabriel.jsonplaceholder.data.local.entity.post.PostWithUser
import com.example.gabriel.jsonplaceholder.data.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {
    private lateinit var disposable: DisposableObserver<List<PostWithUser>>

    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var result: MutableLiveData<List<PostWithUser>> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun fetchAllPostsAndUsers() {
        disposable = object : DisposableObserver<List<PostWithUser>>() {
            override fun onComplete() {
            }

            override fun onNext(postsAndUsers: List<PostWithUser>) {
                result.postValue(postsAndUsers)
                loading.postValue(false)
            }

            override fun onError(e: Throwable) {
                error.postValue(e.message)
                loading.postValue(false)
            }
        }

        repository.fetchAllPostsAndUsers()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(disposable)
    }

    fun loading(): LiveData<Boolean> = loading
    fun result(): LiveData<List<PostWithUser>> = result
    fun error(): LiveData<String> = error
}