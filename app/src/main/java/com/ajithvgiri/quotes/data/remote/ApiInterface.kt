/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:44 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 21/11/18 7:19 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.data.remote

import com.ajithvgiri.quotes.data.model.Quote
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiInterface {


    //all quote
    @get:GET("quotes.json")
    val allQuotes: Observable<List<Quote>>

    //single quote
    @get:GET("quotes/1.json")
    val singleQuote: Observable<Quote>

    //random quote
    @get:GET("random.json")
    val randomQuote: Observable<Quote>

}