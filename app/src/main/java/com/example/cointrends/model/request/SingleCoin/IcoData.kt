package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IcoData(
    @Json(name = "accepting_currencies")
    val acceptingCurrencies: String?,
    @Json(name = "amount_for_sale")
    val amountForSale: Any?,
    @Json(name = "base_pre_sale_amount")
    val basePreSaleAmount: String?,
    @Json(name = "base_public_sale_amount")
    val basePublicSaleAmount: Double?,
    @Json(name = "bounty_detail_url")
    val bountyDetailUrl: String?,
    @Json(name = "country_origin")
    val countryOrigin: String?,
    @Json(name = "description")
    val description: Any?,
    @Json(name = "hardcap_amount")
    val hardcapAmount: Any?,
    @Json(name = "hardcap_currency")
    val hardcapCurrency: String?,
    @Json(name = "ico_end_date")
    val icoEndDate: Any?,
    @Json(name = "ico_start_date")
    val icoStartDate: Any?,
    @Json(name = "kyc_required")
    val kycRequired: Boolean?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "pre_sale_available")
    val preSaleAvailable: Any?,
    @Json(name = "pre_sale_end_date")
    val preSaleEndDate: Any?,
    @Json(name = "pre_sale_ended")
    val preSaleEnded: Boolean?,
    @Json(name = "pre_sale_start_date")
    val preSaleStartDate: Any?,
    @Json(name = "quote_pre_sale_amount")
    val quotePreSaleAmount: String?,
    @Json(name = "quote_pre_sale_currency")
    val quotePreSaleCurrency: String?,
    @Json(name = "quote_public_sale_amount")
    val quotePublicSaleAmount: Double?,
    @Json(name = "quote_public_sale_currency")
    val quotePublicSaleCurrency: String?,
    @Json(name = "short_desc")
    val shortDesc: String?,
    @Json(name = "softcap_amount")
    val softcapAmount: Any?,
    @Json(name = "softcap_currency")
    val softcapCurrency: String?,
    @Json(name = "total_raised")
    val totalRaised: Any?,
    @Json(name = "total_raised_currency")
    val totalRaisedCurrency: String?,
    @Json(name = "whitelist_available")
    val whitelistAvailable: Any?,
    @Json(name = "whitelist_end_date")
    val whitelistEndDate: Any?,
    @Json(name = "whitelist_start_date")
    val whitelistStartDate: Any?,
    @Json(name = "whitelist_url")
    val whitelistUrl: String?
)