package com.example.cointrends.repo.remote

import com.example.cointrends.model.TrendingCoinsData
import com.example.cointrends.model.request.SingleCoin.SingleCoinData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {

    @GET("api/v3/search/trending")
    suspend fun getTrendingCoins(

    ): Response<TrendingCoinsData>

    @GET("api/v3/coins/{id}")
    suspend fun getSingleCoinById(
        @Path("id") id: String,

        ): Response<SingleCoinData>
}