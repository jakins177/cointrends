package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConvertedLast(
    @Json(name = "btc")
    val btc: Double?,
    @Json(name = "eth")
    val eth: Double?,
    @Json(name = "usd")
    val usd: Double?
)