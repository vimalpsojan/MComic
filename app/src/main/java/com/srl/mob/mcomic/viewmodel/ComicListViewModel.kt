package com.srl.mob.mcomic.viewmodel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srl.mob.mcomic.api.ComicWorker
import com.srl.mob.mcomic.model.Comic


class ComicListViewModel constructor(@NonNull application:Application) : AndroidViewModel(application)
{
    val comicListObservable: LiveData<List<Comic>> = ComicWorker.instance.getComicList()

    val selectedComic:MutableLiveData<Comic> = MutableLiveData()

    fun setSelectedComic(comic:Comic)
    {
        selectedComic.value=comic
    }



}