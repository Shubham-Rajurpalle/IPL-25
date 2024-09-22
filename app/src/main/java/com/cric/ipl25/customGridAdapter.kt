package com.cric.ipl25

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.crick.ipl25.R

class customGridAdapter(context: Context, private val arrayList: List<button_info>) :
    ArrayAdapter<button_info>(context, R.layout.single_button_icon, arrayList) {



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: viewHolder
        var itemView = convertView
        if (convertView == null) {
            itemView = LayoutInflater.from(context)
                .inflate(R.layout.single_button_icon, parent, false)

            viewHolder = viewHolder()
            viewHolder.textView = itemView.findViewById(R.id.buttonText)
            viewHolder.imageView = itemView.findViewById(R.id.buttonLogo)
            viewHolder.imageView.clipToOutline=true

            itemView.tag = viewHolder
        } else {
            viewHolder = itemView?.tag as viewHolder
        }

        val currentItem = arrayList[position]
        viewHolder.textView.text = currentItem.textButton
        viewHolder.imageView.setImageResource(currentItem.imageButton)

        return itemView!!
    }

    private class viewHolder {
        lateinit var textView: TextView
        lateinit var imageView: ImageView
    }


}
