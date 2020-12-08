package com.paypay.riyas.model

import com.google.gson.annotations.SerializedName

class SupportedCurrenciesResponse : CurrencyLayerResponse(){
    /**
     * Map contains currency code and respective country name
     */
    @SerializedName("currencies")
    var supportedCurrenciesMap:Map<String,String>?=null
}