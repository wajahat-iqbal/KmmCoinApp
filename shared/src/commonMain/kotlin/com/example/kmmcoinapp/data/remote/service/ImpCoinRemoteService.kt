package com.example.kmmcoinapp.data.remote.service

import com.example.kmmcoinapp.data.remote.dto.AllCoinsDto
import com.example.kmmcoinapp.data.remote.dto.CoinDetailDto
import com.example.kmmcoinapp.data.remote.dto.CoinDto
import com.example.kmmcoinapp.data.remote.service.EndPoints.ALL_COIN
import com.example.kmmcoinapp.data.remote.service.EndPoints.COIN_DETAIL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ImpCoinRemoteService(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : CoinRemoteService() {
    override suspend fun getAllCoins(): AllCoinsDto = httpClient.get("$baseUrl$ALL_COIN") {

    }.body()

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto = httpClient.get("$baseUrl$COIN_DETAIL+$coinId"){

    }.body()
}