package com.example.spinnerdemo

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomSpinner(val activity: Activity, val lst:List<OurData>) : ArrayAdapter<OurData>(activity,R.layout.list_traicay) {
    override fun getCount(): Int {
        return lst.size;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent);
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent);
    }
    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View{
        val contexs =  activity.layoutInflater;
        val rowView = contexs.inflate(R.layout.list_traicay,parent,false);

        val imageViews = rowView.findViewById<ImageView>(R.id.imgView)
        val title = rowView.findViewById<TextView>(R.id.title);

        imageViews.setImageResource(lst[position].img);
        title.text=lst[position].title;
        return rowView;
    }
}