package com.paypay.riyas.di

import com.paypay.riyas.repository.DataRepository
import com.paypay.riyas.repository.DataRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    fun provideDataRepository(): DataRepository {
        return DataRepositoryImpl()
    }
    factory { provideDataRepository() }

}