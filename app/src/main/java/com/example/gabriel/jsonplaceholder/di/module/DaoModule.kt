package com.example.gabriel.jsonplaceholder.di.module

import com.example.gabriel.jsonplaceholder.data.local.JsonPlaceholderDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {
    @Provides
    @Singleton
    fun provideUserDao(database: JsonPlaceholderDatabase) = database.userDao()
}