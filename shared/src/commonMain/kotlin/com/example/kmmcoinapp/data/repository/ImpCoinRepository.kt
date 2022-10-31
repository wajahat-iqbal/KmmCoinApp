package com.example.kmmcoinapp.data.repository

import com.example.kmmcoinapp.data.remote.dto.CoinDto
import com.example.kmmcoinapp.data.remote.service.CoinRemoteService

class ImpCoinRepository(
    private val coinRemoteService: CoinRemoteService
) : CoinRepository() {
    override suspend fun getAllCoins() = coinRemoteService.getAllCoins()
}