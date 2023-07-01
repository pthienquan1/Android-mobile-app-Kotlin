package com.example.fragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);



        val sub1 = fragment_1()
        val sub2 = fragment_2()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl1,sub1)
            commit()
        }

        binding.btnFrag1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1,sub1)
                commit()
            }
        }
        binding.btnFrag2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1,sub2)
                commit()
            }
        }
    }
}