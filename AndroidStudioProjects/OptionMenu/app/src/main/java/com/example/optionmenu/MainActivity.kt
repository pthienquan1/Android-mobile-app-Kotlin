package com.example.optionmenu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.optionmenu.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.menu2,menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuExit -> finish()
            R.id.menuHome -> Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
            R.id.menuSearch -> Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}