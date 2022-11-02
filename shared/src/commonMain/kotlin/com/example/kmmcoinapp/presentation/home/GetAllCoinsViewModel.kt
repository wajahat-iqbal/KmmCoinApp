package com.example.kmmcoinapp.presentation.home


import com.example.kmmcoinapp.data.remote.dto.toCoinList
import com.example.kmmcoinapp.data.remote.dto.toStatus
import com.example.kmmcoinapp.domain.domain_model.Coin
import com.example.kmmcoinapp.domain.domain_model.Status
import com.example.kmmcoinapp.domain.usecase.home.GetAllCoinsUseCase
import com.example.kmmcoinapp.presentation.GenericState
import com.example.kmmcoinapp.presentation.GenericState.*
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GetAllCoinsViewModel(
    private val getAllCoinsUseCase: GetAllCoinsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<GenericState<List<Coin>>> =
        MutableStateFlow(Loading())
    var state = _state.asStateFlow()

    fun getAllCoins(start: Int, limit: Int) {
        _state.value = Loading()
        viewModelScope.launch {
            getAllCoinsUseCase.invoke(start, limit).collect { coinResponse ->
                if (coinResponse.data != null && coinResponse.status != null) {
                    _state.value = Response(coinResponse.toCoinList(), coinResponse.toStatus())
                } else if (coinResponse.data == null && coinResponse.status != null) {
                    _state.value = Error(coinResponse.toStatus())
                } else {
                    val status = Status(
                        errorCode = 0, errorMessage = "Unable to access the system"
                    )
                    _state.value = Error(status)
                }
            }
        }
    }

}