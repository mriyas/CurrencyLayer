package com.paypay.riyas.di

import com.paypay.riyas.db.SharedPref
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sharedPrefModule = module {

    single { SharedPref(androidContext()) }


}