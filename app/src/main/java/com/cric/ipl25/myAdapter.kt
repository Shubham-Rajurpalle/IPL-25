package com.cric.ipl25

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.crick.ipl25.R


class myAdapter(val context: Context,private val dataArray: List<info_team>) :
    RecyclerView.Adapter<myAdapter.myViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val view: View=
            LayoutInflater.from(parent.context).inflate(R.layout.single_item_button, parent, false)
        return myViewHolder(view)

    }


    override fun getItemCount(): Int {
        return dataArray.size

    }


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val currentItem = dataArray[position]
        holder.imageView.setImageResource(currentItem.imageTeam)

    }

    inner class myViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.teamLogo)

        init {
            itemView.setOnClickListener {

                var position=adapterPosition

                var  i=Intent(context,recycler_team_activity::class.java)
                val csk="https://www.iplt20.com/teams/chennai-super-kings"
                val rcb="https://www.iplt20.com/teams/royal-challengers-bangalore"
                val mi="https://www.iplt20.com/teams/mumbai-indians"
                val gt="https://www.iplt20.com/teams/gujarat-titans"
                val kkr="https://www.iplt20.com/teams/kolkata-knight-riders"
                val rr="https://www.iplt20.com/teams/rajasthan-royals"
                val pk="https://www.iplt20.com/teams/punjab-kings"
                val dc="https://www.iplt20.com/teams/delhi-capitals"
                val lsg="https://www.iplt20.com/teams/lucknow-super-giants"
                val sh="https://www.iplt20.com/teams/sunrisers-hyderabad"

                when (position) {

                   0 -> {
                        i.putExtra("key",csk)
                        }

                   1 -> {
                       i.putExtra("key", rcb)
                   }

                    2->{
                        i.putExtra("key",mi)
                    }

                    3->{
                        i.putExtra("key",gt)
                    }

                    4->{
                        i.putExtra("key",kkr)
                    }

                    5->{
                        i.putExtra("key",rr)
                    }

                    6->{
                        i.putExtra("key",pk)
                    }

                    7->{
                        i.putExtra("key",dc)
                    }

                    8->{
                        i.putExtra("key",lsg)
                    }

                    9->{
                        i.putExtra("key",sh)
                    }

                }
                context.startActivity(i)

            }
        }

    }
}

