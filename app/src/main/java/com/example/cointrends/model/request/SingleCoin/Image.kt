package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "large")
    val large: String?,
    @Json(name = "small")
    val small: String?,
    @Json(name = "thumb")
    val thumb: String?
)