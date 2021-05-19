package com.playground.db

import com.playground.currency_template.Currencies
import com.playground.currency_template.Rates
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyInterface {

    companion object{
        const val BASE_URL = "http://api.exchangeratesapi.io/v1/"

        const val API_KEY = "64a0b1efd52789f25312f7cb99e23679"
    }

    @GET ("latest")
    suspend fun getRate (
        @Query("access_key") apiKey : String = API_KEY,
        @Query("format") format : Int = 1
    ) : Response<Currencies>
}