package com.paypay.riyas.repository

import com.paypay.riyas.model.CurrencyRate
import com.paypay.riyas.model.CurrencyRateToDisplay
import com.paypay.riyas.model.SupportedCurrency
import com.paypay.riyas.util.AppResult


interface DataRepository {
    suspend fun getSupportedCurrencies() : AppResult<List<SupportedCurrency>?>
    suspend fun getSupportedCurrenciesFromApi() : AppResult<List<SupportedCurrency>?>
    suspend fun getCurrencyRate() : AppResult<List<CurrencyRateToDisplay>>
    suspend fun getCurrencyRateFromApi() : AppResult<List<CurrencyRate>>
}
