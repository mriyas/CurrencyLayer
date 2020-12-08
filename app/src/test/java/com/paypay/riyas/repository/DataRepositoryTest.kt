package com.paypay.riyas.repository

import com.paypay.riyas.base.BaseUTTest
import com.paypay.riyas.di.configureTestAppComponent
import com.paypay.riyas.util.AppResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.mockito.MockitoAnnotations
import java.net.HttpURLConnection


@RunWith(JUnit4::class)
class DataRepositoryTest : BaseUTTest() {

    //Target
    private lateinit var mRepo: DataRepository


    val mCount = 168
    val mRateCount = 168


    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Before
    fun start() {
        super.setUp()

        startKoin {
            // androidContext(context)
            modules(configureTestAppComponent(getMockWebServerUrl()))
        }
    }
    @Test
    fun test_supported_currency_api_success_response() = runBlocking<Unit> {

        mockNetworkResponseWithFileContent("success_resp_list.json", HttpURLConnection.HTTP_OK)
        mRepo = DataRepositoryImpl()

        val dataReceived = mRepo.getSupportedCurrenciesFromApi()
        assertNotNull(dataReceived)
        when (dataReceived) {
            is AppResult.Success -> {
                assertTrue("test_api_success_response() : test case success", mCount == dataReceived.successData!!.size)
                //     assertEquals()
            }
            else ->{
                assertFalse("test_api_success_response() : test case failed",true)
            }
        }

    }
    @Test
    fun test_supported_currency_api_fail_response() = runBlocking<Unit> {

        mockNetworkResponseWithFileContent("fail_resp_list.json", HttpURLConnection.HTTP_OK)
        mRepo = DataRepositoryImpl()

        val dataReceived = mRepo.getSupportedCurrenciesFromApi()
        assertNotNull(dataReceived)
        when (dataReceived) {
            is AppResult.Error -> {
                assertTrue("test_api_fail_response() : test case success ",  dataReceived.exception!=null)
                //     assertEquals()
            }
            else ->{
                assertFalse("test_api_fail_response() : test case failed",true)
            }
        }

    }
    @Test
    fun test_rate_api_success_response() = runBlocking<Unit> {

        mockNetworkResponseWithFileContent("success_resp_rate.json", HttpURLConnection.HTTP_OK)
        mRepo = DataRepositoryImpl()

        val dataReceived = mRepo.getCurrencyRateFromApi()
        assertNotNull(dataReceived)
        when (dataReceived) {
            is AppResult.Success -> {
                assertTrue("test_api_success_response() : test case success", mRateCount == dataReceived.successData!!.size)
                //     assertEquals()
            }
            else ->{
                assertFalse("test_api_success_response() : test case failed",true)
            }
        }

    }

    @Test
    fun test_rate_api_fail_response() = runBlocking<Unit> {

        mockNetworkResponseWithFileContent("fail_resp_list.json", HttpURLConnection.HTTP_OK)
        mRepo = DataRepositoryImpl()

        val dataReceived = mRepo.getCurrencyRateFromApi()
        assertNotNull(dataReceived)
        when (dataReceived) {
            is AppResult.Error -> {
                assertTrue("test_api_fail_response() : test case success ",  dataReceived.exception!=null)
                //     assertEquals()
            }
            else ->{
                assertFalse("test_api_fail_response() : test case failed",true)
            }
        }

    }




}
