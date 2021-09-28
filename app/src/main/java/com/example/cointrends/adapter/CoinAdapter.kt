package com.example.cointrends.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cointrends.R
import com.example.cointrends.model.CoinX
import com.olayg.onlykats.util.loadWithGlide
import java.math.BigDecimal
import java.math.RoundingMode

class CoinAdapter(private val dataSet:
                  List<CoinX>? = mutableListOf()) :
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
        private var coinName : TextView = itemView.findViewById(R.id.coinNameTextView)
        private var coinImage : ImageView = itemView.findViewById(R.id.coinImageView)
        private var coinPrice : TextView = itemView.findViewById(R.id.priceTextView)
        private var coinShortHand : TextView = itemView.findViewById(R.id.shortHandTextView)


        fun updateInfo (item: CoinX?) {
            if (item != null && item.item != null) {

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
    }

}