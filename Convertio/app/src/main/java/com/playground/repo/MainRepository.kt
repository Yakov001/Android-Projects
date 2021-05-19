package com.playground.repo

import com.playground.currency_template.Currencies
import com.playground.db.CurrencyInterface
import com.playground.util.Resource

class MainRepository(private val api: CurrencyInterface) {
    suspend fun getRates(): Resource<Currencies> {
        return try {
            val response = api.getRate()
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unexpected error")
        }
    }
}