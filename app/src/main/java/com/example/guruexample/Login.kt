package com.example.guruexample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guruexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_register1.*
import com.google.firebase.firestore.auth.User as User

class Login : AppCompatActivity() {

    //뒤로가기 버튼 기능(공통코드)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //뒤로가기 버튼
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //회원가입 버튼 클릭 시 페이지 이동(Register로 이동)
        val BtnRegister = findViewById<Button>(R.id.btn_register)
        BtnRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }
}

