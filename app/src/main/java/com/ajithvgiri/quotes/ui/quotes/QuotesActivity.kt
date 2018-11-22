package com.ajithvgiri.quotes.ui.quotes

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ajithvgiri.quotes.R
import com.ajithvgiri.quotes.ui.base.BaseActivity

class QuotesActivity : BaseActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        AndroidInjection.inject(this)
//        quoteViewModel = ViewModelProviders.of(this, quotesViewModelFactory).get(QuoteViewModel::class.java)
//        quoteViewModel.loadCryptocurrencies()
//        quoteViewModel.quotesListResult().observe(this,
//            Observer<List<Quote>> {
//                textViewQuotes.text = "Hello ${it?.size} quotes"
//            })
//        quoteViewModel.cryptocurrenciesError().observe(this, Observer<String> {
//            textViewQuotes.text = "Hello error $it"
//        })

//        swipeRefreshLayout.setOnRefreshListener {
//            quoteViewModel.getRandomQuotes()
//        }
//        quoteViewModel.getRandomQuotes()
//
//        quoteViewModel.randomQuote().observe(this,
//            Observer {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    textViewQuotes.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
//                }
//                swipeRefreshLayout.isRefreshing = false
//            })
//        quoteViewModel.cryptocurrenciesError().observe(this, Observer<String> {
//            textViewQuotes.text = "error $it"
//        })

        commitFragment(QuotesFragment())
    }

    override fun onDestroy() {
//        quoteViewModel.disposeElements()
        super.onDestroy()
    }

    fun commitFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.frameLayout, fragment)
            .commit()
    }
}
