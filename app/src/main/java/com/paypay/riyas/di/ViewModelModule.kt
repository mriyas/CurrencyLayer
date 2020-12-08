package com.paypay.riyas.di

import com.paypay.riyas.viewmodel.DataViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Specific viewModel pattern to tell Koin how to build CountriesViewModel
    viewModel {
        DataViewModel(repository = get())
    }

}