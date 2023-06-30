package com.example.recycleview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val ds = mutableListOf<OurData>()
        ds.add(OurData(R.drawable.banghoa,"Băng Hỏa Ma trù","Phim Trung Quốc 2022"));
        ds.add(OurData(R.drawable.hoanhon,"Hoàn Hồn", "Phim Trung Quốc 2000"));
        ds.add(OurData(R.drawable.giatocrong,"Gia Tộc Rồng","Phim Phần Lan 2023"));
        ds.add(OurData(R.drawable.thanlan,"Thần Lân","Phim Thái Lan 2020"));
        ds.add(OurData(R.drawable.banghoa,"Băng Hỏa Ma trù","Phim Trung Quốc 2022"));
        ds.add(OurData(R.drawable.hoanhon,"Hoàn Hồn", "Phim Trung Quốc 2000"));
        ds.add(OurData(R.drawable.giatocrong,"Gia Tộc Rồng","Phim Phần Lan 2023"));
        ds.add(OurData(R.drawable.thanlan,"Thần Lân","Phim Thái Lan 2020"));

        val adapterDemo = RcvAdapter(ds,object:RcvInterface{
            override fun OnClickMovie(pos: Int) {
                Toast.makeText(this@MainActivity,"Bạn đã click vào ${ds[pos].title}",Toast.LENGTH_SHORT).show();
            }
        });
        binding.rcVMovie.adapter = adapterDemo
//        binding.rcVMovie.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.rcVMovie.layoutManager = GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false);
    }
}