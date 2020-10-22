package com.vimal.core.datasources

import com.vimal.core.models.APIResult
import com.vimal.core.models.DefaultArrayResponse
import com.vimal.core.models.DefaultResponse
import hu.akarnokd.rxjava3.retrofit.Result
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import com.vimal.core.models.Error

abstract class BaseRemote {

    private fun <T> getError(response: Response<T>): Error {
        return Error.toError(response)
    }

    fun <T> Single<Result<DefaultResponse<T>>>.createResult(): Single<APIResult<T>> {
        return map {
            it.createResult()
        }
    }

    @Throws(Throwable::class)
    private fun <T> Result<DefaultResponse<T>>.createResult(): APIResult<T> {
        if (this.isError) {
            throw this.error()
        }
        val response = this.response()
        return if (response.isSuccessful && response.body()?.data != null)
            APIResult(response.code(), response.isSuccessful, response.body()?.data,null,response.message())
        else
            APIResult(response.code(), false, null, getError(response),response.message())
    }

    fun <T> Single<Result<DefaultArrayResponse<T>>>.createArrayResult(): Single<APIResult<List<T>>> {
        return map {
            it.createArrayResult()
        }
    }

    @Throws(Throwable::class)
    private fun <T> Result<DefaultArrayResponse<T>>.createArrayResult(): APIResult<List<T>> {
        if (this.isError) {
            throw this.error()
        }
        val response = this.response()
        return if (response.isSuccessful && response.body()?.data != null)
            APIResult(response.code(), response.isSuccessful, response.body()?.data?.result,null,response.message())
        else
            APIResult(response.code(), false, null, getError(response),response.message())
    }


}