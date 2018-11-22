package com.ajithvgiri.quotes.injection.module

import android.arch.lifecycle.ViewModel
import com.ajithvgiri.quotes.ui.quotes.QuoteViewModel
import com.ajithvgiri.quotes.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(QuoteViewModel::class)
    abstract fun bindMyViewModel(myViewModel: QuoteViewModel): ViewModel
}