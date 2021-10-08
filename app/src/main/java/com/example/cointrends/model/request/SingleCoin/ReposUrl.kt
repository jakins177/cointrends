package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReposUrl(
    @Json(name = "bitbucket")
    val bitbucket: List<Any>?,
    @Json(name = "github")
    val github: List<String>?
)