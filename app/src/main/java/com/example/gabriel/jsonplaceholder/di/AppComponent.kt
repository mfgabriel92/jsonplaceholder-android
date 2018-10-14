package com.example.gabriel.jsonplaceholder.di

import com.example.gabriel.jsonplaceholder.App
import com.example.gabriel.jsonplaceholder.di.module.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
    @Component(modules = [
        AndroidInjectionModule::class,
        BuilderModule::class,
        AppModule::class,
        NetworkModule::class,
        DaoModule::class,
        ViewModelModule::class
    ])
    interface AppComponent {
        fun inject(app: App)
    }