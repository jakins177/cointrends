package com.example.cointrends.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "coin_id")
    val coinId: Int?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "large")
    val large: String?,
    @Json(name = "market_cap_rank")
    val marketCapRank: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "price_btc")
    val priceBtc: Double?,
    @Json(name = "score")
    val score: Int?,
    @Json(name = "slug")
    val slug: String?,
    @Json(name = "small")
    val small: String?,
    @Json(name = "symbol")
    val symbol: String?,
    @Json(name = "thumb")
    val thumb: String?
)