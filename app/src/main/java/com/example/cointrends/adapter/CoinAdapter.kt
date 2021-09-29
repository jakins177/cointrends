package com.example.cointrends.adapter

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

class CoinAdapter(private val dataSet:
                  List<CoinX>? = mutableListOf(),
                  private val listener: (CoinX) -> Unit) :
    RecyclerView.Adapter<CoinAdapter.TrendViewHolder>() {




    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TrendViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)



        return TrendViewHolder(view)
    }



    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet?.size?: 0



    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var dataStoreManager: DataStoreManager
        private  val TAG = "CoinAdapter"
        private var coinName : TextView = itemView.findViewById(R.id.coinNameTextView)
        private var coinImage : ImageView = itemView.findViewById(R.id.coinImageView)
        private var coinPrice : TextView = itemView.findViewById(R.id.priceTextView)
        private var coinShortHand : TextView = itemView.findViewById(R.id.shortHandTextView)
        private var watchButton : TextView = itemView.findViewById(R.id.watch_button)





        fun updateInfo (item: CoinX?) {
            if (item != null && item.item != null) {

                watchButton.setOnClickListener{


                    Log.i(TAG, "you have clicked the ${item.item.name} button: ")
                    GlobalScope.launch(Dispatchers.IO) {

                            dataStoreManager.savetoDataStore(
                             trendsID = item.item.id.toString()
                        )
//                        phonebook = Phonebook(name = binding.tvvname.text.toString(),
//                            phone = binding.tvphonr.text.toString(),
//                            address = binding.tvAddress.text.toString())


                    }

                }


                dataStoreManager = DataStoreManager(this.itemView.context)
                coinName.text = item.item.name

                item.item.thumb?.let { coinImage.loadWithGlide(it) }



                coinPrice.text = item.item.priceBtc.toString()

                coinShortHand.text = item.item.symbol

              var marketPrice = item.item.priceBtc?.toBigDecimal()


                coinPrice.text = marketPrice?.setScale(6,RoundingMode.HALF_EVEN).toString()




            };
        }
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        val item = dataSet?.get(position)
        holder.updateInfo(item)




        holder.itemView.setOnClickListener {
            if (item != null) {
                listener(item)
            }
        }
    }

}