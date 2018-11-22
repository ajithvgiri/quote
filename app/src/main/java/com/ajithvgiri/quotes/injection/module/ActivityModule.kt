package com.ajithvgiri.quotes.injection.module

import com.ajithvgiri.quotes.ui.base.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity
}