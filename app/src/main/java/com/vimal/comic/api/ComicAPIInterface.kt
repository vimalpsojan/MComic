package com.vimal.comic.api

import com.vimal.comic.constants.APIUrls
import com.vimal.comic.models.Comic
import com.vimal.core.models.DefaultArrayResponse
import com.vimal.core.models.DefaultResponse
import hu.akarnokd.rxjava3.retrofit.Result
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicAPIInterface {

    @GET(APIUrls.listComic)
    fun getComicList(): Single<Result<DefaultArrayResponse<Comic>>>

    @GET(APIUrls.comicDetails)
    fun getComicDetail(@Path("comic_id")comicId:Long=0): Single<Result<DefaultResponse<Comic>>>
}