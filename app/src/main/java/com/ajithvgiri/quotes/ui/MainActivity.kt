/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:49 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 10:22 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ajithvgiri.quotes.R
import com.ajithvgiri.quotes.ui.base.BaseActivity
import com.ajithvgiri.quotes.ui.quotes.QuotesFragment

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        commitFragment(QuotesFragment())
    }

    private fun commitFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.frameLayout, fragment)
            .commit()
    }
}
