package com.srl.mob.mcomic.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.srl.mob.mcomic.model.Comic
import com.srl.mob.mcomic.model.DefaultArryResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Class to provide data for the app from server.
 * Data communication between server and app is done here
 */
class ComicWorker private constructor()
{

    companion object {
        val instance: ComicWorker by lazy {
            ComicWorker()
        }
    }

    val comicApiClient=APIClient.getInstance("https://gateway.marvel.com/v1/public/").create(ComicAPIInterface::class.java)

    fun getComicList(): LiveData<List<Comic>>
    {
        val data = MutableLiveData<List<Comic>>()
        comicApiClient.getComicList().enqueue(object :Callback<DefaultArryResponce<Comic>>{
            override fun onFailure(call: Call<DefaultArryResponce<Comic>>?, t: Throwable?)
            {
                data.value=null
            }

            override fun onResponse(call: Call<DefaultArryResponce<Comic>>?,
                                    response: Response<DefaultArryResponce<Comic>>?)
            {
                if (response?.isSuccessful==true && response.body()?.data?.result!=null)
                {
                    data.value= response.body().data?.result
                }
                else
                {
                    data.value=null
                }
            }
        })

        return data
    }
}