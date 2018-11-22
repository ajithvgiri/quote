/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:46 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 2:16 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.injection.module

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import com.ajithvgiri.quotes.data.Database
import com.ajithvgiri.quotes.data.dao.QuoteDao
import com.ajithvgiri.quotes.utils.AppUtils
import com.ajithvgiri.quotes.utils.QuotesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {


    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideUtils(): AppUtils = AppUtils(application)


    @Provides
    @Singleton
    fun provideQuotesDatabase(app: Application): Database = Room.databaseBuilder(app, Database::class.java, "quotes")
        /*.addMigrations(MIGRATION_1_2)*/
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideQuotesDao(database: Database): QuoteDao = database.quotesDao()

    @Provides
    @Singleton
    fun provideQuotesViewModelFactory(factory: QuotesViewModelFactory): ViewModelProvider.Factory = factory


}
