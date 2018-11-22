package com.ajithvgiri.quotes.ui.quotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.text.Layout
import com.ajithvgiri.quotes.R
import com.ajithvgiri.quotes.ui.base.BaseActivity
import com.ajithvgiri.quotes.utils.QuotesViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class QuotesActivity : BaseActivity() {


    @Inject
    lateinit var quotesViewModelFactory: QuotesViewModelFactory
    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        quoteViewModel = ViewModelProviders.of(this, quotesViewModelFactory).get(QuoteViewModel::class.java)
//        quoteViewModel.loadCryptocurrencies()
//        quoteViewModel.quotesListResult().observe(this,
//            Observer<List<Quote>> {
//                textViewQuotes.text = "Hello ${it?.size} quotes"
//            })
//        quoteViewModel.cryptocurrenciesError().observe(this, Observer<String> {
//            textViewQuotes.text = "Hello error $it"
//        })

        swipeRefreshLayout.setOnRefreshListener {
            quoteViewModel.getRandomQuotes()
        }
        quoteViewModel.getRandomQuotes()

        quoteViewModel.randomQuote().observe(this,
            Observer {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    textViewQuotes.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
                }
                swipeRefreshLayout.isRefreshing = false
            })
//        quoteViewModel.cryptocurrenciesError().observe(this, Observer<String> {
//            textViewQuotes.text = "error $it"
//        })
    }

    override fun onDestroy() {
//        quoteViewModel.disposeElements()
        super.onDestroy()
    }
}
