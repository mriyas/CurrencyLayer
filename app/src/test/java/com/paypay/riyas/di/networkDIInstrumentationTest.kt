package com.paypay.riyas.di

import com.google.gson.GsonBuilder
import com.paypay.riyas.repository.CurrencyLayerApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Network module test configuration with mockserver url.
 */
fun configureNetworkModuleForTest(baseApi: String)
        = module{
    single {
        Retrofit.Builder()
            .baseUrl(baseApi)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
           // .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
    factory{ get<Retrofit>().create(CurrencyLayerApi::class.java) }
}