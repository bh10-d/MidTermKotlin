package com.example.countrylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CountryDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_description)
        if(intent!=null){
            findViewById<TextView>(R.id.desc_CountryName).text = intent.getStringExtra("countryName")
            findViewById<TextView>(R.id.desc_CountryDescription).text = intent.getStringExtra("countryDesc")
        }
    }
}