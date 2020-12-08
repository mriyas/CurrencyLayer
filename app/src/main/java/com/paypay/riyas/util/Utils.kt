package com.paypay.riyas.util

import com.paypay.riyas.model.CurrencyLayerResponse
import retrofit2.Response

object Utils {
    fun <T : Any> handleApiError(resp: Response<T>): AppResult.Error {
        val error = ApiErrorUtils.parseError(resp)
        return AppResult.Error(Exception(error.message))
    }

    fun <T : Any> handleSuccess(response: Response<T>): AppResult<T> {
        response.body()?.let {
            if(it is CurrencyLayerResponse) {
                return if (it.success){
                    AppResult.Success(it)
                }else{
                    val error=it?.error
                    if(error?.info.isNullOrEmpty()) {
                        returnError()
                    }else{
                        returnError(error?.info)
                    }

                }
            }else{
                return returnError()
            }
        } ?: return handleApiError(response)
    }


    private fun returnError(error:String?="Something went wrong"): AppResult.Error {
        return AppResult.Error(Exception(error))
    }
}