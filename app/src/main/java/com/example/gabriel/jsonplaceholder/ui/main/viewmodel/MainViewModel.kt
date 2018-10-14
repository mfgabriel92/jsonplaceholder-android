package com.example.gabriel.jsonplaceholder.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gabriel.jsonplaceholder.data.UserRepository
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    lateinit var disposable: DisposableObserver<List<User>>

    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var result: MutableLiveData<List<User>> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun fetchAllUsers() {
        disposable = object : DisposableObserver<List<User>>() {
            override fun onComplete() {
            }

            override fun onNext(critpcurrencies: List<User>) {
                result.postValue(critpcurrencies)
                loading.postValue(false)
            }

            override fun onError(e: Throwable) {
                error.postValue(e.message)
                loading.postValue(false)
            }
        }

        repository.fetchAllUsers()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(disposable)
    }

    fun loading(): LiveData<Boolean> = loading
    fun result(): LiveData<List<User>> = result
    fun error(): LiveData<String> = error
}