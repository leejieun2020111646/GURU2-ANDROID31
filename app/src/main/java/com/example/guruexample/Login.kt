package com.example.guruexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register1.*

class Login : AppCompatActivity() {

    lateinit var Btn_Register: Button //회원가입 버튼 변수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Btn_Register = findViewById<Button>(R.id.btn_register)

        //회원가입 버튼 클릭 시 페이지 이동(Register로 이동)
        Btn_Register.setOnClickListener{
            startActivity((Intent(this@Login,Register::class.java)))
        }







    }
}


