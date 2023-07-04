package com.example.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context:Context):SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL("CREATE TABLE USERS(UserID Integer primary key autoincrement, Username text, Pass text)");
            db?.execSQL("INSERT INTO USERS(Username,Pass) VALUES ('han@gmail.com','123456')")
            db?.execSQL("INSERT INTO USERS(Username,Pass) VALUES ('pthienquan1@gmail.com','123456')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}