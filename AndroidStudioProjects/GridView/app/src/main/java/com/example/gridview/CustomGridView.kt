package com.example.gridview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomGridView(val activity: Activity, val lst: List<OurDataa>): ArrayAdapter<OurDataa>(activity,R.layout.layout_items) {
    override fun getCount(): Int {
        return lst.size;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val contexs = activity.layoutInflater;
        val rowView = contexs.inflate(R.layout.layout_items,parent,false)

        val img = rowView.findViewById<ImageView>(R.id.imgMovie)
        val title  = rowView.findViewById<TextView>(R.id.textNameMovie)
        img.setImageResource(lst[position].img)
        title.text = lst[position].title
        return rowView;
    }
}