//리사이클러뷰 아이템을 클릭하면 나오는 상세페이지
//AdoptMain 액티비티에서의 오류로 실행이 안됨

package com.example.guruexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_adopt_detail.*
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton

class AdoptDetailActivity : AppCompatActivity() {

    //lateinit var datas : AdoptData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_detail)

        //datas = intent.getSerializableExtra("data") as AdoptData

        //Glide.with(this).load(datas.img).into(img_profile)
        //tv_name.text = datas.name


        //서울동물복지지원센터로 이동
        findViewById<ImageButton>(R.id.btn_seoul1).setOnClickListener {
            val url = "https://animal.seoul.go.kr/index"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        //입양 교육 페이지로 이동
        findViewById<ImageButton>(R.id.btn_edu1).setOnClickListener {
            val url = "https://sll.seoul.go.kr/lms/requestCourse/doDetailInfo.do?course_id=ASP00001S995220220000001&class_no=01&course_gubun=1&asp_id=ASP00001&course_category_id=202102012389901&category_status=&page=1&mnid=202102146855"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

    }

    //메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_adopt_notice, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_main -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_login -> {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_mypage -> {
                val intent = Intent(this, MypageActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_adoptmain -> {
                val intent = Intent(this, AdoptMain::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}