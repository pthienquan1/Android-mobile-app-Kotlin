package com.example.firebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.EmployeeModel
import com.example.firebase.R

class EmpAdapter(private val ds:ArrayList<EmployeeModel>):RecyclerView.Adapter<EmpAdapter.viewHolder>() {
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener;
    }
  //viewholeder
    class viewHolder(itemView:View, clickListener: onItemClickListener) :RecyclerView.ViewHolder(itemView){
        init{
            itemView.setOnClickListener{
                clickListener.onItemClick(adapterPosition);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.emp_list_item,parent,false);
        return viewHolder(itemView,mListener );
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