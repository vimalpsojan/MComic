package com.vimal.comic.repositories

import com.vimal.comic.models.Comic
import com.vimal.core.models.APIResult
import io.reactivex.rxjava3.core.Single

interface ComicListRepository {
    fun getList(): Single<APIResult<List<Comic>>>
}