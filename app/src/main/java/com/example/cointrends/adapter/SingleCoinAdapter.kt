package com.example.cointrends.adapter

import android.graphics.Color
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cointrends.R
import com.example.cointrends.model.CoinX
import com.example.cointrends.model.request.SingleCoin.SingleCoinData
import com.example.cointrends.util.DataStoreManager
import com.olayg.onlykats.util.loadWithGlide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.math.RoundingMode
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class SingleCoinAdapter(private val dataSet:
                  List<SingleCoinData>? = mutableListOf(),
                  private val listener: (SingleCoinData) -> Unit) :
    RecyclerView.Adapter<SingleCoinAdapter.SingleCoinViewHolder>() {




    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SingleCoinViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.watch_list_text_item, viewGroup, false)



        return SingleCoinViewHolder(view)
    }



    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet?.size?: 0



    inner class SingleCoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var dataStoreManager: DataStoreManager
        private  val TAG = "CoinAdapter"
        private var coinName : TextView = itemView.findViewById(R.id.coinNameTextView)
        private var coinImage : ImageView = itemView.findViewById(R.id.coinImageView)
        private var coinPrice : TextView = itemView.findViewById(R.id.priceTextView)
        private var coinShortHand : TextView = itemView.findViewById(R.id.shortHandTextView)
        private var hour24PercentChange : TextView = itemView.findViewById(R.id.hour24ChangePercTextView)
//        private var watchButton : TextView = itemView.findViewById(R.id.watch_button)





        fun updateInfo (item: SingleCoinData?) {
            if (item != null ) {

//                watchButton.setOnClickListener{
//
//
//                    Log.i(TAG, "you have clicked the ${item.name} button: ")
//                    GlobalScope.launch(Dispatchers.IO) {
//
//                        dataStoreManager.savetoDataStore(
//                            trendsID = item.item.id.toString()
//                        )
////                        phonebook = Phonebook(name = binding.tvvname.text.toString(),
////                            phone = binding.tvphonr.text.toString(),
////                            address = binding.tvAddress.text.toString())
//
//
//                    }
//
//                }


                dataStoreManager = DataStoreManager(this.itemView.context)
                coinName.text = item.name

                item.image?.thumb?.let { coinImage.loadWithGlide(it) }



                coinShortHand.text = item.symbol

                var marketPrice = item.marketData?.currentPrice?.btc?.toBigDecimal()


                coinPrice.text = marketPrice?.setScale(6,RoundingMode.HALF_EVEN).toString()


                var h24Change = item.marketData?.priceChangePercentage24h?.toBigDecimal()

             //   h24Change = h24Change?.setScale(2,RoundingMode.HALF_EVEN)

                if (h24Change != null) {
                    if(h24Change.toDouble() >= 0) {

                        hour24PercentChange.setTextColor(Color.parseColor("#009933"));
                    }
                    else
                    {
                        hour24PercentChange.setTextColor(Color.parseColor("#ff0000"));
                    }
                }

                hour24PercentChange.text = "${h24Change?.setScale(2,RoundingMode.HALF_EVEN).toString()}%"


            };
        }
    }

    override fun onBindViewHolder(holder: SingleCoinViewHolder, position: Int) {
        val item = dataSet?.get(position)
        holder.updateInfo(item)




        holder.itemView.setOnClickListener {
            if (item != null) {
                listener(item)
            }
        }
    }

}