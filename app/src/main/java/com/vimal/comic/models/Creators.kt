package com.vimal.comic.models

import com.google.gson.annotations.SerializedName

class Creators {
    @SerializedName("resourceURI")
    var id:String?=null
        get() {
            return if(field?.isNotEmpty()==true) {
                field?.substring(field?.lastIndexOf("/")?:0)
            } else {
                field
            }
        }

    @SerializedName("name")
    var name:String?=null

    @SerializedName("role")
    var role:String?=null
}