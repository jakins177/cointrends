package com.example.cointrends.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cointrends.R
import com.example.cointrends.model.CoinX

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
        private var coinName : TextView = itemView.findViewById(R.id.coin_info_text_view)

        fun updateInfo (item: CoinX?) {
            if (item != null && item.item != null) {

                coinName.text = item.item.name
            };
        }
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        val item = dataSet?.get(position)
        holder.updateInfo(item)
    }

}