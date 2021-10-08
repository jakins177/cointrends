package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Platforms(
    @Json(name = "")
    val x: String?
)