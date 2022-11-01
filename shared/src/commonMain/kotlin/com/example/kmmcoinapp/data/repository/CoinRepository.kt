package com.example.kmmcoinapp.data.repository

import com.example.kmmcoinapp.data.remote.dto.AllCoinsDto

abstract class CoinRepository {
    abstract suspend fun getAllCoins(): AllCoinsDto

}