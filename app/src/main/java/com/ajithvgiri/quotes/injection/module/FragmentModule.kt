package com.ajithvgiri.quotes.injection.module

import com.ajithvgiri.quotes.ui.base.BaseFragment
import com.ajithvgiri.quotes.ui.quotes.QuotesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    internal abstract fun contributeQuotesFragmentInjector(): QuotesFragment
}