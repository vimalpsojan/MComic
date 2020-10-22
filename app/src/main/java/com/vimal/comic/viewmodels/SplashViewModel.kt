package com.vimal.comic.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import com.vimal.core.viewmodel.BaseViewModel
import com.vimal.comic.R
import com.vimal.comic.repositories.SplashRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashViewModel @ViewModelInject constructor(private val repository: SplashRepository):BaseViewModel() {
    init {
        Observable.timer( repository.getWaiting(), TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                gotoNextScreen()
            }
    }

    private fun gotoNextScreen(){
        navigate(R.id.action_splashFragment_to_noteListFragment)
    }
}