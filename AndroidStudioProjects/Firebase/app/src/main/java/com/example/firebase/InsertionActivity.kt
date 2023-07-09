package com.example.firebase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase.databinding.ActivityInsertionBinding
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

@SuppressLint("StaticFieldLeak")
private lateinit var binding1: ActivityInsertionBinding

class InsertionActivity : AppCompatActivity() {
    private lateinit var dbRef:DatabaseReference;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)

        //khởi tạo view binding
        binding1 = ActivityInsertionBinding.inflate(layoutInflater);
        setContentView(binding1.root);

        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        binding1.btnSave.setOnClickListener {
            saveEmployeeData();
        }
    }

    private fun saveEmployeeData() {
        //get data from user input
        val empName = binding1.edtName.text.toString();
        val  empAge = binding1.edtAge.text.toString();
        val empSalary = binding1.edtSalary.text.toString();

        //get data into db
        val empId = dbRef.push().key!!;

        val employee = EmployeeModel(empId,empName,empAge,empSalary)

        if(empName.isEmpty()){
            binding1.edtName.error = "pls enter name";
            return;
        }
        if(empAge.isEmpty()){
            binding1.edtAge.error = "pls enter age";
            return;
        }

        if(empSalary.isEmpty()){
            binding1.edtSalary.error = "pls enter salary";
            return;
        }


        dbRef.child(empId).setValue(employee).addOnCompleteListener{
            Toast.makeText(this,"Data insert successfully !",Toast.LENGTH_SHORT).show()
            binding1.edtName.setText("");
            binding1.edtAge.setText("");
            binding1.edtSalary.setText("");
        }
            .addOnFailureListener{ err ->
                Toast.makeText(this,"Error when inserting to db because : ${err}",Toast.LENGTH_SHORT).show()
            }
    }
}