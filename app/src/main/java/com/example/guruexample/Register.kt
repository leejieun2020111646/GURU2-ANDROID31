package com.example.guruexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class Register : AppCompatActivity() {

    lateinit var btn_signup : Button //회원가입 버튼 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)

        btn_signup = findViewById(R.id.signupbutton) //회원가입버튼 변수 연결

        //*지역 선택 목록
        //스피너에 들어갈 데이터
        val locals = arrayOf("서울", "경기", "인천","강원","충북","충남",
            "세종","전북","전남","광주","경북","대구","경남","울산","부산","제주")
        //스피터 객체 생성
        val localSpinner : Spinner = findViewById(R.id.signlocal)
        //어댑터 생성
        val adapter: ArrayAdapter<String> = ArrayAdapter(this,
        android.R.layout.simple_list_item_1, locals)
        //어댑터 설정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //스피너에 어댑터 적용
        localSpinner.adapter = adapter

        //*회원가입 버튼
        //클릭 시 토스트 메시지 출력
        btn_signup.setOnClickListener{
            Toast.makeText(applicationContext, "회원가입을 축하합니다!",Toast.LENGTH_SHORT).show()
        }
    }




}