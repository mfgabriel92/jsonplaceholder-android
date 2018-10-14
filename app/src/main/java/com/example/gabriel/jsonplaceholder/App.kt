package com.example.gabriel.jsonplaceholder

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.example.gabriel.jsonplaceholder.di.DaggerAppComponent
import com.example.gabriel.jsonplaceholder.di.module.AppModule
import com.example.gabriel.jsonplaceholder.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

    class App : Application(), HasActivityInjector, HasSupportFragmentInjector {
        @Inject
        lateinit var activityInjector: DispatchingAndroidInjector<Activity>

        @Inject
        lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

        override fun onCreate() {
            super.onCreate()
            DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule("https://jsonplaceholder.typicode.com/"))
                .build()
                .inject(this)
        }

        override fun activityInjector(): AndroidInjector<Activity> {
            return activityInjector
        }

        override fun supportFragmentInjector(): AndroidInjector<Fragment> {
            return fragmentInjector
        }
    }