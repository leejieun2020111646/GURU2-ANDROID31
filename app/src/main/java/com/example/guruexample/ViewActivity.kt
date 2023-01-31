package com.example.guruexample

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ViewActivity : AppCompatActivity() {

    lateinit var BT1 : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity)

        BT1 = findViewById(R.id.dog1)
        BT1.setOnClickListener {
            val intent = Intent(this, AdoptDetailActivity::class.java)
            startActivity(intent)
        }
    }
}