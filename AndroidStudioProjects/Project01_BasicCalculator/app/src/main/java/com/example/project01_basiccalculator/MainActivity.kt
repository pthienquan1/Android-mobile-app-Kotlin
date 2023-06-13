package com.example.project01_basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtTextA =  findViewById<EditText>(R.id.edtTextA);
        val edtTextB = findViewById<EditText>(R.id.edtTextB);
        val edtTextKQ = findViewById<EditText>(R.id.edtKQ);
        val btnReset = findViewById<Button>(R.id.btnReset);
        val btnCong = findViewById<Button>(R.id.btnCong);

        btnCong.setOnClickListener{
            val A = edtTextA.text.toString().toInt();
            val B = edtTextB.text.toString().toInt();
            val kq = A+B;
            edtTextKQ.setText(kq.toString());

        }

        btnReset.setOnClickListener{
            edtTextA.setText("");
            edtTextB.setText("");
            edtTextKQ.setText("");
            Toast.makeText(this,"BẠN ĐÃ RESET TẤT CẢ !",Toast.LENGTH_LONG).show();
        }
    }
}