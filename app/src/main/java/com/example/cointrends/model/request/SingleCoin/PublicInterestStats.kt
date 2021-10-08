package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PublicInterestStats(
    @Json(name = "alexa_rank")
    val alexaRank: Double?,
    @Json(name = "bing_matches")
    val bingMatches: Any?
)