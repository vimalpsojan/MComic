package com.srl.mob.mcomic.viewModel

import android.util.ArrayMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.srl.mob.mcomic.di.ViewModelSubComponent

import javax.inject.Inject
import java.util.concurrent.Callable

class ComicViewModelFactory @Inject
constructor(viewModelSubComponent: ViewModelSubComponent) : ViewModelProvider.Factory {
    private val creators: ArrayMap<Class<*>, Callable<out ViewModel>> = ArrayMap()

    init {

        // View models cannot be injected directly because they won't be bound to the owner's view model scope.
        creators[ComicListViewModel::class.java] = Callable<ViewModel> { viewModelSubComponent.comicListViewModel() }
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }
        try {
            return creator.call() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}
