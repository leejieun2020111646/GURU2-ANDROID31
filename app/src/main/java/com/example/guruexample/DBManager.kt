package com.example.guruexample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    //1. onCreate
    override fun onCreate(db: SQLiteDatabase?) {
        //테이블명 USERTABLE
        db!!.execSQL("CREATE TABLE USERTABLE (id text, pw text, name text, tel text, email text, gender text)")
    } //우선 id, pw, 이름, 성별, 전화번호, 이메일
    //2. onUpgrade
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}