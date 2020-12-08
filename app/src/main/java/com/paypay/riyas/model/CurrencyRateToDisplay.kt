package com.paypay.riyas.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * A model class which holds currency details like currency code and its rate
 * @param currencyCode : currency code
 * @param rate : rate of FX
 *
 */
@Parcelize
class CurrencyRateToDisplay : Parcelable {
    var currencyCode:String?=null
    var countryName:String?=null
    var rate:Double=0.0

    override fun toString(): String {
        return currencyCode.toString()
    }
}