package com.vimal.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vimal.core.models.Action
import com.vimal.core.models.Event

class BaseActivityViewModel :BaseViewModel(){

    private val actionPerformedLiveData = MutableLiveData<Event<Action>>()
    val actionPerformed: LiveData<Event<Action>> = actionPerformedLiveData

    fun actionPerformed(actions:Action){
        actionPerformedLiveData.value = Event(actions)
    }
}