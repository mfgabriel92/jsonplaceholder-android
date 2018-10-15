package com.example.gabriel.jsonplaceholder.di.module

import android.app.Application
import androidx.room.Room
import com.example.gabriel.jsonplaceholder.data.local.db.JsonPlaceholderDatabase
import com.example.gabriel.jsonplaceholder.data.local.db.migrations.Migration1To2
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideDatabase(app: Application): JsonPlaceholderDatabase = Room.databaseBuilder(
        app,
        JsonPlaceholderDatabase::class.java,
        "jsonplaceholder"
    ).addMigrations(Migration1To2()).build()
}