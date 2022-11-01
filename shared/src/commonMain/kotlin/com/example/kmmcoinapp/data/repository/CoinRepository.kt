package com.example.kmmcoinapp.data.repository

import com.example.kmmcoinapp.data.remote.dto.CoinDto

abstract class CoinRepository {
    abstract suspend fun getAllCoins(start:Int , limit:Int): CoinDto

}