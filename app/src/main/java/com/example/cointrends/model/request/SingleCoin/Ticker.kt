package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ticker(
    @Json(name = "base")
    val base: String?,
    @Json(name = "bid_ask_spread_percentage")
    val bidAskSpreadPercentage: Double?,
    @Json(name = "coin_id")
    val coinId: String?,
    @Json(name = "converted_last")
    val convertedLast: ConvertedLast?,
    @Json(name = "converted_volume")
    val convertedVolume: ConvertedVolume?,
    @Json(name = "is_anomaly")
    val isAnomaly: Boolean?,
    @Json(name = "is_stale")
    val isStale: Boolean?,
    @Json(name = "last")
    val last: Double?,
    @Json(name = "last_fetch_at")
    val lastFetchAt: String?,
    @Json(name = "last_traded_at")
    val lastTradedAt: String?,
    @Json(name = "market")
    val market: Market?,
    @Json(name = "target")
    val target: String?,
    @Json(name = "target_coin_id")
    val targetCoinId: String?,
    @Json(name = "timestamp")
    val timestamp: String?,
    @Json(name = "token_info_url")
    val tokenInfoUrl: Any?,
    @Json(name = "trade_url")
    val tradeUrl: String?,
    @Json(name = "trust_score")
    val trustScore: String?,
    @Json(name = "volume")
    val volume: Double?
)