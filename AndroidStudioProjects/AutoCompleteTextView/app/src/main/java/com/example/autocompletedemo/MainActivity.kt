package com.example.autocompletedemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.autocompletedemo.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val list = resources.getStringArray(R.array.tp)
        val adt = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        binding.autoTp.setAdapter(adt);

        binding.autoTp.setOnFocusChangeListener(View.OnFocusChangeListener{view,b -> if(b) {
            binding.autoTp.showDropDown()} })


        binding.autoTp.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"Bạn chọn "+ binding.autoTp.text.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}