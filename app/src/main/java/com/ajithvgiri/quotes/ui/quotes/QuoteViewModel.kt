/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:50 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 10:31 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.ui.quotes

import android.util.Log
import androidx.lifecycle.*
import com.ajithvgiri.quotes.data.model.Quote
import com.ajithvgiri.quotes.data.repository.QuoteRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject


class QuoteViewModel @Inject constructor(private val quoteRepository: QuoteRepository) : ViewModel() {

    private val TAG = QuoteViewModel::class.java.simpleName

    var randomQuote: MutableLiveData<Quote> = MutableLiveData()
    var quoteString: MutableLiveData<String> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    lateinit var disposableObserver: DisposableObserver<List<Quote>>

    init {
        loadQuotes()
    }

    private fun loadQuotes() {
        isLoading.value = true
        disposableObserver = object : DisposableObserver<List<Quote>>() {
            override fun onComplete() {
                if (!disposableObserver.isDisposed) disposableObserver.dispose()
                getRandomQuotesFromStorage()
            }

            override fun onNext(quotesList: List<Quote>) {
                doAsync {
                    quoteRepository.insertQuotes(quotesList)
                }
            }

            override fun onError(e: Throwable) {
                isLoading.value = false
                Log.d(TAG, "" + e.message)
            }
        }

        doAsync {
            quoteRepository.getAllQuotes()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(400, MILLISECONDS)
                .subscribe(disposableObserver)
        }
    }


    fun getRandomQuotesFromStorage() {
        isLoading.value = true
        doAsync {
            randomQuote.postValue(quoteRepository.getRandomQuotes())
            quoteString.postValue(randomQuote.value?.quote)
            uiThread {
                isLoading.value = false
            }
        }
    }

}
