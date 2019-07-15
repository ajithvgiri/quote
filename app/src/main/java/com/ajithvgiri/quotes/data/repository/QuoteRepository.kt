/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:45 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 5:48 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.data.repository

import android.arch.lifecycle.LiveData
import com.ajithvgiri.quotes.data.dao.QuoteDao
import com.ajithvgiri.quotes.data.model.Quote
import com.ajithvgiri.quotes.data.remote.ApiInterface
import io.reactivex.Observable
import javax.inject.Inject


class QuoteRepository @Inject constructor(private val apiInterface: ApiInterface, private val quoteDao: QuoteDao) {

    fun getAllQuotes(): Observable<List<Quote>> {
        val observableFromApi: Observable<List<Quote>> = getQuotesFromAPI()
        val observableFromDb = getQuotesFromDatabase()
        return Observable.concatArrayEager(observableFromApi, observableFromDb)
    }

    private fun getQuotesFromAPI(): Observable<List<Quote>> {
        return apiInterface.allQuotes
            .doOnNext {
                //appUtils.logD(TAG, "Quotes size from API ${it.size}")
                for (item in it) {
                    insertQuote(item)
                }
            }
    }

    private fun getQuotesFromDatabase(): Observable<List<Quote>> {
        return quoteDao.queryQuotes().toObservable()
    }

    fun getRandomQuotes(): Quote {
        return quoteDao.queryRandomQuote()
    }

    private fun insertQuote(quote: Quote) {
        quoteDao.insertQuote(quote)
    }

    fun insertQuotes(quotes: List<Quote>){
        quoteDao.insertQuotes(quotes)
    }

}

