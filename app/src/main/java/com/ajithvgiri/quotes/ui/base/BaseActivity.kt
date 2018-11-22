/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:48 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 5:44 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.ui.base

import android.arch.lifecycle.LiveData
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.ajithvgiri.quotes.utils.InternetConnection
import dagger.android.AndroidInjection

open class BaseActivity : AppCompatActivity() {


    lateinit var isInternetAvailable: LiveData<Boolean>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        AndroidInjection.inject(this)
        isInternetAvailable = InternetConnection(applicationContext)
    }

}