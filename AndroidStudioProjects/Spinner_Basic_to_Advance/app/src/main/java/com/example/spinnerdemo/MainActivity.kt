package com.example.spinnerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinnerdemo.databinding.ActivityMainBinding
import java.util.Objects

private lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
        setUpSpinnerBasic();
        setUpCustomSpinner();

    }

    private fun setUpCustomSpinner() {
        var listTraiCay = mutableListOf<OurData>()
        listTraiCay.add(OurData(R.drawable.cam,"Cam tươi"));
        listTraiCay.add(OurData(R.drawable.duahau, "Dưa hấu"))
        listTraiCay.add(OurData(R.drawable.tao,"Táo đỏ"))
        listTraiCay.add(OurData(R.drawable.sauchung,"Sâu riêng không vỏ"))
        listTraiCay.add(OurData(R.drawable.xoai,"Xoài tươi không hạt"))

        val custom_Spinner = CustomSpinner(this,listTraiCay)
        binding.customSpinner.adapter = custom_Spinner;

        binding.customSpinner.onItemSelectedListener  = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,"Bạn chọn "+listTraiCay[position].title, Toast.LENGTH_SHORT).show();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    private fun setUpSpinnerBasic() {
//        val list = resources.getStringArray(R.array.ngonngu)
        val list = mutableListOf<String>()
        list.add("English")
        list.add("TBN")
        list.add("BĐN")
        list.add("VN")
        list.add("Irag")
        list.add("Iran")


        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        binding.spinNgonNgu.adapter = adapter;

        //event
        binding.spinNgonNgu.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,"Bạn chọn "+list[position],Toast.LENGTH_SHORT).show();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}