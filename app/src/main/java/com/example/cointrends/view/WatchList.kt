package com.example.cointrends.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.cointrends.databinding.FragmentWatchListBinding

class WatchList : Fragment() {
    private var _binding: FragmentWatchListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentWatchListBinding.inflate(layoutInflater, container, false).also {
        _binding = it
        //  initViews()
    }.root

}

