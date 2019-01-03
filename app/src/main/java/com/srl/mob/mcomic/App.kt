package com.srl.mob.mcomic

import android.app.Activity
import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class App :Application(){


    companion object {
        lateinit var instance: App
            private set
    }
    override fun onCreate()
    {
        super.onCreate()
        instance=this
        Fresco.initialize(this)
    }
}