package com.vimal.core.models

import org.json.JSONObject
import retrofit2.Response
import java.io.Serializable

class Error : Serializable {

    var errorCode: Int = 500
    var message: String? = null
    var trace: String? = null
    var parameters: JSONObject? = null
    var url: String? = null
    var method: String? = null

    companion object{
        fun <T>toError(response: Response<T>):Error{
            val error = Error()
            error.errorCode=response.code()
            error.message=response.message()
            error.trace = response.errorBody().toString()
            return error
        }
    }
}