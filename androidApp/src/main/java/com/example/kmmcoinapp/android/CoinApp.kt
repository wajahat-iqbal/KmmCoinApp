package com.example.kmmcoinapp.android

import android.app.Application
import com.example.kmmcoinapp.domain.di.initKoin
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

class CoinApp : Application(){

    override fun onCreate() {
        super.onCreate()
        initKoin(baseUrl = "https://pro-api.coinmarketcap.com/v1", enableNetworkLogs = true) {
            androidContext(this@CoinApp)
            modules(
                listOf(module {
                    /**
                     * android specific modules
                     */
                })
            )
        }
    }
}