package com.example.guruexample


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
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
            add(AdoptData(name = "믹스견", age = 2, info = "온순함"))
            add(AdoptData(name = "치와와", age = 4, info = "약 4kg"))
            add(AdoptData(name = "비숑", age = 7, info = "온순함"))
            add(AdoptData(name = "푸들", age = 1, info = "온순함"))
            add(AdoptData(name = "말티즈", age = 3, info = "온순함"))

            adoptAdapter.datas = datas
            adoptAdapter.notifyDataSetChanged()

        }

    }


}