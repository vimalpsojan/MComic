package com.vimal.comic.datasources.remote

import com.vimal.comic.api.ComicAPIInterface
import com.vimal.comic.datasources.ComicListDataSource
import com.vimal.comic.models.Comic
import com.vimal.core.datasources.BaseRemote
import com.vimal.core.models.APIResult
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ComicListRemoteDataSource @Inject constructor(private val apiClient: ComicAPIInterface):BaseRemote(), ComicListDataSource.Remote {

    override fun getList(): Single<APIResult<List<Comic>>> {
        return apiClient.getComicList().createArrayResult()
    }

}