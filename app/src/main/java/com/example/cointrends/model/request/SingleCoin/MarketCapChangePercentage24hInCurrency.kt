package com.example.cointrends.model.request.SingleCoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarketCapChangePercentage24hInCurrency(
    @Json(name = "aed")
    val aed: Double?,
    @Json(name = "ars")
    val ars: Double?,
    @Json(name = "aud")
    val aud: Double?,
    @Json(name = "bch")
    val bch: Double?,
    @Json(name = "bdt")
    val bdt: Double?,
    @Json(name = "bhd")
    val bhd: Double?,
    @Json(name = "bits")
    val bits: Double?,
    @Json(name = "bmd")
    val bmd: Double?,
    @Json(name = "bnb")
    val bnb: Double?,
    @Json(name = "brl")
    val brl: Double?,
    @Json(name = "btc")
    val btc: Double?,
    @Json(name = "cad")
    val cad: Double?,
    @Json(name = "chf")
    val chf: Double?,
    @Json(name = "clp")
    val clp: Double?,
    @Json(name = "cny")
    val cny: Double?,
    @Json(name = "czk")
    val czk: Double?,
    @Json(name = "dkk")
    val dkk: Double?,
    @Json(name = "dot")
    val dot: Double?,
    @Json(name = "eos")
    val eos: Double?,
    @Json(name = "eth")
    val eth: Double?,
    @Json(name = "eur")
    val eur: Double?,
    @Json(name = "gbp")
    val gbp: Double?,
    @Json(name = "hkd")
    val hkd: Double?,
    @Json(name = "huf")
    val huf: Double?,
    @Json(name = "idr")
    val idr: Double?,
    @Json(name = "ils")
    val ils: Double?,
    @Json(name = "inr")
    val inr: Double?,
    @Json(name = "jpy")
    val jpy: Double?,
    @Json(name = "krw")
    val krw: Double?,
    @Json(name = "kwd")
    val kwd: Double?,
    @Json(name = "link")
    val link: Double?,
    @Json(name = "lkr")
    val lkr: Double?,
    @Json(name = "ltc")
    val ltc: Double?,
    @Json(name = "mmk")
    val mmk: Double?,
    @Json(name = "mxn")
    val mxn: Double?,
    @Json(name = "myr")
    val myr: Double?,
    @Json(name = "ngn")
    val ngn: Double?,
    @Json(name = "nok")
    val nok: Double?,
    @Json(name = "nzd")
    val nzd: Double?,
    @Json(name = "php")
    val php: Double?,
    @Json(name = "pkr")
    val pkr: Double?,
    @Json(name = "pln")
    val pln: Double?,
    @Json(name = "rub")
    val rub: Double?,
    @Json(name = "sar")
    val sar: Double?,
    @Json(name = "sats")
    val sats: Double?,
    @Json(name = "sek")
    val sek: Double?,
    @Json(name = "sgd")
    val sgd: Double?,
    @Json(name = "thb")
    val thb: Double?,
    @Json(name = "try")
    val tryX: Double?,
    @Json(name = "twd")
    val twd: Double?,
    @Json(name = "uah")
    val uah: Double?,
    @Json(name = "usd")
    val usd: Double?,
    @Json(name = "vef")
    val vef: Double?,
    @Json(name = "vnd")
    val vnd: Double?,
    @Json(name = "xag")
    val xag: Double?,
    @Json(name = "xau")
    val xau: Double?,
    @Json(name = "xdr")
    val xdr: Double?,
    @Json(name = "xlm")
    val xlm: Double?,
    @Json(name = "xrp")
    val xrp: Double?,
    @Json(name = "yfi")
    val yfi: Double?,
    @Json(name = "zar")
    val zar: Double?
)