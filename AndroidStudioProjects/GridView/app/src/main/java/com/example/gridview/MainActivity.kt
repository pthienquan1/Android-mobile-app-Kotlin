package com.example.gridview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gridview.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        var list = mutableListOf<OurDataa>();
        list.add(OurDataa(R.drawable.banghoa,"Băng hỏa 2022"));
        list.add(OurDataa(R.drawable.giatocrong,"Gia tộc loài rồng 2021"))
        list.add(OurDataa(R.drawable.hoanhon,"Hoàn hồn mới nhất 2023"));
        list.add(OurDataa(R.drawable.thanlan,"Thần lân lân thần 2020"))
        list.add(OurDataa(R.drawable.banghoa,"Băng hỏa 2022"));
        list.add(OurDataa(R.drawable.giatocrong,"Gia tộc loài rồng 2021"))
        list.add(OurDataa(R.drawable.hoanhon,"Hoàn hồn mới nhất 2023"));
        list.add(OurDataa(R.drawable.thanlan,"Thần lân lân thần 2020"))
        list.add(OurDataa(R.drawable.banghoa,"Băng hỏa 2022"));
        list.add(OurDataa(R.drawable.giatocrong,"Gia tộc loài rồng 2021"))
        list.add(OurDataa(R.drawable.hoanhon,"Hoàn hồn mới nhất 2023"));
        list.add(OurDataa(R.drawable.thanlan,"Thần lân lân thần 2020"))


        val customGrid = CustomGridView(this,list)
        binding.gridPhim.adapter = customGrid;
    }
}