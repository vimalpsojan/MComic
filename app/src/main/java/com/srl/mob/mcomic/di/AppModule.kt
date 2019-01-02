package com.srl.mob.mcomic.di

import dagger.Module
import androidx.lifecycle.ViewModelProvider
import com.srl.mob.mcomic.viewModel.ComicViewModelFactory
import dagger.Provides
import javax.inject.Singleton



@Module(subcomponents = [ViewModelSubComponent::class])
class AppModule
{
    @Singleton
    @Provides
    fun provideViewModelFactory(viewModelSubComponent: ViewModelSubComponent.Builder): ViewModelProvider.Factory
    {
        return ComicViewModelFactory(viewModelSubComponent.build())
    }
}