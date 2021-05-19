package com.playground.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.playground.currency_template.Rates
import com.playground.db.MyApp
import com.playground.repo.MainRepository
import com.playground.room.CurrenciesDatabase
import com.playground.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.NullPointerException

class ViewModelFragmentMain(private var application: Application) : ViewModel() {

    private val mRepository = MainRepository(MyApp.INSTANCE.api)
    var mDoubleLiveData = MutableLiveData<Double>()
    private var mRatesLiveData = MutableLiveData<CurrencyEvent>(CurrencyEvent.Empty)
    var mIsFirstCurrency = MutableLiveData<Boolean>(true)
    var mCurrencyPair = MutableLiveData("USD" to "USD")

    fun convert(amountStr: String, fromCurrency: String, toCurrency: String) {

        viewModelScope.launch(Dispatchers.IO) {
            if (mRatesLiveData.value is CurrencyEvent.Failure) return@launch
            val value = mRatesLiveData.value!!.rates ?: CurrenciesDatabase(
                application.applicationContext)
                .getCurrenciesDao()
                .getCurrencies()
                .value
            var rate = getRateForCurrency(toCurrency, value!!)

            if (fromCurrency != "EUR") {
                val rate1 = 1 / getRateForCurrency(fromCurrency, value)
                rate *= rate1
            }
            try {
                val amountFlt = amountStr.toFloatOrNull()
                val convertedAmount = rate * amountFlt!!

                mDoubleLiveData.postValue(convertedAmount)
            } catch (npe: NullPointerException) {
                mDoubleLiveData.postValue(0.00)
            }
        }
    }

    fun update() {
        mRatesLiveData.postValue(CurrencyEvent.Loading)
        Log.d("Update", "update")
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = mRepository.getRates()) {
                is Resource.Error -> {
                    mRatesLiveData.postValue(CurrencyEvent.Failure("Please, connect to Internet"))
                }
                is Resource.Success -> {
                    mRatesLiveData.postValue(CurrencyEvent.Success(response.data!!.rates))
                }
            }
        }
    }

    private fun getRateForCurrency(fromCurrency: String, rates: Rates): Double =
        when (fromCurrency) {
            "AUD" -> rates.AUD
            "AWG" -> rates.AWG
            "AZN" -> rates.AZN
            "BAM" -> rates.BAM
            "BBD" -> rates.BBD
            "BDT" -> rates.BDT
            "BGN" -> rates.BGN
            "BHD" -> rates.BHD
            "BIF" -> rates.BIF
            "BMD" -> rates.BMD
            "BND" -> rates.BND
            "BOB" -> rates.BOB
            "BRL" -> rates.BRL
            "BSD" -> rates.BSD
            "BTC" -> rates.BTC
            "BTN" -> rates.BTN
            "BWP" -> rates.BWP
            "BYN" -> rates.BYN
            "BYR" -> rates.BYR
            "BZD" -> rates.BZD
            "CAD" -> rates.CAD
            "CDF" -> rates.CDF
            "CHF" -> rates.CHF
            "CLF" -> rates.CLF
            "CLP" -> rates.CLP
            "CNY" -> rates.CNY
            "COP" -> rates.COP
            "CRC" -> rates.CRC
            "CUC" -> rates.CUC
            "CUP" -> rates.CUP
            "CVE" -> rates.CVE
            "CZK" -> rates.CZK
            "DJF" -> rates.DJF
            "FJD" -> rates.FJD
            "FKP" -> rates.FKP
            "GBP" -> rates.GBP
            "GEL" -> rates.GEL
            "GGP" -> rates.GGP
            "GHS" -> rates.GHS
            "GIP" -> rates.GIP
            "GMD" -> rates.GMD
            "GNF" -> rates.GNF
            "GTQ" -> rates.GTQ
            "GYD" -> rates.GYD
            "HKD" -> rates.HKD
            "HNL" -> rates.HNL
            "HRK" -> rates.HRK
            "HTG" -> rates.HTG
            "HUF" -> rates.HUF
            "JEP" -> rates.JEP
            "JMD" -> rates.JMD
            "JOD" -> rates.JOD
            "JPY" -> rates.JPY
            "PEN" -> rates.PEN
            "PGK" -> rates.PGK
            "PHP" -> rates.PHP
            "PKR" -> rates.PKR
            "PLN" -> rates.PLN
            "PYG" -> rates.PYG
            "QAR" -> rates.QAR
            "RON" -> rates.RON
            "RSD" -> rates.RSD
            "RUB" -> rates.RUB
            "USD" -> rates.USD
            else -> 1.0
        }

    fun writeToDb() {
        viewModelScope.launch {
            val db = Room.databaseBuilder(
                application.applicationContext,
                CurrenciesDatabase::class.java,
                "currencies_db.db"
            ).build()
            val currencyDao = db.getCurrenciesDao()
            mRatesLiveData.value?.rates?.let {
                currencyDao.upsert(it)
            }
        }
    }

    sealed class CurrencyEvent(val rates: Rates?) {
        class Success(rates: Rates): CurrencyEvent(rates)
        class Failure(val errorText: String): CurrencyEvent(null)
        object Loading : CurrencyEvent(null)
        object Empty : CurrencyEvent(null)
    }
}