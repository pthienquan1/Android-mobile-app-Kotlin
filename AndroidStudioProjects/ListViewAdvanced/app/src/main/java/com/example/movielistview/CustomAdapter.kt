package com.example.movielistview

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val activity:Activity, val list: List<OurData> ):ArrayAdapter<OurData>(activity,R.layout.list_item) {
    override fun getCount(): Int {
        return list.size;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //chuyen doi tu layout xml sang view
        val layoutToView = activity.layoutInflater;
        val rowView = layoutToView.inflate(R.layout.list_item,parent,false);
        val image = rowView.findViewById<ImageView>(R.id.img)
        val title = rowView.findViewById<TextView>(R.id.txtTitle)
        val des = rowView.findViewById<TextView>(R.id.txtDes)

        title.text = list[position].title
        des.text = list[position].des
        image.setImageResource(list[position].image)
        return rowView;
    }
}