package com.example.guruexample

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewParent
import android.view.WindowId
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.guruexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_register1.*
import java.text.FieldPosition

class Register : AppCompatActivity() {

    lateinit var dbManager: DBManager
    lateinit var sqlitedb:SQLiteDatabase
    lateinit var btnSignup:Button
    lateinit var edtId:EditText //아이디
    lateinit var edtPw:EditText //비밀번호
    lateinit var edtName:EditText //이름
    lateinit var edtTel:EditText //전화번호
    lateinit var edtEmail:EditText //이메일
    lateinit var rg_gender:RadioGroup //성별
    lateinit var rb_gender_m:RadioButton
    lateinit var rb_gender_f:RadioButton
    lateinit var edtBir:EditText //생년월일


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
        setContentView(R.layout.activity_register1)

        //DB연결
        btnSignup = findViewById(R.id.signupbutton)
        edtId = findViewById(R.id.signID)
        edtPw = findViewById(R.id.signPW)
        edtName = findViewById(R.id.signName)
        edtTel = findViewById(R.id.signphone)
        edtEmail = findViewById(R.id.signmail)
        rg_gender = findViewById(R.id.radiogroup_gender)
        rb_gender_m = findViewById(R.id.radio_male)
        rb_gender_f = findViewById(R.id.radio_female)
        edtBir = findViewById(R.id.signBirth)
        dbManager = DBManager(this, "USERTABLE", null, 1)

        //회원가입 버튼 클릭 시
        btnSignup.setOnClickListener {
            var str_id: String = edtId.text.toString()
            var str_pw: String = edtPw.text.toString()
            var str_name: String = edtName.text.toString()
            var str_tel: String = edtTel.text.toString()
            var str_email: String = edtEmail.text.toString()
            var str_bir: String = edtBir.text.toString()
            var str_gender: String = ""

            if (rg_gender.checkedRadioButtonId == R.id.radio_male){
                str_gender = rb_gender_m.text.toString()
            }
            if (rg_gender.checkedRadioButtonId == R.id.radio_female){
                str_gender = rb_gender_f.text.toString()
            }

            sqlitedb = dbManager.writableDatabase
            sqlitedb.execSQL("INSERT INTO USERTABLE VALUES ('"+str_id+"','"+str_pw+"','"+str_name+"','"+str_tel+"','"+str_email+"','"+str_gender+"','"+str_bir+"');")
            sqlitedb.close()

            Toast.makeText(this, "프로펫터에 오신 것을 환영합니다!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //DB연결

        //뒤로가기 버튼
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //관심지역 Spinner
        var local_data = arrayOf("서울","부산","대구","인천","광주","세종","대전","울산","경기","강원","충북","충남","전북","전남","경북","경남","제주")
        val local_spinner : Spinner = findViewById(R.id.signlocal)
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1, local_data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        local_spinner.adapter = adapter

        local_spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                //sp_local = local_spinner.getItemAtPosition(position)
                val local_select = local_spinner.get(position) //선택 지역을 local_select 변수에 담음
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        //관심지역 Spinner
    }

}