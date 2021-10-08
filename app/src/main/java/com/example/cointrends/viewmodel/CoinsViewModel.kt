package com.example.cointrends.viewmodel

import androidx.lifecycle.*
import com.example.cointrends.CoinRepo
import com.example.cointrends.model.TrendingCoinsData
import com.example.cointrends.model.request.SingleCoin.SingleCoinData
import com.example.cointrends.util.ApiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoinsViewModel : ViewModel() {
    private val _coinState = MutableLiveData<ApiState<TrendingCoinsData>>()
    val coinState: LiveData<ApiState<TrendingCoinsData>>
        get() = _coinState

    private val _singleCoinState = MutableLiveData<ApiState<SingleCoinData>>()
    val singleCoinState: LiveData<ApiState<SingleCoinData>>
        get() = _singleCoinState


     fun makeTrendsFetch() {

        viewModelScope.launch { CoinRepo.getCoinState().collect { coinState ->
            _coinState.postValue(coinState)
        }}

    }

    fun makeSingleCoinFetch(id: String) {

        viewModelScope.launch { CoinRepo.getSingleCoinState(id).collect { getSingleCoinState ->
            _singleCoinState.postValue(getSingleCoinState)
        }}

    }

}