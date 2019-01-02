package com.srl.mob.mcomic.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import android.app.Application
import com.srl.mob.mcomic.App
import dagger.BindsInstance
import javax.inject.Singleton


@Singleton
@Component(modules = [ AndroidInjectionModule::class,AppModule::class,MainActivityModule::class])
interface AppComponent
{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}