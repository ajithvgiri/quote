/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:43 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 21/11/18 11:52 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ajithvgiri.quotes.data.model.Quote
import io.reactivex.Single

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quotes")
    fun queryQuotes(): Single<List<Quote>>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun insertQuote(quote: Quote)

    @Query("SELECT * from quotes ORDER by random() Limit 1")
    fun queryRandomQuote(): Single<Quote>

}