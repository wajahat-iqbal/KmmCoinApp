package com.example.kmmcoinapp.presentation

import com.example.kmmcoinapp.domain.domain_model.Status

sealed class GenericState<out T> {
    class Idle<T>() : GenericState<T>()
    class Loading<T>() : GenericState<T>()
    class Response<T>(val data: T,val status: Status) : GenericState<T>()
    class Error<T>(val status: Status) : GenericState<T>()
}

