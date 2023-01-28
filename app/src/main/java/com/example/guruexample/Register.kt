package com.example.guruexample

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.view.WindowId
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.guruexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_register1.*
import java.text.FieldPosition

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
        //DB연결

        //관심지역 Spinner
        /*var data = listOf("지역 선택","서울","부산","대구","인천","광주","세종","대전","울산","경기","강원","충북","충남","전북","전남","경북","경남","제주")
        var adapter  =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        signlocal.adapter = adapter
        signlocal.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = data.get(position)
            }
        }*/
        var local_data = arrayOf("지역 선택","서울","부산","대구","인천","광주","세종","대전","울산","경기","강원","충북","충남","전북","전남","경북","경남","제주")
        val local_spinner : Spinner = findViewById(R.id.signlocal)
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1, local_data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        local_spinner.adapter = adapter
    //관심지역 Spinner


    }

}