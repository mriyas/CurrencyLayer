package com.paypay.riyas.di

import com.paypay.riyas.repository.CurrencyLayerApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideCountriesApi(retrofit: Retrofit): CurrencyLayerApi {
        return retrofit.create(CurrencyLayerApi::class.java)
    }
    single{ provideCountriesApi(get()) }


}