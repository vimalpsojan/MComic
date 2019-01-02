package com.srl.mob.mcomic.model

import com.google.gson.annotations.SerializedName

class Thumbnail {
    /*
    *
    * Json Schema
    *
    * {"path": "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
        "extension": "jpg"}
    *
     */

    @SerializedName("path")
    var path:String?=null

    @SerializedName("extension")
    var extension:String?=null

    fun getUrl():String
    {
        return "$path.$extension"
    }
}