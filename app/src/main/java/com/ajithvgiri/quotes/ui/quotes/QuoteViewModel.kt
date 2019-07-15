/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:50 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 10:31 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.ui.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.ajithvgiri.quotes.data.model.Quote
import com.ajithvgiri.quotes.data.repository.QuoteRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

class QuoteViewModel @Inject constructor(private val quoteRepository: QuoteRepository) : ViewModel() {

    private val TAG = QuoteViewModel::class.java.simpleName

    private var randomQuote: MutableLiveData<Quote> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()
    lateinit var disposableObserver: DisposableObserver<List<Quote>>

    init {
        loadQuotes()
    }


    fun randomQuote(): LiveData<Quote> {
        return randomQuote
    }


    private fun loadQuotes() {
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
                error.postValue(e.message)
                Log.d(TAG, e.message)
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
        doAsync {
            randomQuote.postValue(quoteRepository.getRandomQuotes())
        }
    }

}
