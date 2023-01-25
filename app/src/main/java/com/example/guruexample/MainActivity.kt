package com.example.guruexample


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_adopt_recycler.*


class MainActivity : AppCompatActivity() {
    lateinit var adoptAdapter: AdoptAdapter
    val datas = mutableListOf<AdoptData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TestLog", "MainActivity")
        btn_login.setOnClickListener(ButtonListener())
        btn_adoptlist.setOnClickListener(ButtonListener())

    }
    inner class ButtonListener: View.OnClickListener {
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

}