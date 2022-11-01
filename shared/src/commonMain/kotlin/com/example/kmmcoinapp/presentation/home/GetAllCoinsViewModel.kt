package com.example.kmmcoinapp.presentation.home

import com.example.kmmcoinapp.data.remote.dto.CoinDto
import com.example.kmmcoinapp.domain.usecase.home.GetAllCoinsUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GetAllCoinsViewModel(
    private val getAllCoinsUseCase: GetAllCoinsUseCase
) : ViewModel() {

    fun getAllCoins(start: Int, limit: Int) {
        viewModelScope.launch {
            getAllCoinsUseCase.invoke(start, limit).collect {
                println(it.toString())
            }
        }
    }

}