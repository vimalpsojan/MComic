package com.vimal.comic.models

import com.google.gson.annotations.SerializedName

class Comic {
    @SerializedName("id")
    var id:Long=0

    @SerializedName("digitalId")
    var digitalId:Long=0

    @SerializedName("title")
    var title:String?=null

    @SerializedName("issueNumber")
    var issueNumber:Long=0

    @SerializedName("thumbnail")
    var thumbnail:Thumbnail?=null
}