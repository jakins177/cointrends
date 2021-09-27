package com.example.cointrends

import android.util.Log
import com.example.cointrends.model.CoinData
import com.example.cointrends.repo.remote.RetrofitInstance
import com.example.cointrends.util.ApiState
import kotlinx.coroutines.flow.flow

object CoinRepo {

    private val TAG = "CoinRepo"
    private val coinService by lazy { RetrofitInstance.coinService }


    fun getCoinState() = flow<ApiState<CoinData>> {

        emit(ApiState.Loading)


        val state =
            if (true) {
                val coinResponse = coinService.getTrendingCoins()


                if (coinResponse.isSuccessful) {

                    Log.i(TAG, "getCoinState coin body is : ${coinResponse.body()} ")
                    ApiState.Success(coinResponse.body()!!)


                } else {
                    ApiState.Failure("Error fetching data.")
                }
            } else {
                ApiState.Error("Unknown error fetching API")
            }

        emit(state)


    }

}