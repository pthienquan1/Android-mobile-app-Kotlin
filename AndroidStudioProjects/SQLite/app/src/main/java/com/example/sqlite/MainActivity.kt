package com.example.sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlite.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);


        val helper = MyDBHelper(applicationContext);
        val db = helper.readableDatabase;
        var rs = db.rawQuery("select*from USERS",null);
        if(rs.moveToFirst()){
            Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_SHORT).show()
        }

        binding.btnADD.setOnClickListener {
            var cv = ContentValues()
            cv.put("Username", binding.edtUser.text.toString())
            cv.put("Pass", binding.edtPass.text.toString())
            db.insert("USERS",null,cv);
            Toast.makeText(applicationContext,"Thêm thành công",Toast.LENGTH_SHORT).show()
            binding.edtUser.setText("")
            binding.edtPass.setText("")
            binding.edtUser.requestFocus()

        }

    }
}