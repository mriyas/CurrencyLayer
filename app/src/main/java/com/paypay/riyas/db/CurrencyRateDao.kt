package com.paypay.riyas.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.paypay.riyas.model.CurrencyRate
import com.paypay.riyas.model.CurrencyRateToDisplay

@Dao
interface CurrencyRateDao {

  /*  @Query("SELECT * FROM Countries")
    fun findAll(): List<CountriesData>*/

   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<CountriesData>)*/

   @Query("SELECT * FROM currency_rate")
   fun findAll(): List<CurrencyRate>
    @Query("SELECT * FROM currency_rate INNER JOIN supported_currency" +
            " ON supported_currency.currencyCode=currency_rate.currencyCode")
    fun getAllCurrencyRateWithCountryName(): List<CurrencyRateToDisplay>
   /* @Query("SE * FROM currency_rate INNER JOIN supported_currency " +
            "ON supported_currency.currencyCode = currency_rate.currencyCode")
    fun getAllCurrencyRateWithCountryName(): List<CurrencyRateToDisplay>
*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: List<CurrencyRate>?)

}