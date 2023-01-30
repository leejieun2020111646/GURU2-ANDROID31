package com.example.guruexample

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import android.widget.*
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
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
            //cursor = sqlitedb.rawQuery("SELECT * FROM USERTABLE WHERE id = '"+ck_id+"';",null)

        }
    }
    //메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_mypage, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_main -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_login -> {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_adoptmain -> {
                val intent = Intent(this, AdoptMain::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_notice -> {
                val intent = Intent(this, AdoptNotice::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}