package com.vimal.core.models

import com.google.gson.annotations.SerializedName

class DefaultArrayResponse<T> {
    @SerializedName("code")
    var statusCode:Int=0

    @SerializedName("status")
    var statusMsg:String?=null

    @SerializedName("copyright")
    var copyright:String?=null

    @SerializedName("attributionText")
    var attributionText:String?=null

    @SerializedName("data")
    var data: Data<T>?=null

    class Data<T>{
        @SerializedName("results")
        var result:ArrayList<T>?=null
    }
}