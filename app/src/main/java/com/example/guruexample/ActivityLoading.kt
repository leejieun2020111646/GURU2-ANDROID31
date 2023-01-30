package com.example.guruexample

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class ActivityLoading : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        startLoading()

        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
    private fun startLoading(){
        val handler = Handler()
        handler.postDelayed({ finish() }, 2000)
    }
}