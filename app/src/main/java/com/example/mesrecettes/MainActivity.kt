package com.example.mesrecettes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()

        val secondPagbutton=findViewById<Button>(R.id.second_page_btn)
        secondPagbutton.setOnClickListener {
         val Intent= Intent(this,SecondActivity::class.java)
            startActivity(Intent)




        }



    }
}