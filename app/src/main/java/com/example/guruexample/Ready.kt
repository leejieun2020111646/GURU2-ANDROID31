package com.example.guruexample

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Ready : AppCompatActivity() {

    lateinit var ck1: CheckBox
    lateinit var ck2: CheckBox
    lateinit var ck3: CheckBox
    lateinit var ck4: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)

        var ck1 = findViewById<CheckBox>(R.id.checkBox1)
        var ck2 = findViewById<CheckBox>(R.id.checkBox2)
        var ck3 = findViewById<CheckBox>(R.id.checkBox3)
        var ck4 = findViewById<CheckBox>(R.id.checkBox4)

        /*
        if (ck1.isChecked && ck2.isChecked && ck3.isChecked && ck4.isChecked) {
            //모두 체크 시 메인화면으로 이동
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
        }*/
    ck1.setOnCheckedChangeListener { _, isChecked ->
        if (isChecked) {
            ck2.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    ck3.setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked) {
                            ck4.setOnCheckedChangeListener { _, isChecked ->
                                if (isChecked){
                                    val intent = Intent(this,MainActivity::class.java)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    }
}