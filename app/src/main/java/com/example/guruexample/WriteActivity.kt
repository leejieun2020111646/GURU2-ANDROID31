package com.example.guruexample

import android.R.attr.description
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.guruexample.Room.CommunityDatabase
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.community_fragment.*


class WriteActivity : AppCompatActivity() {

    private var title: EditText? = null
    private var content: EditText? = null
    private var db: CommunityDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.guruexample.R.layout.community_add)
        title = findViewById(R.id.cm_title)
        content = findViewById(R.id.cm_content)
        db = CommunityDatabase.getInstance(this)
    }


    //상단에 메모저장하는 버튼
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_community_add, menu)
        return true
    }

    //Edit view에 있는 내용을 db에 넣어줘야 함함
//
//   private fun insert() { //worker thread
//        val runnable: Runnable = object : Runnable {
//            override fun run() {
//                db.CommunityDao().insert(titleTextWatcher, contentTextWatcher)
//            }
//        }
//        Thread(runnable).start()
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle item selection
//        return when (item.itemId) {
//            R.id.save -> {
//
//            }
//        }
//    }

}
