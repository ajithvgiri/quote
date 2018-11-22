package com.ajithvgiri.quotes.data.repository

import com.ajithvgiri.quotes.data.dao.QuoteDao
import com.ajithvgiri.quotes.data.model.Quote
import com.ajithvgiri.quotes.data.remote.ApiInterface
import io.reactivex.Observable
import javax.inject.Inject


class QuoteRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val quoteDao: QuoteDao
) {

    private val TAG = QuoteRepository::class.java.simpleName

    fun getAllQuotes(): Observable<List<Quote>> {
        var observableFromApi: Observable<List<Quote>> = getQuotesFromAPI()

//        if (appUtils.isConnectedToInternet()) {
//            observableFromApi = getQuotesFromAPI()
//        }
        val observableFromDb = getQuotesFromDatabase()
//        return observableFromDb
        return Observable.concatArrayEager(observableFromApi, observableFromDb)
    }

    fun getQuotesFromAPI(): Observable<List<Quote>> {
        return apiInterface.allQuotes
            .doOnNext {
                //                appUtils.logD(TAG, "Quotes size from API ${it.size}")
                for (item in it) {
                    quoteDao.insertQuote(item)
                }
            }
    }

    fun getQuotesFromDatabase(): Observable<List<Quote>> {
        return quoteDao.queryQuotes().toObservable()
    }

    fun getRandomQuotes(): Observable<Quote> {
//        return apiInterface.randomQuote.doOnNext {
//            quoteDao.insertQuote(it)
//        }
        return quoteDao.queryRandomQuote().toObservable()
    }

    fun insertQuotes(quote: Quote) {
        quoteDao.insertQuote(quote)
    }


}

