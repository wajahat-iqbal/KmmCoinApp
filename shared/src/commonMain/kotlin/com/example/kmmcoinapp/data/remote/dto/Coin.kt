package com.example.kmmcoinapp.data.remote.dto

import com.example.kmmcoinapp.domain.domain_model.Coin
import com.example.kmmcoinapp.domain.domain_model.Status
import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class CoinResponseDto(
    val data: List<CoinItemDto>? = null, val status: StatusDto? = null
)

fun CoinResponseDto.toCoinList():List<Coin>{
    return data?.map {
        it.toCoin()
    }!!
}

@kotlinx.serialization.Serializable
data class CoinItemDto(
    val displayTV: Int? = null,
    @SerialName("") val firstHistoricalData: String? = null,
    val id: Int? = null,
    @SerialName("is_active") val isActive: Int? = null,
    @SerialName("last_historical_data") val lastHistoricalData: String? = null,
    val name: String? = null,
    //val platform: Any? =null,
    val rank: Int? = null,
    val slug: String? = null,
    val symbol: String? = null
)

fun CoinItemDto.toCoin(): Coin {
    return Coin(
        id = id,
        displayTV = displayTV,
        firstHistoricalData = firstHistoricalData,
        isActive = isActive,
        lastHistoricalData = lastHistoricalData,
        name = name,
        rank = rank,
        slug = slug,
        symbol = symbol

    )
}

@kotlinx.serialization.Serializable
data class StatusDto(
    @SerialName("credit_count") val creditCount: Int? = null,
    val elapsed: Int? = null,
    @SerialName("error_code") val errorCode: Int? = null,
    @SerialName("error_message") val errorMessage: String? = null,
    //val notice: Any? =null,
    val timestamp: String? = null
)

fun CoinResponseDto.toStatus(): Status {
    return Status(
        creditCount = status?.creditCount,
        elapsed = status?.elapsed,
        errorCode = status?.errorCode,
        errorMessage = status?.errorMessage,
        timestamp = status?.timestamp
    )
}