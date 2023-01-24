package com.example.guruexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_adopt_detail.*

class AdoptDetailActivity : AppCompatActivity() {
    lateinit var datas : AdoptData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_detail)

        datas = intent.getSerializableExtra("data") as AdoptData

        Glide.with(this).load(datas.img).into(img_profile)
        tv_name.text = datas.name

    }
}