package com.srl.mob.mcomic.di

import com.srl.mob.mcomic.viewModel.ComicListViewModel
import dagger.Subcomponent

@Subcomponent
interface ViewModelSubComponent
{
    @Subcomponent.Builder
    interface Builder
    {
        fun build(): ViewModelSubComponent
    }

    fun comicListViewModel(): ComicListViewModel
}