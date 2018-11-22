package com.ajithvgiri.quotes.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ajithvgiri.quotes.ui.quotes.QuoteViewModel
import javax.inject.Inject

//class QuotesViewModelFactory @Inject constructor(private val quotesViewModel: QuotesViewModel) :
//    ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(quotesViewModel::class.java)) {
//            return quotesViewModel as T
//        }
//        throw IllegalArgumentException("Unknown class name")
//    }
//}

class QuotesViewModelFactory @Inject constructor(
    private val cryptocurrenciesViewModel: QuoteViewModel
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuoteViewModel::class.java)) {
            return cryptocurrenciesViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}

//@Suppress("UNCHECKED_CAST")
//class QuotesViewModelFactory @Inject constructor(private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
//    ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        val creator = viewModelsMap[modelClass] ?:
//        viewModelsMap.asIterable().firstOrNull {
//            modelClass.isAssignableFrom(it.key)
//        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
//        return try {
//            creator.get() as T
//        } catch (e: Exception) {
//            throw RuntimeException(e)
//        }
//    }
//
//}