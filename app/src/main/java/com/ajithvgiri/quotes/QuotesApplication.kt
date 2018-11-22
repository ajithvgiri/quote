package com.ajithvgiri.quotes

import android.app.Activity
import android.app.Application
import com.ajithvgiri.quotes.injection.components.DaggerAppComponent
import com.ajithvgiri.quotes.injection.module.AppModule
import com.ajithvgiri.quotes.injection.module.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class QuotesApplication : Application(), HasActivityInjector {


    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().appModule(AppModule(this)).netModule(NetModule(BuildConfig.BASE_URL)).build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}