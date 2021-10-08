package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksX(
    @Json(name = "announcement_url")
    val announcementUrl: List<String>?,
    @Json(name = "bitcointalk_thread_identifier")
    val bitcointalkThreadIdentifier: Any?,
    @Json(name = "blockchain_site")
    val blockchainSite: List<String>?,
    @Json(name = "chat_url")
    val chatUrl: List<String>?,
    @Json(name = "facebook_username")
    val facebookUsername: String?,
    @Json(name = "homepage")
    val homepage: List<String>?,
    @Json(name = "official_forum_url")
    val officialForumUrl: List<String>?,
    @Json(name = "repos_url")
    val reposUrl: ReposUrl?,
    @Json(name = "subreddit_url")
    val subredditUrl: String?,
    @Json(name = "telegram_channel_identifier")
    val telegramChannelIdentifier: String?,
    @Json(name = "twitter_screen_name")
    val twitterScreenName: String?
)