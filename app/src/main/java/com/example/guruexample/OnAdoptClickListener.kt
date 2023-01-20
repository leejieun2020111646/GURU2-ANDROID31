package com.example.guruexample

import android.view.View

interface OnAdoptClickListener {
    fun onItemClick(holder: AdoptAdapter.ViewHolder, view : View, position : Int)

}