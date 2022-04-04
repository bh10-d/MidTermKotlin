package com.example.countrylist

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDescriptionActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_description)
        if(intent!=null){
            findViewById<TextView>(R.id.desc_name).text = intent.getStringExtra("name")
            findViewById<TextView>(R.id.desc_year).text = intent.getStringExtra("year")
            findViewById<TextView>(R.id.desc_detail).text = intent.getStringExtra("detail")
            findViewById<TextView>(R.id.desc_img).text = intent.getStringExtra("img")
        }
    }
}