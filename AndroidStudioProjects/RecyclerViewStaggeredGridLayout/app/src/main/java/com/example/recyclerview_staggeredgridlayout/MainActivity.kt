package com.example.recyclerview_staggeredgridlayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerview_staggeredgridlayout.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        XuLy()
    }
    fun XuLy(){
        val ds = mutableListOf<Int>()
        ds.add(R.drawable.tuhoc1)
        ds.add(R.drawable.tuhoc2)
        ds.add(R.drawable.tuhoc3)
        ds.add(R.drawable.tuhoc4)
        ds.add(R.drawable.tuhoc5)
        ds.add(R.drawable.tuhoc6)

        binding.rcvView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val itemAdt = RcvAdapter(ds)
        binding.rcvView.adapter = itemAdt

    }
}