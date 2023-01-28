package com.example.guruexample

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import android.widget.*
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.MenuItem
import android.view.View

class MypageActivity : AppCompatActivity() {

    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        fun write(){ //마이페이지 데이터 출력
            dbManager = DBManager(this, "USERTABLE", null, 1)
            sqlitedb = dbManager.readableDatabase

            var cursor: Cursor
            //ㅁcursor = sqlitedb.rawQuery("SELECT * FROM USERTABLE WHERE id = '"+ck_id+"';",null)

        }






    }
}