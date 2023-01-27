package com.example.guruexample


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_adopt_recycler.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
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


    /*버튼 클릭 화면 전환 참고 코드
    val intent = Intent(this, [도착 페이지]::class.java)
    val [버튼변수명] = findViewById<Button>(R.id.[해당버튼id])
    buttonView.setOnClickListener {
        startActivity(intent)
    }
    */
}

