package com.example.gabriel.jsonplaceholder.di.module

import com.example.gabriel.jsonplaceholder.ui.main.MainActivity
import com.example.gabriel.jsonplaceholder.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}