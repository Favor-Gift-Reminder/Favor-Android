package com.nise.favor_android

import android.content.ContentValues
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login_btn.setOnClickListener {
            //Log.d(TAG,"로그인 버튼 클릭")

            val id = id_text.text.toString()
            val pw = pw_text.text.toString()
            val sharedPreference = getSharedPreferences("file name", MODE_PRIVATE)
            val savedId = sharedPreference.getString("id", "")
            val savedPw = sharedPreference.getString("pw", "")
            // 유저가 입력한 id, pw값과 쉐어드로 불러온 id, pw값 비교
            if(id == savedId && pw == savedPw){
                // 로그인 성공 다이얼로그 보여주기
                dialog("success")
                setContentView(R.layout.fragment_list)
            }
            else{
                // 로그인 실패 다이얼로그 보여주기
                dialog("fail")
            }
        }
        register_btn.setOnClickListener{
            Log.d(ContentValues.TAG,"회원가입 버튼 클릭")
    }

    fun dialog(type: String){
        var dialog = AlertDialog.Builder(this)

        if(type.equals("success")){
            dialog.setTitle("로그인 성공")
            dialog.setMessage("로그인 성공!")
        }
        else if(type.equals("fail")){
            dialog.setTitle("로그인 실패")
            dialog.setMessage("아이디와 비밀번호를 확인해주세요")
        }

        var dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(ContentValues.TAG, "")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }

    fun Login(v: View){
        Toast.makeText(this,"클릭", Toast.LENGTH_SHORT).show()
        println("성공")
    }
    }
}