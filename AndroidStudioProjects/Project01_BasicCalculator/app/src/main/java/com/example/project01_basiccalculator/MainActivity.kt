package com.example.project01_basiccalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtTextA =  findViewById<EditText>(R.id.edtTextA);
        val edtTextB = findViewById<EditText>(R.id.edtTextB);
        val edtTextKQ = findViewById<EditText>(R.id.edtKQ);
        val btnReset = findViewById<Button>(R.id.btnReset);
        val btnCong = findViewById<Button>(R.id.btnCong);
        val btnNhan = findViewById<Button>(R.id.btnNhan);
        val btnChia = findViewById<Button>(R.id.btnChia);
        val btnGiuLau = findViewById<Button>(R.id.btnGiuLau);
        val btnFinish = findViewById<Button>(R.id.btnFinish);

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

        //chia sẻ biến để dùng chung
        var share: View.OnClickListener? =null;
        share = View.OnClickListener {
            if(it == btnNhan){
                val A = edtTextA.text.toString().toInt();
                val B = edtTextB.text.toString().toInt();
                val kq = A*B;
                edtTextKQ.setText(kq.toString());
            }
            else if(it == btnChia){
                val A = edtTextA.text.toString().toDouble();
                val B = edtTextB.text.toString().toDouble();
                val kq = A/B;
                edtTextKQ.setText(kq.toString());

            }
        }
        btnNhan.setOnClickListener(share);
        btnChia.setOnClickListener(share);

        var NhanLau: View.OnLongClickListener? =null;
        NhanLau = View.OnLongClickListener {
            if(it == btnGiuLau){
                Toast.makeText(this, "Lêu lêu có gì đâu đồ ngốc :-)", Toast.LENGTH_LONG).show();
                btnGiuLau.visibility = View.GONE;
            }
            true
        }
        btnGiuLau.setOnLongClickListener(NhanLau);

        btnFinish.setOnClickListener{
            Toast.makeText(this,"Thiên Quân cảm ơn bạn vì đã sử dụng phần mềm",Toast.LENGTH_LONG).show();
            finish();
        }
    }
}