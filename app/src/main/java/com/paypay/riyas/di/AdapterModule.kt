package com.paypay.riyas.di

import com.paypay.riyas.db.SharedPref
import com.paypay.riyas.views.adapter.SupportedCurrencyAdapter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val adapterModule = module {

    factory { SupportedCurrencyAdapter() }


}