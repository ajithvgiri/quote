package com.ajithvgiri.quotes.injection.module

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import com.ajithvgiri.quotes.data.Database
import com.ajithvgiri.quotes.data.dao.QuoteDao
import com.ajithvgiri.quotes.utils.QuotesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {


    companion object {
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Change the table name to the correct one
                database.execSQL("ALTER TABLE quote RENAME TO quotes")
            }
        }
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideCryptocurrenciesDatabase(app: Application): Database = Room.databaseBuilder(
        app,
        Database::class.java, "quotes"
    )
        /*.addMigrations(MIGRATION_1_2)*/
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideCryptocurrenciesDao(
        database: Database
    ): QuoteDao = database.quotesDao()




    @Provides
    @Singleton
    fun provideCryptocurrenciesViewModelFactory(
        factory: QuotesViewModelFactory
    ): ViewModelProvider.Factory = factory
}
