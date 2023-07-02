package com.example.tablayout_viewpager2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablayout_viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val adaptervv = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.pagerTest.adapter = adaptervv
        TabLayoutMediator(binding.tabDemo, binding.pagerTest){tab,pos->
            when(pos){
                0->{tab.text="Tab 1"}
                1->{tab.text="Tab 2"}
                2->{tab.text="Tab 3"}
                3->{tab.text="Tab 4"}
                4->{tab.text="Tab 5"}
            }
        }.attach()

    }
}