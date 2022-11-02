package com.example.kmmcoinapp.data.repository

import com.example.kmmcoinapp.data.remote.dto.CoinResponseDto

abstract class CoinRepository {
    abstract suspend fun getAllCoins(start:Int , limit:Int): CoinResponseDto

}