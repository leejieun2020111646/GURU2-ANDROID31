package com.example.guruexample


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_adopt_recycler.*



class MainActivity : AppCompatActivity() {

    lateinit var adoptAdapter: AdoptAdapter
    val datas = mutableListOf<AdoptData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_login -> {
                val intent = Intent(this, Login::class.java)
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

            adoptAdapter.datas = datas
            adoptAdapter.notifyDataSetChanged()

        }

    }

    /*버튼 클릭 화면 전환 참고 코드
    val intent = Intent(this, [도착 페이지]::class.java)
    val [버튼변수명] = findViewById<Button>(R.id.[해당버튼id])
    buttonView.setOnClickListener {
        startActivity(intent)
    }
    */
}

