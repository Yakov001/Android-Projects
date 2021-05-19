package com.playground.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.playground.R
import com.playground.ui.FragmentMain
import com.playground.ui.FragmentPickCurrency

class AdapterCurrency() : RecyclerView.Adapter<AdapterCurrency.CurrencyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        var viewHolder = CurrencyViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.currency_view_holder, parent, false
        ))
        return viewHolder
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currencyTextView: TextView = holder.itemView.findViewById(R.id.currency_abbreviation)

        val currencies = mutableListOf("AUD", "AWG", "AZN",
            "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND",
            "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYN", "BYR",
            "BZD", "CAD", "CDF", "CHF", "CLF", "CLP", "CNY", "COP",
            "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "EUR", "FJD",
            "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF",
            "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "JEP",
            "JMD", "JOD", "JPY", "PEN", "PGK", "PHP", "PKR", "PLN",
            "PYG", "QAR", "RON", "RSD", "RUB", "USD")
        currencyTextView.text = currencies[position]
    }

    override fun getItemCount(): Int {
        return 65
    }

    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener {
                var currency = itemView.findViewById<TextView>(R.id.currency_abbreviation)?.text.toString()
                var bundle = bundleOf(FragmentMain.SELECTED_CURRENCY to currency)
                val fm = itemView.findFragment<FragmentPickCurrency>().parentFragmentManager
                fm.beginTransaction().replace(R.id.fragment_container_main, FragmentMain::class.java, bundle).commit()
            }
        }

        override fun onClick(v: View?) {

        }
    }
}