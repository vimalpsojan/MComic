package com.vimal.core.models

import android.content.Context

open class LoadingMessageData(context: Context?=null):MessageData(context) {
    var isLoading :Boolean =true
}