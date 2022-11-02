package com.example.kmmcoinapp.data.remote.service

import com.example.kmmcoinapp.comman.Constant
import com.example.kmmcoinapp.data.remote.dto.CoinResponseDto
import com.example.kmmcoinapp.data.remote.service.EndPoints.ALL_COIN

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ImpCoinRemoteService(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : CoinRemoteService() {
    override suspend fun getAllCoins(start: Int, limit: Int): CoinResponseDto =
        httpClient.get("$baseUrl$ALL_COIN") {
            header("X-CMC_PRO_API_KEY",Constant.API_KEY)
            parameter("start", start)
            parameter("limit", limit)
        }.body()


}