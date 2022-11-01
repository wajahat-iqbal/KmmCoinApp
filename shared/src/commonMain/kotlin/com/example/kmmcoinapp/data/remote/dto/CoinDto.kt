package com.example.kmmcoinapp.data.remote.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CoinDto(
    @SerialName("id")
    val id: String,
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("is_new")
    val isNew: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("rank")
    val rank: Int,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("type")
    val type: String
)



@kotlinx.serialization.Serializable
data class AllCoinsDto(
    val coins: MutableList<CoinDto>
)

