package com.ajithvgiri.quotes.ui.base

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.ajithvgiri.quotes.ui.quotes.QuoteViewModel
import com.ajithvgiri.quotes.utils.QuotesViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var quotesViewModelFactory: QuotesViewModelFactory
    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        AndroidInjection.inject(this)
        quoteViewModel = ViewModelProviders.of(this, quotesViewModelFactory).get(QuoteViewModel::class.java)
    }

}