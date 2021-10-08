package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommunityData(
    @Json(name = "facebook_likes")
    val facebookLikes: Any?,
    @Json(name = "reddit_accounts_active_48h")
    val redditAccountsActive48h: Double?,
    @Json(name = "reddit_average_comments_48h")
    val redditAverageComments48h: Double?,
    @Json(name = "reddit_average_posts_48h")
    val redditAveragePosts48h: Double?,
    @Json(name = "reddit_subscribers")
    val redditSubscribers: Double?,
    @Json(name = "telegram_channel_user_count")
    val telegramChannelUserCount: Double?,
    @Json(name = "twitter_followers")
    val twitterFollowers: Double?
)