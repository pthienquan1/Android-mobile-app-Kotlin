package com.example.crud_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyHelper(context:Context):SQLiteOpenHelper(context,"test",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table account(_id integer primary key autoincrement, user text, password text)");
        db?.execSQL(("insert into account(user,password) values ('test01','test01@gmail.com')"));
        db?.execSQL(("insert into account(user,password) values ('test02','test02@gmail.com')"));
        db?.execSQL(("insert into account(user,password) values ('test03','test03@gmail.com')"));
        db?.execSQL(("insert into account(user,password) values ('test04','test04@gmail.com')"));
        db?.execSQL(("insert into account(user,password) values ('test05','test05@gmail.com')"));

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}