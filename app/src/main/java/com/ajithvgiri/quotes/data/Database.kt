package com.ajithvgiri.quotes.data


//class Database private constructor() {
//
//    var quoteDao = QuoteDao()
//        private set
//    companion object {
//        @Volatile
//        private var instance: Database? = null
//
//        fun getInstance() = instance ?: synchronized(this) {
//            instance ?: Database().also { instance = it }
//        }
//    }
//}
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ajithvgiri.quotes.data.dao.QuoteDao
import com.ajithvgiri.quotes.data.model.Quote

@Database(entities = [Quote::class], version = 1,exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun quotesDao(): QuoteDao
}