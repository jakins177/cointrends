package com.example.cointrends.viewmodel

import androidx.lifecycle.*
import com.example.cointrends.CoinRepo
import com.example.cointrends.model.CoinData
import com.example.cointrends.util.ApiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TrendsViewModel : ViewModel() {
    private val _coinState = MutableLiveData<ApiState<CoinData>>()
    val coinState: LiveData<ApiState<CoinData>>
        get() = _coinState


     fun makeFetch() {

        viewModelScope.launch { CoinRepo.getCoinState().collect { coinState ->
            _coinState.postValue(coinState)
        }}

    }

}