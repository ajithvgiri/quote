/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:51 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 3:07 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class QuotesViewModelFactory @Inject constructor(private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = viewModelsMap[modelClass] ?: viewModelsMap.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}