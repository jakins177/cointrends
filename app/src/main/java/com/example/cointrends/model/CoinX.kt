package com.example.cointrends.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinX(
    @Json(name = "item")
    val item: Item?
)