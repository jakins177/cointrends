package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeveloperData(
    @Json(name = "closed_issues")
    val closedIssues: Double?,
    @Json(name = "code_additions_deletions_4_weeks")
    val codeAdditionsDeletions4Weeks: CodeAdditionsDeletions4Weeks?,
    @Json(name = "commit_count_4_weeks")
    val commitCount4Weeks: Double?,
    @Json(name = "forks")
    val forks: Double?,
    @Json(name = "last_4_weeks_commit_activity_series")
    val last4WeeksCommitActivitySeries: List<Any>?,
    @Json(name = "pull_request_contributors")
    val pullRequestContributors: Double?,
    @Json(name = "pull_requests_merged")
    val pullRequestsMerged: Double?,
    @Json(name = "stars")
    val stars: Double?,
    @Json(name = "subscribers")
    val subscribers: Double?,
    @Json(name = "total_issues")
    val totalIssues: Double?
)