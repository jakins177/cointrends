package com.example.cointrends.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.cointrends.databinding.FragmentWatchListBinding
import com.example.cointrends.util.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WatchList : Fragment() {
    private var _binding: FragmentWatchListBinding? = null
    private val binding get() = _binding!!
    lateinit var dataStoreManager: DataStoreManager
    private  val TAG = "WatchList"
    private var mContext: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentWatchListBinding.inflate(layoutInflater, container, false).also {
        _binding = it
         initViews()


    }.root

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }



     private fun initViews() = with(binding) {
         dataStoreManager = DataStoreManager(mContext!!)

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

                 }

             }

         }

     }



}

