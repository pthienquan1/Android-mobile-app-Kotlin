package com.example.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.btnGo.setOnClickListener {
            val i = Intent(this,MainActivity2::class.java);
            startActivity(i)
        }

        binding.btnLink.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/MeoChocoHan/"))
            startActivity(i2);
        }

    }
}