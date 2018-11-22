package com.ajithvgiri.quotes.injection.components

import com.ajithvgiri.quotes.QuotesApplication
import com.ajithvgiri.quotes.injection.module.AppModule
import com.ajithvgiri.quotes.injection.module.BuildersModule
import com.ajithvgiri.quotes.injection.module.NetModule
import com.ajithvgiri.quotes.injection.module.ViewModelModule
import com.ajithvgiri.quotes.ui.quotes.QuotesActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class, NetModule::class, ViewModelModule::class]
)
interface AppComponent {
    fun inject(app: QuotesApplication)

    fun inject(app: QuotesActivity)
}