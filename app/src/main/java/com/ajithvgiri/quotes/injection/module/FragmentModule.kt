/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:46 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 4:43 PM
 -
 -----------------------------------------------------------------------------*/
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