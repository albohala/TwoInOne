package com.example.twoinone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row_numbers_game.view.*

class NumbersGameRVAdapter(private val itemsEntered: ArrayList<String>): RecyclerView.Adapter<NumbersGameRVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row_numbers_game,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemsEntered[position]

        holder.itemView.apply {
            tvNumbersGame.text = item
        }
    }

    override fun getItemCount() = itemsEntered.size


}