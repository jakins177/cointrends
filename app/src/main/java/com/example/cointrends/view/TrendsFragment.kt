package com.example.cointrends.view

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
import com.example.cointrends.databinding.FragmentTrendsBinding
import com.example.cointrends.util.ApiState
import com.example.cointrends.viewmodel.CoinsViewModel


//TODO call rvList.adapter?.notifyDataSetChanged() when data changes
class TrendsFragment : Fragment(){
    private val TAG = "TrendsFragment"
    private var _binding: FragmentTrendsBinding? = null
    private val binding get() = _binding!!
    private val coinAdapter by lazy { CoinAdapter()  { item ->
        Log.i(TAG, "${item.item?.name} clicked ")
    } }
    private val trendsViewModel by activityViewModels<CoinsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentTrendsBinding.inflate(layoutInflater, container, false).also {
        _binding = it
        initViews()
        setupObservers()

        trendsViewModel.makeTrendsFetch()
    }.root


    private fun initViews() = with(binding) {
//        rvList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                if (!recyclerView.canScrollVertically(-1) && dy < 0) {
//                   // Log.d(TAG, "TOP OF LIST")
//                } else if (!recyclerView.canScrollVertically(1) && dy > 0) {
//                  //  Log.d(TAG, "BOTTOM OF LIST")
//                //    katViewModel.fetchData(PageAction.NEXT)
//                }
//            }
//        })
        //setup recycle view
        rvList.hasFixedSize()
        rvList.layoutManager = LinearLayoutManager(context)
        rvList.itemAnimator = DefaultItemAnimator()
        //todo pass in data to override the default
        //rvList.adapter = coinAdapter

        rvList.adapter = CoinAdapter() { item ->
            Log.i(TAG, "${item.item?.name} clicked ")

        }

    }


    private fun setupObservers() = with(trendsViewModel) {
        coinState.observe(viewLifecycleOwner) { state ->
            binding.pbLoading.isVisible = state is ApiState.Loading
            if (state is ApiState.Success)
            {
                binding.rvList.adapter = CoinAdapter( state.data.coins) { item ->
                    Log.i(TAG, "${item.item?.name} clicked ")


                }

            }
           // if (state is ApiState.Failure) handleFailure(state.errorMsg)
        }
    }

//    private fun handleSuccess(kats: List<Kat>) {
//       // Log.d(TAG, "ApiState.Success: $kats")
//        (binding.rvKats.adapter as KatAdapter).updateList(kats)
//    }




}