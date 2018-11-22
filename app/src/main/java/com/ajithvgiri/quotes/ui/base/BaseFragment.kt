/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:48 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 4:39 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ajithvgiri.quotes.utils.QuotesViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var quotesViewModelFactory: QuotesViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)

    }
}