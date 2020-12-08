package com.paypay.riyas.di

/**
 * Main dependency component.
 * This will create and provide required dependencies with sub dependencies.
 */
val appComponent = listOf( apiModule,
    viewModelModule,
    repositoryModule,
    networkModule,
    databaseModule,
    adapterModule,
    sharedPrefModule)