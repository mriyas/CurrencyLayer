package com.paypay.riyas.repository

import com.paypay.riyas.model.CurrencyRateResponse
import com.paypay.riyas.model.SupportedCurrenciesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyLayerApi {

    @GET("/list")
    suspend fun getSupportedCountries(@Query("access_key") accessKey:String): Response<SupportedCurrenciesResponse>


    @GET("/live")
    suspend fun getCurrencyRate(@Query("access_key") accessKey:String): Response<CurrencyRateResponse>


}