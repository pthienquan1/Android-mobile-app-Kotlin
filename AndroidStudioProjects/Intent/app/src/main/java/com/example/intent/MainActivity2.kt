package com.example.intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMain2Binding
import com.example.intent.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding2: ActivityMain2Binding
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //khởi tạo view binding
        binding2 = ActivityMain2Binding.inflate(layoutInflater);
        setContentView(binding2.root);

        val i2 = intent;
        val bundle = i2.extras;
        if(bundle!=null){
            val bienString = bundle?.getString("BienString")
            val bienInt = bundle?.getInt("BienInt")

            binding2.edtGetIntent.setText(bienString + "\n" + bienInt)
        }


//        val bienString = i2.getStringExtra("BienString");
//        val bienDouble = i2.getDoubleExtra("BienDouble",0.0);
//        val bienBoolean = i2.getBooleanExtra("BienBoolean",false);
//        binding2.edtGetIntent.setText(bienString+"\n"+bienDouble+"\n"+bienBoolean)


        binding2.btnBack.setOnClickListener {
            val i = Intent(this,MainActivity::class.java);
            startActivity(i)
        }

    }

}


