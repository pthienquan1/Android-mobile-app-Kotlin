package com.example.project01_basiccalculator

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.project01_basiccalculator.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var eptLst:MutableList<String> = mutableListOf("01231043104","123134141");
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

//        var colorChang = Color.parseColor("#99FFFF")
//        binding.lvQuocGia.setBackgroundColor(colorChang);


        //khai bao list rong

        binding.lvQuocGia.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,eptLst)
        addEvents();


    }

    private fun addEvents() {
//        HienThiQuocGia();
        binding.btnSave.setOnClickListener {
            XuLySaveSDT();
        }
    }

    private fun XuLySaveSDT() {
        var s:String = binding.edtInput.text.toString();
        eptLst.add(s);
        binding.lvQuocGia.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,eptLst)
        binding.edtInput.setText("")
    }
//
//    private fun HienThiQuocGia() {
//        var arrQuocGia = resources.getStringArray(R.array.arrQuocGia1)
//        binding.lvQuocGia.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,arrQuocGia)
//
//        binding.lvQuocGia.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this,"Ban chon quoc gia "+ arrQuocGia[position],Toast.LENGTH_SHORT).show()
//        }
//    }


    //bài về ảnh img view
//    private fun addEvents(){
//        binding.radPic1.setOnCheckedChangeListener { buttonView, isChecked ->
//            if(isChecked){
//                binding.imgPic.setImageResource(R.drawable.pic1);
//            }
//        }
//
//        binding.radPic2.setOnCheckedChangeListener { buttonView, isChecked ->
//            if(isChecked){
//                binding.imgPic.setImageResource(R.drawable.pic2);
//            }
//        }
//        binding.imgExit.setOnClickListener {
//            finish()
//        }
//
//    }

}