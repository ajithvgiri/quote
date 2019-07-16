/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:49 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 10:48 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.ui.quotes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ajithvgiri.quotes.R
import com.ajithvgiri.quotes.databinding.FragmentQuotesBinding
import com.ajithvgiri.quotes.ui.base.BaseFragment

class QuotesFragment : BaseFragment() {

    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quoteViewModel = ViewModelProviders.of(this, quotesViewModelFactory).get(QuoteViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_quotes, container, false)
        val quoteDataBinding = DataBindingUtil.inflate<FragmentQuotesBinding>(inflater, R.layout.fragment_quotes, container, false)
        quoteDataBinding.lifecycleOwner = this
        quoteDataBinding.quote = quoteViewModel
        return quoteDataBinding.root
    }
}
