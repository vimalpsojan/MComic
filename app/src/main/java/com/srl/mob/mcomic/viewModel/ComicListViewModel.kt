package com.srl.mob.mcomic.viewModel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.srl.mob.mcomic.api.ComicWorker
import com.srl.mob.mcomic.model.Comic
import javax.inject.Inject


class ComicListViewModel @Inject constructor(@NonNull application:Application) : AndroidViewModel(application)
{
    private val comicListObservable: LiveData<List<Comic>> = ComicWorker.instance.getComicList()

    fun getComicListObservable(): LiveData<List<Comic>>
    {
        return comicListObservable
    }
}