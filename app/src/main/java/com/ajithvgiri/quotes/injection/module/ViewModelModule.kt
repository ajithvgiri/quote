/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:47 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 12:36 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.injection.module

import androidx.lifecycle.ViewModel
import com.ajithvgiri.quotes.ui.quotes.QuoteViewModel
import com.ajithvgiri.quotes.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(QuoteViewModel::class)
    abstract fun bindQuoteViewModel(myViewModel: QuoteViewModel): ViewModel
}