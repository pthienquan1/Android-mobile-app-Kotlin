package com.example.project02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project02.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        addEvents();

    }



    private fun addEvents(){
        binding.button2.setOnClickListener {
            XuLyClickVaoSoThich()

        }

        binding.btnXacNhan.setOnClickListener {
            XuLyXacNhan()
        }
    }

    private fun XuLyXacNhan() {
        var s:String = "";
        if(binding.radioButton.isChecked){
            s+= binding.radioButton.text.toString();
        }
        else if(binding.radioButton2.isChecked){
            s+= binding.radioButton2.text.toString();
        }
        if(s==""){
            Toast.makeText(this,"Bạn chưa chọn giới tính",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Bạn chọn giới tính là: "+ s, Toast.LENGTH_LONG).show();
        }
    }

    private fun XuLyClickVaoSoThich() {
        var s:String ="";
        if(binding.checkAn.isChecked){
            s+= binding.checkAn.text.toString() +", ";
        }
        if(binding.checkBun.isChecked){
            s+= binding.checkBun.text.toString() +", ";
        }
        if(binding.checkBong.isChecked){
            s+= binding.checkBong.text.toString() +", ";
        }
        if(binding.checkChoi.isChecked){
            s+= binding.checkChoi.text.toString() +", ";
        }
        if(binding.checkPhim.isChecked){
            s+= binding.checkPhim.text.toString() +", ";
        }
        binding.edtSoThich.setText(s);
    }
}