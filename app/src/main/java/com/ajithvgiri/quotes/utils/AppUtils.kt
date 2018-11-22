/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:51 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 21/11/18 11:10 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.ajithvgiri.quotes.BuildConfig
import javax.inject.Inject

class AppUtils @Inject constructor(private val context: Context) {

    fun isConnectedToInternet(): Boolean {
        val connectivity = context.getSystemService(
            Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivity != null) {
            val info = connectivity.allNetworkInfo
            if (info != null)
                for (i in info.indices)
                    if (info[i].state == NetworkInfo.State.CONNECTED) {
                        return true
                    }
        }
        return false
    }

    fun logD(TAG: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, message)
        }
    }
}