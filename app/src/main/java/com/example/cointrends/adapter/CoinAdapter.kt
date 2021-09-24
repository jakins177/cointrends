package com.example.cointrends.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cointrends.R

class CoinAdapter(private val dataSet: Array<String> = arrayOf("apple", "orange", "grape")) :
    RecyclerView.Adapter<CoinAdapter.TrendViewHolder>() {




    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TrendViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return TrendViewHolder(view)
    }



    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size



    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var coinName : TextView = itemView.findViewById(R.id.coin_info_text_view)

        fun updateInfo (name: String) {
            coinName.text = name
        }
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        val item = dataSet.get(position)
        holder.updateInfo(item)
    }

}