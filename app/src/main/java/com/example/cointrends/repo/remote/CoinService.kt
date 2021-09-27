package com.example.cointrends.repo.remote

import com.example.cointrends.model.CoinData
import retrofit2.Response
import retrofit2.http.GET

interface CoinService {

    @GET("api/v3/search/trending")
    suspend fun getTrendingCoins(

    ): Response<CoinData>
}