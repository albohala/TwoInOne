package com.example.twoinone

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row_guess_game.view.*

class GuessGameRVAdapter(val context: Context, val messages: ArrayList<String>): RecyclerView.Adapter<GuessGameRVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row_guess_game,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = messages[position]

        holder.itemView.apply {
            tvGuessGame.text = item
            if(item.startsWith("Found")){
                tvGuessGame.setTextColor(Color.GREEN)
            }else if(item.startsWith("No")||item.startsWith("Wrong")){
                tvGuessGame.setTextColor(Color.RED)
            }else{
                tvGuessGame.setTextColor(Color.BLACK)
            }
        }
    }

    override fun getItemCount() = messages.size
}