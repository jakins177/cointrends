package com.example.cointrends.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinData(
    @Json(name = "coins")
    val coins: List<CoinX>?,
    @Json(name = "exchanges")
    val exchanges: List<Any>?
)