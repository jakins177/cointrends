package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Description(
    @Json(name = "ar")
    val ar: String?,
    @Json(name = "de")
    val de: String?,
    @Json(name = "en")
    val en: String?,
    @Json(name = "es")
    val es: String?,
    @Json(name = "fr")
    val fr: String?,
    @Json(name = "hu")
    val hu: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "it")
    val `it`: String?,
    @Json(name = "ja")
    val ja: String?,
    @Json(name = "ko")
    val ko: String?,
    @Json(name = "nl")
    val nl: String?,
    @Json(name = "pl")
    val pl: String?,
    @Json(name = "pt")
    val pt: String?,
    @Json(name = "ro")
    val ro: String?,
    @Json(name = "ru")
    val ru: String?,
    @Json(name = "sv")
    val sv: String?,
    @Json(name = "th")
    val th: String?,
    @Json(name = "tr")
    val tr: String?,
    @Json(name = "vi")
    val vi: String?,
    @Json(name = "zh")
    val zh: String?,
    @Json(name = "zh-tw")
    val zhTw: String?
)