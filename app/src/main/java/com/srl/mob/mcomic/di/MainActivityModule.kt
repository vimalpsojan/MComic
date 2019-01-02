package com.srl.mob.mcomic.di

import dagger.Module
import com.srl.mob.mcomic.activities.MainActivity
import dagger.android.ContributesAndroidInjector



@Module
abstract class MainActivityModule
{
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}