package com.example.kmmcoinapp.data.remote.service

import com.example.kmmcoinapp.data.remote.dto.CoinResponseDto

abstract class CoinRemoteService {
    abstract suspend fun getAllCoins(start:Int , limit:Int): CoinResponseDto
}