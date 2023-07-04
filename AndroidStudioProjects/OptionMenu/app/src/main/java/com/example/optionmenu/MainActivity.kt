package com.example.optionmenu

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
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

        registerForContextMenu(binding.txtContext)

    }

    //Phần này là Option Menu sử dụng xml
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//       menuInflater.inflate(R.menu.menu2,menu);
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.menuExit -> finish()
//            R.id.menuHome -> Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
//            R.id.menuSearch -> Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show()
//        }
//        return super.onOptionsItemSelected(item)
//    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1,1,1,"Red")
        menu?.add(1,2,2,"Green")
        menu?.add(1,3,3,"Black")

        var subMenu = menu?.addSubMenu("Giới tính")
        subMenu?.add(2,11,1,"Nam")
        subMenu?.add(2,12,2,"Nu")
        subMenu?.setGroupCheckable(2,true,true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{
                binding.txtOption.setTextColor(Color.RED)}
            2->{
                binding.txtOption.setTextColor(Color.GREEN)}

            3->{
                binding.txtOption.setTextColor(Color.BLACK)}
            11->{
                binding.txtOption.setText("Nam")
            }
            12->{
                binding.txtOption.setText("Nữ")}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(3,31,1,"RED")
        menu?.add(3,32,2,"GREEN")
        menu?.add(3,33,3,"BLACK")
        menu?.setHeaderTitle("Mời cụ chọn mầu")


    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            31->{ binding.txtContext.setTextColor(Color.RED)}
            32->{ binding.txtContext.setTextColor(Color.GREEN)}
            33->{ binding.txtContext.setTextColor(Color.BLACK)}
        }
        return super.onContextItemSelected(item)
    }
}