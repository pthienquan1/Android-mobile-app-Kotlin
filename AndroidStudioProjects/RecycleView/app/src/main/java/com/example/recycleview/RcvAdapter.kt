package com.example.recycleview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.databinding.LayoutItemBinding


class RcvAdapter(private var ds: List<OurData>) : RecyclerView.Adapter<RcvAdapter.PhimViewHolder>() {
    private lateinit var binding: LayoutItemBinding

    inner class PhimViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhimViewHolder {
        binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhimViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhimViewHolder, position: Int) {
        val item = ds[position]
        holder.itemView.apply {
            holder.binding.txtDesMovie.text = item.des;
            holder.binding.txtNameMovie.text =item.title;
            holder.binding.imgMovie.setImageResource(item.image)
        }

    }

    override fun getItemCount(): Int {
        return ds.size
    }
}