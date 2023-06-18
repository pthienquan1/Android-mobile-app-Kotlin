package com.example.movielistview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.movielistview.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var customAdapter: CustomAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        // khai bao cac item trong list
        var list = mutableListOf<OurData>()
        list.add(OurData(R.drawable.banghoa,"Băng Hỏa Ma trù 2022","Một bộ phim nói về băng và hỏa"));
        list.add(
            OurData(R.drawable.giatocrong,"Gia Tộc Rồng 2023","Một bộ phim nói về gia tộc loài rồng qua bao nhiêu" +
                "năm đấu tranh giải phóng dân tộc")
        );
        list.add(OurData(R.drawable.hoanhon,"Hoàn Hồn 2022","Một bộ phim kể về hồn ma được hoàn hồn"));
        list.add(OurData(R.drawable.thanlan,"Thần Lan Vô Song 2020","Một bộ phim xoay quanh câu chuyện về một vị thần"));
        list.add(OurData(R.drawable.banghoa,"Băng Hỏa Ma trù 2022","Một bộ phim nói về băng và hỏa"));
        list.add(
            OurData(R.drawable.giatocrong,"Gia Tộc Rồng 2023","Một bộ phim nói về gia tộc loài rồng qua bao nhiêu" +
                    "năm đấu tranh giải phóng dân tộc")
        );
        list.add(OurData(R.drawable.hoanhon,"Hoàn Hồn 2022","Một bộ phim kể về hồn ma được hoàn hồn"));
        list.add(OurData(R.drawable.thanlan,"Thần Lan Vô Song 2020","Một bộ phim xoay quanh câu chuyện về một vị thần"));

        customAdapter = CustomAdapter(this,list);

        val lstMovie = findViewById<ListView>(R.id.listViewMain);
        lstMovie.adapter = customAdapter

        lstMovie.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"Bạn đã chọn phim "+list[position].title, Toast.LENGTH_SHORT).show();
        }
    }
}