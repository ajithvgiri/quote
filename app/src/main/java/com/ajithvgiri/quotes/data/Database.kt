/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:45 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 21/11/18 11:41 AM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ajithvgiri.quotes.data.dao.QuoteDao
import com.ajithvgiri.quotes.data.model.Quote

@Database(entities = [Quote::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun quotesDao(): QuoteDao
}