package com.example.guruexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register1.*

class Login : AppCompatActivity() {

    //회원가입 버튼 변수
    //lateinit var BtnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        /*BtnRegister = findViewById<Button>(R.id.btn_register)

        Btn_Register.setOnClickListener{
            startActivity((Intent(this@Login,Register::class.java)))
        }*/

        //회원가입 버튼 클릭 시 페이지 이동(Register로 이동)
        val BtnRegister = findViewById<Button>(R.id.btn_register)
        BtnRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }








    }
}


