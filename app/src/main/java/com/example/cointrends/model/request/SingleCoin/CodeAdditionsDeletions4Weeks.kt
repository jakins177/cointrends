package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CodeAdditionsDeletions4Weeks(
    @Json(name = "additions")
    val additions: Any?,
    @Json(name = "deletions")
    val deletions: Any?
)