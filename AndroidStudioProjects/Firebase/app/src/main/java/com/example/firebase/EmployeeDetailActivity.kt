package com.example.firebase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase.databinding.ActivityEmployeeDetailBinding
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

@SuppressLint("StaticFieldLeak")
private lateinit var binding:ActivityEmployeeDetailBinding
class EmployeeDetailActivity : AppCompatActivity() {
    private fun deleteRecord(id: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Employees").child(id)
        val mTask = dbRef.removeValue()
        mTask.addOnSuccessListener {
            Toast.makeText(this,"Employee data removed !",Toast.LENGTH_SHORT).show();
            val intent = Intent(this,FetchingActivity::class.java);
            finish()
            startActivity(intent);
        }.addOnFailureListener{ err ->
            Toast.makeText(this,"Delete error , ${err.message}!",Toast.LENGTH_SHORT).show();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_detail)

        //khởi tạo view binding
        binding = ActivityEmployeeDetailBinding.inflate(layoutInflater);
        setContentView(binding.root);

        setValueToView()

        binding.btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("empId").toString()
            )
        }
    }

    private fun setValueToView() {
       binding.txtEmpid1.text = intent.getStringExtra("empId");
       binding.txtEmpname1.text = intent.getStringExtra("empName");
       binding.txtEmpage1.text = intent.getStringExtra("empAge");
       binding.Empsalary1.text = intent.getStringExtra("empSalary");
    }

}