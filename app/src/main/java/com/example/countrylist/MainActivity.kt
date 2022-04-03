package com.example.countrylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val countryList = arrayListOf<CountryInfo>(
        CountryInfo("VietNam", 96.3,R.drawable.vietnam,"A very beautiful country"),
        CountryInfo("Laos", 10.9,R.drawable.vietnam,"A very beautiful country"),
        CountryInfo("Korea", 96.3,R.drawable.vietnam,"A very beautiful country"),
        CountryInfo("Thailand", 96.3,R.drawable.vietnam,"A very beautiful country"),
        CountryInfo("Japan", 96.3,R.drawable.vietnam,"A very beautiful country")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countrRV = findViewById<RecyclerView>(R.id.CountryRecyclerView)
        val countryAdapter = CountyAdapter(this,countryList)
        countrRV.layoutManager = GridLayoutManager(this,2)
        countrRV.adapter = countryAdapter
        countryAdapter.onItemClick = { countryinfo ->
            val intent = Intent(this,CountryDescriptionActivity::class.java)
            intent.putExtra("countryName", countryinfo.name)
            intent.putExtra("countryDesc", countryinfo.desc)
            startActivity(intent)
        }
    }
}