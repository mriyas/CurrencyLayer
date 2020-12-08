package com.paypay.riyas.model

open class CurrencyLayerResponse {
    var success: Boolean = false
    var error:Error?=null

    class Error{
        val code:Int=0
        val info:String?=null
    }
}