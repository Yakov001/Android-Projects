package com.playground.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.playground.currency_template.Rates


@Database(entities = [Rates::class], version = 1)
abstract class CurrenciesDatabase : RoomDatabase() {

    abstract fun getCurrenciesDao() : CurrenciesDao

    companion object {
        @Volatile
        private var instance: CurrenciesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CurrenciesDatabase::class.java,
                "currencies_db.db"
            ).build()
    }
}