//리사이클러뷰 아이템을 클릭하면 나오는 상세페이지
//AdoptMain 액티비티에서의 오류로 실행이 안됨

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