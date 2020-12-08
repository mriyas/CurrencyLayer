package com.paypay.riyas.views.adapter

import com.android.countries.R
import com.android.countries.databinding.CountriesRowBinding
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.paypay.riyas.model.CurrencyRateToDisplay
import com.paypay.riyas.model.SupportedCurrency
import com.paypay.riyas.viewmodel.DataViewModel
import com.paypay.riyas.views.utilis.RvClickListener


class SupportedCurrencyAdapter() : RecyclerView.Adapter<SupportedCurrencyAdapter.CountriesViewHolder>() {

    var suppoertedCurrencyList: List<SupportedCurrency> = ArrayList()
    private var currencyRateList: List<CurrencyRateToDisplay> = ArrayList()
    var mViewModel: DataViewModel? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val viewBinding: CountriesRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.countries_row, parent, false
        )
        return CountriesViewHolder(viewBinding)
    }


    override fun getItemCount(): Int {
        return currencyRateList.size
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setSupportedCurrencies(countries: List<SupportedCurrency>) {
        this.suppoertedCurrencyList = countries
        // notifyDataSetChanged()
    }

    fun setCurrencyRateList(rates: List<CurrencyRateToDisplay>) {
        this.currencyRateList = rates
        notifyDataSetChanged()
    }

    inner class CountriesViewHolder(private val viewBinding: CountriesRowBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun onBind(position: Int) {
            //    val row = suppoertedCurrencyList[position]
            //     viewBinding.countries = row
            viewBinding.currency = currencyRateList[position]
            viewBinding.vm = mViewModel
        }
    }


}


