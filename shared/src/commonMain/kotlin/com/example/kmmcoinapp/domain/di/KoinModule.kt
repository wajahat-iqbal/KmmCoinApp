package com.example.kmmcoinapp.domain.di

import com.example.kmmcoinapp.data.remote.service.CoinRemoteService
import com.example.kmmcoinapp.data.remote.service.ImpCoinRemoteService
import com.example.kmmcoinapp.data.repository.CoinRepository
import com.example.kmmcoinapp.data.repository.ImpCoinRepository
import com.example.kmmcoinapp.domain.usecase.home.GetAllCoinsUseCase
import com.example.kmmcoinapp.platformModule
import com.example.kmmcoinapp.presentation.home.GetAllCoinsViewModel
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(
    enableNetworkLogs: Boolean = false, baseUrl: String, appDeclaration: KoinAppDeclaration = {}
) = startKoin {
    appDeclaration()
    modules(module(enableNetworkLogs = enableNetworkLogs, baseUrl))
}

fun initKoin(baseUrl: String) = initKoin(enableNetworkLogs = true, baseUrl) {}

fun module(enableNetworkLogs: Boolean, baseUrl: String) =
    commonModule(enableNetworkLogs, baseUrl) + dataModule(
        enableNetworkLogs,
        baseUrl
    ) + getUseCaseModule() + platformModule()

fun commonModule(enableNetworkLogs: Boolean, baseUrl: String) = module {

    single { createJson() }

    single {
        createHttpClient(
            get(), get(), enableNetworkLogs = enableNetworkLogs
        )
    }
}

fun dataModule(enableNetworkLogs: Boolean, baseUrl: String) = module {

    single<CoinRemoteService> {
        ImpCoinRemoteService(
            baseUrl = baseUrl, httpClient = get()
        )

    }

    single<CoinRepository> {
        ImpCoinRepository(get())
    }

}

fun getUseCaseModule() = module {
    single {
        GetAllCoinsUseCase(get())
    }

}


fun createHttpClient(
    httpClientEngine: HttpClientEngine, json: Json, enableNetworkLogs: Boolean
) = HttpClient(httpClientEngine) {

    install(ContentNegotiation) {
        json(json)
    }
    if (enableNetworkLogs) {
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }


