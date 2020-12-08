package com.paypay.riyas.di

import com.paypay.riyas.db.SupportedCurrenciesDao
import com.paypay.riyas.db.CurrencyLayerDatabase
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.paypay.riyas.db.CurrencyRateDao
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Context): CurrencyLayerDatabase {
       return Room.databaseBuilder(application, CurrencyLayerDatabase::class.java, "countries")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCurrencyListDao(database: CurrencyLayerDatabase): SupportedCurrenciesDao {
        return  database.countriesDao
    }
    fun provideCurrencyRateDao(database: CurrencyLayerDatabase): CurrencyRateDao {
        return  database.currencyRateDao
    }

    single { provideDatabase(androidContext()) }
    single { provideCurrencyListDao(get()) }
    single { provideCurrencyRateDao(get()) }


}
