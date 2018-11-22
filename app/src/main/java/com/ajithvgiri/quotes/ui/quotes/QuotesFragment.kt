/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:49 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 10:48 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.ui.quotes


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajithvgiri.quotes.R
import com.ajithvgiri.quotes.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_quotes.*

class QuotesFragment : BaseFragment() {


    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quoteViewModel = ViewModelProviders.of(this, quotesViewModelFactory).get(QuoteViewModel::class.java)



        swipeRefreshLayout.setOnRefreshListener {
            quoteViewModel.getRandomQuotes()
        }
        quoteViewModel.getRandomQuotes()

        quoteViewModel.randomQuote().observe(this,
            Observer {
                textViewQuotes.text = it?.quote
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    textViewQuotes.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
                }
                swipeRefreshLayout.isRefreshing = false
            })
    }

    override fun onDetach() {
        super.onDetach()
        quoteViewModel.disposableObserver
    }


}
