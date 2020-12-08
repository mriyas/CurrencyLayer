package com.paypay.riyas.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paypay.riyas.model.CurrencyRate
import com.paypay.riyas.model.SupportedCurrency

@Database(
    entities = [CurrencyRate::class, SupportedCurrency::class],
    version = 1, exportSchema = false
)

abstract class CurrencyLayerDatabase : RoomDatabase() {
    abstract val countriesDao: SupportedCurrenciesDao
    abstract val currencyRateDao: CurrencyRateDao
}