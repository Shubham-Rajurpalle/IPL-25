package com.cric.ipl25

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.crick.ipl25.R

class myWinnerAdapter(val context: Context,
                      val listWinner:List<winner_data_item>):
    RecyclerView.Adapter<myWinnerAdapter.myHolder>() {


        inner class myHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val yearText:TextView=itemView.findViewById(R.id.yearText)
            val teamName:TextView=itemView.findViewById(R.id.teamName)
            val winnerImage:ImageView=itemView.findViewById(R.id.winnerImage)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
       val view:View=LayoutInflater.from(context).
       inflate(R.layout.single_item_winners,parent,false)

        return myHolder(view)
    }


    override fun getItemCount(): Int {
       return listWinner.size
    }


    override fun onBindViewHolder(holder: myHolder, position: Int) {

        val currentItem=listWinner[position]

            holder.teamName.text=currentItem.teamName
        holder.yearText.text=currentItem.yearText
        holder.winnerImage.setImageResource(currentItem.winnerImage)
    }
}

