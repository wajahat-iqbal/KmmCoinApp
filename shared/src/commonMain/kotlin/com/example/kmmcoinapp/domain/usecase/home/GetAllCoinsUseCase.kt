package com.example.kmmcoinapp.domain.usecase.home

import com.example.kmmcoinapp.data.repository.CoinRepository
import kotlinx.coroutines.flow.flow

class GetAllCoinsUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke() = flow {

        val response = repository.getAllCoins()
        emit(response)

    }
}

