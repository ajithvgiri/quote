package com.ajithvgiri.quotes

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.ajithvgiri.quotes.injection.components.DaggerAppComponent
import com.ajithvgiri.quotes.injection.module.AppModule
import com.ajithvgiri.quotes.injection.module.NetModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class QuotesApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().appModule(AppModule(this)).netModule(NetModule(BuildConfig.BASE_URL)).build()
            .inject(this)
    }

    override fun activityInjector() = activityInjector

    override fun supportFragmentInjector() = dispatchingAndroidInjector

}