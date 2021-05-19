package com.playground.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.playground.currency_template.Rates

@Dao
interface CurrenciesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(currencies: Rates)

    @Query("SELECT * FROM currencies")
    fun getCurrencies(): LiveData<Rates>
}