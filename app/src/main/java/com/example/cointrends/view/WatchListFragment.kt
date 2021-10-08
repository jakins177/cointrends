package com.example.cointrends.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cointrends.adapter.CoinAdapter
import com.example.cointrends.adapter.SingleCoinAdapter

import com.example.cointrends.databinding.FragmentWatchListBinding
import com.example.cointrends.model.request.SingleCoin.SingleCoinData
import com.example.cointrends.util.ApiState
import com.example.cointrends.util.DataStoreManager
import com.example.cointrends.viewmodel.CoinsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WatchListFragment : Fragment() {
    private var _binding: FragmentWatchListBinding? = null
    private val binding get() = _binding!!
    lateinit var dataStoreManager: DataStoreManager
    private  val TAG = "WatchListFragment"
    private val coins = mutableListOf<SingleCoinData>()
    private var mContext: Context? = null
    private val singleCoinAdapter by lazy { SingleCoinAdapter()  { item ->
        Log.i(TAG, "${item.name} clicked ")
    } }

    private val singleCoinViewModel by activityViewModels<CoinsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentWatchListBinding.inflate(layoutInflater, container, false).also {
        _binding = it
         initViews()


        setupObservers()

    }.root

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


     private fun initViews() = with(binding) {
         dataStoreManager = DataStoreManager(mContext!!)


         rvList.hasFixedSize()
         rvList.layoutManager = LinearLayoutManager(context)
         rvList.itemAnimator = DefaultItemAnimator()
         //todo pass in data to override the default
         //rvList.adapter = coinAdapter

         rvList.adapter = SingleCoinAdapter() { item ->
             Log.i(TAG, "${item.name} clicked ")

         }


         GlobalScope.launch(
             Dispatchers.IO
         ) {
             dataStoreManager.getFromDataStore().catch { e ->
                 e.printStackTrace()
             }.collect {
                 withContext(Dispatchers.Main) {
                     Log.i(TAG, "updateInfo the saved info is : $it. ")
//                                binding.tvcphonr.setText(it.phone)
//                                binding.tvxAddress.setText(it.address)
//                                binding.tvxname.setText(it.name)
                     singleCoinViewModel.makeSingleCoinFetch(it)

                 }

             }

         }

     }


    private fun setupObservers() = with(singleCoinViewModel) {
        singleCoinState.observe(viewLifecycleOwner) { state ->
            binding.pbLoading.isVisible = state is ApiState.Loading
            if (state is ApiState.Success)
            {

                coins.add(state.data)
                binding.rvList.adapter = SingleCoinAdapter(coins) { item ->
                    android.util.Log.i(TAG, "${item?.name} clicked ")


                }

            }
            // if (state is ApiState.Failure) handleFailure(state.errorMsg)
        }
    }

}

