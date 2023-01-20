package com.example.guruexample


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var adoptAdapter: AdoptAdapter
    val datas = mutableListOf<AdoptData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }

    private fun initRecycler() {
        adoptAdapter = AdoptAdapter(this)
        rv_profile.adapter = adoptAdapter


        datas.apply {
            add(AdoptData(name = "mary", age = 24))
            add(AdoptData(name = "jenny", age = 26))
            add(AdoptData(name = "jhon", age = 27))
            add(AdoptData(name = "ruby", age = 21))
            add(AdoptData(name = "yuna", age = 23))

            adoptAdapter.datas = datas
            adoptAdapter.notifyDataSetChanged()

        }
    }


}