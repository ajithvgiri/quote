package com.ajithvgiri.quotes.injection.module

import com.ajithvgiri.quotes.ui.quotes.QuotesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeQuotesActivity(): QuotesActivity
}