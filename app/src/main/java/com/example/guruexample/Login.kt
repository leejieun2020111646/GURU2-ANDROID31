package com.example.guruexample

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guruexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_register1.*
import com.google.firebase.firestore.auth.User as User

class Login : AppCompatActivity() {

    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var lg_id:EditText
    lateinit var lg_pw:EditText


    //뒤로가기 버튼 기능(공통코드)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //회원가입 버튼 클릭 시 페이지 이동(Register로 이동)
        val BtnRegister = findViewById<Button>(R.id.btn_register)
        BtnRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        //DB연결

        val ck_id = findViewById<EditText>(R.id.edit_id)
        val ck_pw = findViewById<EditText>(R.id.edit_pw)
        val BtnLogin = findViewById<Button>(R.id.btn_login)

        //로그인 기능 함수
        fun login(id:String, pw:String): Boolean {
            var loginFlag = false

            dbManager = DBManager(this, "USERTABLE", null, 1)
            sqlitedb = dbManager.readableDatabase

            var cursor:Cursor
            cursor = sqlitedb.rawQuery("SELECT * FROM USERTABLE WHERE id = '"+ck_id+"' AND pw = '"+ck_pw+"';",null)
            if(cursor.moveToFirst()){
                loginFlag = true
            }
            return loginFlag
        }


            BtnLogin.setOnClickListener {
                dbManager = DBManager(this, "USERTABLE", null, 1)
                sqlitedb = dbManager.readableDatabase

                var get_id : String = ck_id.text.toString()
                var get_pw : String = ck_pw.text.toString()

                //빈 곳 체크
                if(get_id.length == 0){
                    Toast.makeText(this,"아이디를 입력하세요",Toast.LENGTH_SHORT).show()
                }else if(get_pw.length == 0){
                    Toast.makeText(this,"비밀번호를 입력하세요",Toast.LENGTH_SHORT).show()
                }else{ //id,pw 모두 입력된 경우
                    var cursor:Cursor
                    cursor = sqlitedb.rawQuery("SELECT id,pw FROM USERTABLE",null)

                    cursor.moveToNext()
                    val C_id = cursor.getString(0)
                    val C_pw = cursor.getString(1)

                    if(get_id.equals(C_id) && get_pw.equals(C_pw)) {
                        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                        //로그인 성공 시 메인페이지로 이동
                        val intent = Intent(this, AdoptMain::class.java)
                        startActivity(intent)
                    }
                    else if(get_id.equals(C_id)==true && get_pw.equals(C_pw)==false ){
                        Toast.makeText(this, "비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "아이디가 틀렸습니다", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }
    }


