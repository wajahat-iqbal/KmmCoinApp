package com.example.kmmcoinapp.domain.usecase.home

import com.example.kmmcoinapp.data.repository.CoinRepository
import kotlinx.coroutines.flow.flow

class GetAllCoinsUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(start:Int , limit:Int) = flow {

        val response = repository.getAllCoins(start, limit)
        emit(response)

    }
}

