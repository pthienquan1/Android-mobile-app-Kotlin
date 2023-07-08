package com.example.crud_sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AlertDialog
import com.example.crud_sqlite.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var db:SQLiteDatabase
    lateinit var rs:Cursor
    lateinit var adapter:SimpleCursorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        var helper = MyHelper(applicationContext);
        db = helper.readableDatabase
        rs = db.rawQuery("select*from account limit 20",null);

        binding.btnFirst.setOnClickListener {
            if(rs.moveToFirst()){
                binding.edtUsername.setText(rs.getString(1));
                binding.edtEmail.setText(rs.getString(2));
            }
        }
        binding.btnNext.setOnClickListener {
            if(rs.moveToNext()){
                binding.edtUsername.setText(rs.getString(1));
                binding.edtEmail.setText(rs.getString(2));
            }
        }
        binding.btnPrev.setOnClickListener {
            if(rs.moveToPrevious()){
                binding.edtUsername.setText(rs.getString(1));
                binding.edtEmail.setText(rs.getString(2));
            }
        }
        binding.btnLast.setOnClickListener {
            if(rs.moveToLast()){
                binding.edtUsername.setText(rs.getString(1));
                binding.edtEmail.setText(rs.getString(2));
            }
        }

        //code View list
        adapter = SimpleCursorAdapter(
            applicationContext,android.R.layout.simple_expandable_list_item_2,rs, arrayOf("user","password"),
            intArrayOf(android.R.id.text1,android.R.id.text2),0
        )
        binding.lvFull.adapter = adapter;
         //code btn Viewl ALl
        binding.btnViewAll.setOnClickListener {
            binding.searchView.visibility = View.VISIBLE;
            binding.lvFull.visibility = View.VISIBLE;
            adapter.notifyDataSetChanged()
            binding.searchView.queryHint = "Tìm kiếm trong ${rs.count} bản ghi";
        }

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               rs = db.rawQuery("select * from account where user like '%${newText}' or password like '%${newText}' ",null);
                adapter.changeCursor(rs);
                return true;
            }

        })

        //insert
        binding.btnInsert.setOnClickListener {
            var cv = ContentValues();
            cv.put("user", binding.edtUsername.text.toString());
            cv.put("password", binding.edtEmail.text.toString());
            db.insert("account",null,cv);
            rs.requery();
            adapter.notifyDataSetChanged();

            var ad = AlertDialog.Builder(this);
            ad.setTitle("Thêm tài khoản")
            ad.setMessage("Thêm tài khoản thành công")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                binding.edtUsername.setText("");
                binding.edtEmail.setText("");
                binding.edtUsername.requestFocus();
            })
            ad.show();
        }

        //update
        binding.btnUpdate.setOnClickListener {
            var cv = ContentValues();
            cv.put("user", binding.edtUsername.text.toString());
            cv.put("password", binding.edtEmail.text.toString());
           db.update("account",cv,"_id=?", arrayOf(rs.getString(0)));
            rs.requery();
            adapter.notifyDataSetChanged();

            var ad = AlertDialog.Builder(this);
            ad.setTitle("Cập nhật tài khoản")
            ad.setMessage("Cập nhật tài khoản thành công")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                binding.edtUsername.setText("");
                binding.edtEmail.setText("");
                binding.edtUsername.requestFocus();
            })
            ad.show();
        }
        // delete
        binding.btnDelete.setOnClickListener {
            db.delete("account","_id=?", arrayOf(rs.getString(0)))
            rs.requery();
            adapter.notifyDataSetChanged();

            var ad = AlertDialog.Builder(this);
            ad.setTitle("Xóa tài khoản")
            ad.setMessage("Xóa tài khoản thành công")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                if(rs.moveToFirst()){
                    binding.edtUsername.setText("");
                    binding.edtEmail.setText("");
                    binding.edtUsername.requestFocus();
                }else{
                    binding.edtUsername.setText("No data found");
                    binding.edtEmail.setText("No data found");
                }
            })
            ad.show();

        }

        //clear
        binding.btnClear.setOnClickListener {
            binding.edtUsername.setText("")
            binding.edtEmail.setText("")
            binding.edtUsername.requestFocus()
        }

    }
}