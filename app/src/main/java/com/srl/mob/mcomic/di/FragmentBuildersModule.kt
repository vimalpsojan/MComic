package com.srl.mob.mcomic.di

import com.srl.mob.mcomic.frgments.ComicListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module
abstract class FragmentBuildersModule
{
    @ContributesAndroidInjector
    abstract fun contributeComicListFragment(): ComicListFragment
}