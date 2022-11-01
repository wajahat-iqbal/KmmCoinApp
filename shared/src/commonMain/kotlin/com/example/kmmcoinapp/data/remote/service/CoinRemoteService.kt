package com.example.kmmcoinapp.data.remote.service

import com.example.kmmcoinapp.data.remote.dto.AllCoinsDto
import com.example.kmmcoinapp.data.remote.dto.CoinDetailDto
import com.example.kmmcoinapp.data.remote.dto.CoinDto

abstract class CoinRemoteService {

    abstract suspend fun getAllCoins(): AllCoinsDto
    abstract suspend fun getCoinDetail(coinId: String): CoinDetailDto

}