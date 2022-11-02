package com.example.kmmcoinapp.data.repository

import com.example.kmmcoinapp.data.remote.service.CoinRemoteService

class ImpCoinRepository(
    private val coinRemoteService: CoinRemoteService
) : CoinRepository() {
    override suspend fun getAllCoins(start:Int , limit:Int) = coinRemoteService.getAllCoins(start, limit)
}