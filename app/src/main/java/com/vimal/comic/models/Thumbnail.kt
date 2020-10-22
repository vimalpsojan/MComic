package com.vimal.comic.models

import com.google.gson.annotations.SerializedName

class Thumbnail {
    @SerializedName("path")
    var path:String?=null

    @SerializedName("extension")
    var extension:String?=null

    fun getUrl():String
    {
        return "$path.$extension"
    }
}