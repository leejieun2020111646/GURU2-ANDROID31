package com.example.guruexample


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_adopt_main.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_adopt_recycler.*


class AdoptMain : AppCompatActivity() {
    lateinit var adoptAdapter: AdoptAdapter
    val datas = mutableListOf<AdoptData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_main)

        initRecycler()

    }

    //메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_adopt_main, menu)
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
            R.id.action_notice -> {
                val intent = Intent(this, AdoptNotice::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //상세페이지로 이동하는 코드
    //오류로 인해 실행이 안됨
    /*adoptAdapter.setOnItemClickListener(object : AdoptAdapter.OnItemClickListener{
        override fun onItemClick(v: View, data: AdoptData, pos : Int) {
            Intent(this@AdoptMain, AdoptDetailActivity::class.java).apply {
                putExtra("data", data)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run { startActivity(this) }
        }

    })*/

    //리사이클러뷰에 들어갈 정보
    private fun initRecycler() {
        adoptAdapter = AdoptAdapter(this)
        rv_profile.adapter = adoptAdapter

        datas.apply {
            add(AdoptData(img = R.drawable.pet_img_1_caramel, name = "카라멜", age = 2, info = "-품종 : 믹스 -성별 : 수컷 -나이 : 2세 2개월 -체중 : 5.2kg"))
            add(AdoptData(img = R.drawable.pet_img_2_tamna, name = "탐나", age = 3, info = "-품종 : 믹스 -성별 : 수컷 -나이 : 3세 1개월 -체중 : 5.2kg"))
            add(AdoptData(img = R.drawable.pet_img_3_tuning, name = "튜닝", age = 7, info = "-품종 : 믹스 -성별 : 암컷 -나이 : 1세 1개월 -체중 : 4.2kg"))
            add(AdoptData(img = R.drawable.pet_img_4_timong, name = "티몽", age = 1, info = "-품종 : 푸들 -성별 : 수컷 -나이 : 3세 7개월 -체중 : 5.4kg"))
            add(AdoptData(img = R.drawable.pet_img_5_tiyong, name = "티용", age = 3, info = "-품종 : 코리안숏헤어 -성별 : 암컷 -나이 : 3개월 -체중 : 1.6kg"))
            add(AdoptData(img = R.drawable.pet_img_6_tellae, name = "텔레", age = 3, info = "-품종 : 코리안숏헤어 -성별 : 수컷 -나이 : 3개월 -체중 : 1.8kg"))
            add(AdoptData(img = R.drawable.pet_img_7_tobi, name = "토비", age = 3, info = "-품종 : 코리안숏헤어 -성별 : 수컷 -나이 : 3개월 -체중 : 1.67kg"))

            //add(AdoptData(img = R.drawable.pet_img_1_caramel, name = "이름: 카라멜", age = "나이: 2세 2개월", info = "-품종 : 믹스 -성별 : 수컷 -체중 : 5.2kg"))

            adoptAdapter.datas = datas
            adoptAdapter.notifyDataSetChanged()

        }

    }

}