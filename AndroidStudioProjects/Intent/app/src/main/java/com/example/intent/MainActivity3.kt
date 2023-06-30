package com.example.intent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMain2Binding
import com.example.intent.databinding.ActivityMain3Binding

@SuppressLint("StaticFieldLeak")
private lateinit var binding3: ActivityMain3Binding
class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //khởi tạo view binding
        binding3 = ActivityMain3Binding.inflate(layoutInflater);
        setContentView(binding3.root);


    }
}