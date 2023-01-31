package com.example.guruexample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guruexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_register1.*
import com.google.firebase.firestore.auth.User as User

class Login : AppCompatActivity() {

    //db연결코드1
    /*lateinit var db: DBHelper

    //var users = ArrayList<User>()
    private lateinit var binding: ActivityMainBinding*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //회원가입 버튼 클릭 시 페이지 이동(Register로 이동)
        val BtnRegister = findViewById<ImageButton>(R.id.btn_register)
        BtnRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        /*
        //db연결코드2
        db = DBHelper(this)

        //로그인 버튼 클릭 시 로그인, db
        val BtnLogin = findViewById<Button>(R.id.btn_login)
        BtnLogin.setOnClickListener {
            createUser().let {
                if (it != null) {
                    if (db.login(it)) {
                        Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                        val intent =
                            Intent(this, AdoptMain::class.java) //AdoptMain로 해뒀는데 어디로 이동할지 수정필요
                        /*이건 이름 받아와서 ㅇㅇ님 안녕하세요 하는 코드임
                        intent.putExtra("name", binding.nameEditText.text.toString())
                        startActivity(intent)*/
                    } else {
                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "정보를 모두 입력해주세요", Toast.LENGTH_SHORT).show()
                }

            }
        }
        */


    }

    //메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_login, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_main -> {
                val intent = Intent(this, MainActivity::class.java)
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
            R.id.action_notice -> {
                val intent = Intent(this, AdoptNotice::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /*
    //createUser(), 변수명은건들지말기
    @SuppressLint("RestrictedApi")
    private fun createUser(): User? {
        var read_id = findViewById<EditText>(R.id.edit_id)
        var id: String = read_id.text.toString()

        var read_pw = findViewById<EditText>(R.id.edit_pw)
        var pw: String = read_pw.text.toString()
        //val id = binding.idEditText.text.toString()
        //val pw = binding.pwEditText.text.toString()

        //val name = binding.nameEditText.text.toString()
        if (id == "" || pw == "") { // 입력 정보가 하나라도 비어있으면
            return null // Null 반환
        }
        return User(id,pw)
    }*/
}

