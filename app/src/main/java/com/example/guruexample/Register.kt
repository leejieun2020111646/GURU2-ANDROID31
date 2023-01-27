package com.example.guruexample

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.guruexample.databinding.ActivityMainBinding

class Register : AppCompatActivity() {

    //시작1
    lateinit var dbManager: DBManager
    lateinit var sqlitedb:SQLiteDatabase
    lateinit var btnSignup:Button
    lateinit var edtId:EditText
    lateinit var edtPw:EditText
    lateinit var edtName:EditText
    lateinit var edtTel:EditText
    lateinit var edtEmail:EditText
    lateinit var rg_gender:RadioGroup
    lateinit var rb_gender_m:RadioButton
    lateinit var rb_gender_f:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)

        //시작2
        btnSignup = findViewById(R.id.signupbutton)
        edtId = findViewById(R.id.signID)
        edtPw = findViewById(R.id.signPW)
        edtName = findViewById(R.id.signName)
        edtTel = findViewById(R.id.signphone)
        edtEmail = findViewById(R.id.signmail)
        rg_gender = findViewById(R.id.radiogroup_gender)
        rb_gender_m = findViewById(R.id.radio_male)
        rb_gender_f = findViewById(R.id.radio_female)

        dbManager = DBManager(this, "USERTABLE", null, 1)

        //회원가입 버튼 클릭 시
        btnSignup.setOnClickListener {
            var str_id: String = edtId.text.toString()
            var str_pw: String = edtPw.text.toString()
            var str_name: String = edtName.text.toString()
            var str_tel: String = edtTel.text.toString()
            var str_email: String = edtEmail.text.toString()
            var str_gender: String = ""

            if (rg_gender.checkedRadioButtonId == R.id.radio_male){
                str_gender = rb_gender_m.text.toString()
            }
            if (rg_gender.checkedRadioButtonId == R.id.radio_female){
                str_gender = rb_gender_f.text.toString()
            }

            sqlitedb = dbManager.writableDatabase
            sqlitedb.execSQL("INSERT INTO USERTABLE values ('"+str_id+"','"+str_pw+"','"+str_name+"','"+str_tel+"','"+str_email+"','"+str_gender+"')")
            sqlitedb.close()
        }


    }

}