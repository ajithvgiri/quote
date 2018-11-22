package com.ajithvgiri.quotes.ui.quotes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.ajithvgiri.quotes.data.model.Quote
import com.ajithvgiri.quotes.data.repository.QuoteRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

class QuoteViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val TAG = QuoteViewModel::class.java.simpleName

    var quoteList: MutableLiveData<List<Quote>> = MutableLiveData()
    var randomQuote: MutableLiveData<Quote> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()
    lateinit var disposableObserver: DisposableObserver<List<Quote>>
    lateinit var quoteObserver: DisposableObserver<Quote>

    fun quotesListResult(): LiveData<List<Quote>> {
        return quoteList
    }

    fun randomQuote(): LiveData<Quote> {
        return randomQuote
    }


    fun quotesError(): LiveData<String> {
        return error
    }

    fun loadQuotes() {

        disposableObserver = object : DisposableObserver<List<Quote>>() {
            override fun onComplete() {

            }

            override fun onNext(quotesList: List<Quote>) {
                quoteList.postValue(quotesList)
            }

            override fun onError(e: Throwable) {
                error.postValue(e.message)
                Log.d(TAG, e.message)
            }
        }

        quoteRepository.getAllQuotes()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .debounce(400, MILLISECONDS)
            .subscribe(disposableObserver)
    }

    fun getRandomQuotes() {
        quoteObserver = object : DisposableObserver<Quote>() {
            override fun onComplete() {
            }

            override fun onNext(t: Quote) {
                randomQuote.postValue(t)
            }

            override fun onError(e: Throwable) {
                error.postValue(e.message)
            }

        }

        quoteRepository.getRandomQuotes()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .debounce(400, MILLISECONDS)
            .subscribe(quoteObserver)
    }

    fun disposeElements() {
        if (disposableObserver != null && !disposableObserver.isDisposed) disposableObserver.dispose()
    }

}
