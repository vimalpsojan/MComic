package com.srl.mob.mcomic.di

import dagger.android.support.AndroidSupportInjection
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import dagger.android.AndroidInjection
import dagger.android.support.HasSupportFragmentInjector
import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.srl.mob.mcomic.App


class AppInjector(app:App)
{
    init
    {
        DaggerAppComponent.builder().application(app).build().inject(app)
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity?)
            {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityResumed(activity: Activity?)
            {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityStarted(activity: Activity?)
            {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityDestroyed(activity: Activity?)
            {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?)
            {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityStopped(activity: Activity?)
            {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?)
            {
                if(activity!=null)
                    handleActivity(activity)
            }
        })
    }

    private fun handleActivity(activity: Activity)
    {
        if (activity is HasSupportFragmentInjector)
        {
            AndroidInjection.inject(activity)
        }
        if(activity is FragmentActivity)
        {
           activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks()
           {
               override fun onFragmentCreated(fragmentManager: FragmentManager, fragment: Fragment, savedInstanceState: Bundle?)
               {
                   if (fragment is Injectable)
                   {
                       AndroidSupportInjection.inject(fragment)
                   }
               }
           },true)
        }
    }

}