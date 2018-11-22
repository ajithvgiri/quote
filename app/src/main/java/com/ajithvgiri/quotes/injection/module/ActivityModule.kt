/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:45 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 3:49 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.injection.module

import com.ajithvgiri.quotes.ui.base.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity
}