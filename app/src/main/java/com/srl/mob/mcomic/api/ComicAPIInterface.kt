package com.srl.mob.mcomic.api

import com.srl.mob.mcomic.constants.APIurls
import com.srl.mob.mcomic.model.Comic
import com.srl.mob.mcomic.model.DefaultArryResponce
import com.srl.mob.mcomic.model.DefaultResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Interface class for retrofit
 */
interface ComicAPIInterface
{

    @GET(APIurls.listComic)
    fun getComicList(): Call<DefaultArryResponce<Comic>>

    @GET(APIurls.comicDetails)
    fun getComicDetail(@Path("comic_id")comicId:Long=0): Call<DefaultResponce<Comic>>

}