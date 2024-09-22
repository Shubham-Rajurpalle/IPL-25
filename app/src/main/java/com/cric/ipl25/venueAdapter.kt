package com.cric.ipl25

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.crick.ipl25.R

class venueAdapter(val context: Context,val arrayList: List<venue_data>)
    :RecyclerView.Adapter<venueAdapter.myHolder>() {



        inner class myHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
            val stadiumImage:ImageView=itemView.findViewById(R.id.stadiumImage)
            val stadiumName:TextView=itemView.findViewById(R.id.stadiumName)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val view:View=LayoutInflater.from(context).inflate(R.layout.venue_item_layout,parent,false)
        return myHolder(view)
    }


    override fun getItemCount(): Int {
        return arrayList.size
    }


    override fun onBindViewHolder(holder: myHolder, position: Int) {

        val currentItem=arrayList[position]
        holder.stadiumImage.setImageResource(currentItem.stadiumImage)
        holder.stadiumName.text=currentItem.stadiumName
    }
}