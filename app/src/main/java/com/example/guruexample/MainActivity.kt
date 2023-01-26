package com.example.guruexample


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_adopt_recycler.*



class MainActivity : AppCompatActivity() {

    lateinit var adoptAdapter: AdoptAdapter
    val datas = mutableListOf<AdoptData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        inner class ButtonListener : View.OnClickListener {
            override fun onClick(v: View?) {
                var intent = Intent()

                when (v?.id) {
                    R.id.btn_login -> {
                        Log.d("TestLog", "LoginBtn")
                        intent = Intent(this@MainActivity, AdoptMain::class.java)
                    }
                    R.id.btn_adoptlist -> {
                        Log.d("TestLog", "AdoptlistBtn")
                        intent = Intent(this@MainActivity, AdoptMain::class.java)
                    }
                }
                startActivity(intent)
            }
        }
        /*버튼 클릭 화면 전환 참고 코드
        val intent = Intent(this, [도착 페이지]::class.java)
        val [버튼변수명] = findViewById<Button>(R.id.[해당버튼id])
        buttonView.setOnClickListener {
            startActivity(intent)
        }
        */
    }
}