package com.example.gabriel.jsonplaceholder.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.gabriel.jsonplaceholder.ui.main.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideMainViewModel(factory: MainViewModelFactory): ViewModelProvider.Factory = factory
}