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