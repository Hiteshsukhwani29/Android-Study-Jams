package com.hitesh.genie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hitesh.genie.R
import com.hitesh.genie.quotesModel

class quotesAdapter(private val mList: List<quotesModel>) : RecyclerView.Adapter<quotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_quote, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val quotesModel = mList[position]

        holder.quote.text = quotesModel.getQuote()
        holder.quote_author.text = quotesModel.getQuoteAuthor()

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val quote: TextView = itemView.findViewById(R.id.quote)
        val quote_author: TextView = itemView.findViewById(R.id.quote_author)
    }
}