package com.paypay.riyas.model

import com.google.gson.annotations.SerializedName

class CurrencyRateResponse : CurrencyLayerResponse(){

    var source:String?=null
    /**
     * Map contains currency code and respective rate
     */
    @SerializedName("quotes")
    var rates:Map<String,Double>?=null
}