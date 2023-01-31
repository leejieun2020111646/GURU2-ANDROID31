package com.example.guruexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CommunityMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //기본 생성자들
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_main)
        //fab버튼 클릭시 새 액티비티 생성
        val fabButton : FloatingActionButton = this.findViewById(R.id.Main_FabButton_fab)
        fabButton.setOnClickListener{
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }
    }
}