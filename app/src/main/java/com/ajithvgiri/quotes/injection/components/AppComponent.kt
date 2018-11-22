package com.ajithvgiri.quotes.injection.components

import com.ajithvgiri.quotes.QuotesApplication
import com.ajithvgiri.quotes.injection.module.*
import com.ajithvgiri.quotes.ui.base.BaseActivity
import com.ajithvgiri.quotes.ui.base.BaseFragment
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class, ActivityModule::class, FragmentModule::class, AppModule::class, NetModule::class, ViewModelModule::class]
)
interface AppComponent {
    fun inject(app: QuotesApplication)

    fun inject(app: BaseActivity)

    fun inject(app: BaseFragment)
}