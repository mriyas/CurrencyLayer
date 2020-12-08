package com.paypay.riyas

import androidx.multidex.MultiDexApplication
import com.paypay.riyas.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class CurrencyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initiateKoin()
    }
    private fun initiateKoin() {
        startKoin{
            androidContext(this@CurrencyApplication)
            modules(provideDependency())
        }
    }

    open fun provideDependency() = appComponent

}