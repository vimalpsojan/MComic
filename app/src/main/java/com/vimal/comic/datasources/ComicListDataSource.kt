package com.vimal.comic.datasources

import com.vimal.comic.models.Comic
import com.vimal.comic.repositories.ComicListRepository
import com.vimal.core.models.APIResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ComicListDataSource @Inject constructor(private val remote:Remote): ComicListRepository {

    override fun getList(): Single<APIResult<List<Comic>>> {
        return remote.getList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    interface Remote{
        fun getList(): Single<APIResult<List<Comic>>>
    }
}