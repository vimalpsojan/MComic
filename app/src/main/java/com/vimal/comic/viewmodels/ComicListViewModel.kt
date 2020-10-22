package com.vimal.comic.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vimal.comic.models.Comic
import com.vimal.comic.repositories.ComicListRepository
import com.vimal.core.models.LoadingMessageData
import com.vimal.core.models.MessageData
import com.vimal.core.viewmodel.BaseViewModel

class ComicListViewModel @ViewModelInject constructor(private val repository: ComicListRepository):BaseViewModel() {

    private val comicListObservable =  MutableLiveData<List<Comic>?>()
    val comicList: LiveData<List<Comic>?> = comicListObservable

    init {
        repository.getList().subscribe({result->
            if(result.isSuccess){
                comicListObservable.value = result.data
            }else{
                //TODO show error
            }

        },{
            showNetworkError()
        })
    }

    fun showNetworkError(

    ) {
        val loadingMessageData = LoadingMessageData()
        loadingMessageData.isLoading = false
        showLoading(loadingMessageData)

        val messageData = MessageData()
        messageData.messageStr = "Net Work Error"
        showInfoMessage(messageData)
    }
}