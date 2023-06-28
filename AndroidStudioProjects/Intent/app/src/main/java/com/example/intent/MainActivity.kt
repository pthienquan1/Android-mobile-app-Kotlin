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
//            i.putExtra("BienString","Chào mừng bạn đến với Quân Blog")
//            i.putExtra("BienDouble",12131.41414)
//            i.putExtra("BienBoolean",true);
            val bundle = Bundle();
            bundle.putString("BienString","Hello mn");
            bundle.putInt("BienInt",28)
            i.putExtras(bundle)
            startActivity(i)
        }

        binding.btnLink.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"))
            startActivity(i2);
        }

    }
}