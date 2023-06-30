package com.example.recyclerview_staggeredgridlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_staggeredgridlayout.databinding.LayoutItemBinding

class RcvAdapter(private val ds:List<Int>):RecyclerView.Adapter<RcvAdapter.itemViewHolder>(){
    private lateinit var binding: LayoutItemBinding
    class itemViewHolder(val binding: LayoutItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return itemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.itemView.apply {
            binding.imageView.setImageResource(ds[position])
        }
    }

    override fun getItemCount(): Int {
       return ds.size;
    }
}