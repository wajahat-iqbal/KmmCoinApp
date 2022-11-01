package com.example.kmmcoinapp.data.remote.dto

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class CoinDto(
    val data: List<DataDto>? = null,
    val status: StatusDto? =null
)

@kotlinx.serialization.Serializable
data class DataDto(
    val displayTV: Int? =null,
    @SerialName("")
    val firstHistoricalData: String? =null,
    val id: Int? =null,
    @SerialName("is_active")
    val is_active: Int? =null,
    @SerialName("last_historical_data")
    val lastHistoricalData: String? =null,
    val name: String? =null,
    //val platform: Any? =null,
    val rank: Int? =null,
    val slug: String? =null,
    val symbol: String? =null
)

@kotlinx.serialization.Serializable
data class StatusDto(
    @SerialName("credit_count")
    val creditCount: Int? =null,
    val elapsed: Int? =null,
    @SerialName("error_code")
    val errorCode: Int? =null,
    @SerialName("error_message")
    val errorMessage: String? =null,
    //val notice: Any? =null,
    val timestamp: String? =null
)