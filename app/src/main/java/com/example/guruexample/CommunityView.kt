package com.example.guruexample


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import kotlinx.android.synthetic.main.activity_community_view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_community_add.*
//import org.jetbrains.anko.intentFor
//import org.jetbrains.anko.singleTop
//import org.jetbrains.anko.startActivity
//import org.jetbrains.anko.toast

class CommunityView : AppCompatActivity() {
    var title : String? = null
    var content : String? = null
    var changeTitle : String? = null
    var changeContent : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_main)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//        var intent = intent as Intent
//        title = intent.getStringExtra("title").toString()
//        content = intent.getStringExtra("content").toString()

//       val fabButton:FloatingActionButton = this.findViewById(R.id.fab)
//        fabButton.setOnClickListener(v: View? ->
//        val intent = Intent(this, ))

        //view_title.setText(title)
        //view_content.setText(content)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_community_changemenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.change -> {
                changeTitle = view_title.text.toString()
                changeContent = view_content.text.toString()
                intent.putExtra("title_",changeTitle)
                intent.putExtra("content_",changeContent)
                setResult(RESULT_OK, intent)

                Log.e("test", changeTitle.toString())
                finish()
            }


            R.id.home -> {
                onSupportNavigateUp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}