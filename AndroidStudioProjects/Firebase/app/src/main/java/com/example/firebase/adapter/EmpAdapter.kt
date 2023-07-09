package com.example.firebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.EmployeeModel
import com.example.firebase.R

class EmpAdapter(private val ds:ArrayList<EmployeeModel>):RecyclerView.Adapter<EmpAdapter.viewHolder>() {
  //viewholeder
    class viewHolder(itemView:View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.emp_list_item,parent,false);
        return viewHolder(itemView);
    }

    override fun getItemCount(): Int {
        return ds.size;
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.itemView.apply {
            val txtEmpName1 = findViewById<TextView>(R.id.txtEmpName1);
            txtEmpName1.text = ds[position].empName;
        }
    }
}