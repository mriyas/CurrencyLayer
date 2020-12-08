package com.paypay.riyas.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * A model class which holds currency details like currency code and its rate
 * @param currencyCode : currency code
 * @param rate : rate of FX
 *
 */
@Entity(tableName = "currency_rate")
@Parcelize
open class CurrencyRate(@PrimaryKey val currencyCode:String, val rate:Double?) : Parcelable {

}