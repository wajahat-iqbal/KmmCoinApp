package com.example.kmmcoinapp.data.remote.service

import com.example.kmmcoinapp.data.remote.dto.CoinDto

abstract class CoinRemoteService {
    abstract suspend fun getAllCoins(start:Int , limit:Int): CoinDto
}