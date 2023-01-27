package com.example.guruexample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.guruexample.databinding.ActivityMainBinding

class Register : AppCompatActivity() {

    //db연결코드1
    lateinit var db: DBHelper
    //var users = ArrayList<User>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)


        //db연결코드2
        db = DBHelper(this)


        val BtnSignup = findViewById<Button>(R.id.signupbutton)
        /*BtnSignup.setOnClickListener {
            createUser().let{
                if (it!= null) {
                    db.addUser(it)
                }
        }*/ //여기 잠깐 닫을게

        /*binding.BtnRegister.setOnClickListener{
            createUser().let{
                if (it!= null) {
                    db.addUser(it)
                }
            }
        }*/







    }
}