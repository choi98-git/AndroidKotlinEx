package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)

        val resultButton: Button = findViewById(R.id.resultButton)

        resultButton.setOnClickListener{
            Log.d("MainActivity", "ResultButton 이 클릭되었습니다.")

            // 입력값이 비어있을 때 예외처리
            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "입력값이 없습니다!",  Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // EditText 값을 받아서 Int로 저장
            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            // Intent로 다른 Activity로 이동
            val intent = Intent(this, ResultActivity::class.java)

            // 새로운 Activity로 이동할 때 가져가야할 필수 데이터를 넘김
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)
            Log.d("MainActivity", "height: $height weight: $weight" )



        }
    }
}