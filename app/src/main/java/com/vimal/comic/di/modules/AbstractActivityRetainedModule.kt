package com.vimal.comic.di.modules

import com.vimal.comic.datasources.ComicListDataSource
import com.vimal.comic.datasources.SplashDataSource
import com.vimal.comic.datasources.remote.ComicListRemoteDataSource
import com.vimal.comic.repositories.ComicListRepository
import com.vimal.comic.repositories.SplashRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class AbstractActivityRetainedModule {

    //Splash
    @Binds
    abstract fun splashViewModelRepository(impl: SplashDataSource): SplashRepository

    //List
    @Binds
    abstract fun comicListDataSource(impl: ComicListDataSource): ComicListRepository

    @Binds
    abstract fun comicListRemoteDataSource(impl: ComicListRemoteDataSource): ComicListDataSource.Remote

}