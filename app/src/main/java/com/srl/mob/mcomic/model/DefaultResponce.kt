package com.srl.mob.mcomic.model

import com.google.gson.annotations.SerializedName

class DefaultResponce<T>
{
    @SerializedName("code")
    var statusCode:Int=0

    @SerializedName("status")
    var statusMsg:String?=null

    @SerializedName("copyright")
    var copyright:String?=null

    @SerializedName("attributionText")
    var attributionText:String?=null

    @SerializedName("data")
    var data:T?=null
}