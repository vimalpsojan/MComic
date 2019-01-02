package com.srl.mob.mcomic.model

import com.google.gson.annotations.SerializedName

class Creators {
    /*
    ***********
    * Json Schema example
    {
        "resourceURI": "http://gateway.marvel.com/v1/public/creators/2133",
        "name": "Tom Brevoort",
        "role": "editor"
    }*/


    /*
    Extracting Id from uri hence only ID is required
     */
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