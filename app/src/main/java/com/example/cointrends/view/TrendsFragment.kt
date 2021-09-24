package com.example.cointrends.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cointrends.R
import com.example.cointrends.adapter.CoinAdapter
import com.example.cointrends.databinding.FragmentTrendsBinding
//TODO call rvList.adapter?.notifyDataSetChanged() when data changes
class TrendsFragment : Fragment(){
    private var _binding: FragmentTrendsBinding? = null
    private val binding get() = _binding!!
    private val coinAdapter by lazy { CoinAdapter() }
   // private val katViewModel by activityViewModels<KatViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentTrendsBinding.inflate(layoutInflater, container, false).also {
        _binding = it
        initViews()
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
        rvList.hasFixedSize()
        rvList.layoutManager = LinearLayoutManager(context)
        rvList.itemAnimator = DefaultItemAnimator()
        //todo pass in data to override the default
        rvList.adapter = CoinAdapter()


    }





}