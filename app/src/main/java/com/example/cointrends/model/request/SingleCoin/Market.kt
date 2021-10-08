package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Market(
    @Json(name = "has_trading_incentive")
    val hasTradingIncentive: Boolean?,
    @Json(name = "identifier")
    val identifier: String?,
    @Json(name = "name")
    val name: String?
)