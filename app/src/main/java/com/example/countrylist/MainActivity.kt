package com.example.countrylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val studentList = arrayListOf<StudentList>(
        StudentList("name",2002,R.drawable.vietnam,"da nang"),
        StudentList("buiduchieu",2002,R.drawable.vietnam,"da nang"),
        StudentList("name",2002,R.drawable.vietnam,"da nang"),
        StudentList("name",2002,R.drawable.vietnam,"da nang"),
        StudentList("name",2002,R.drawable.vietnam,"da nang"),
        StudentList("name",2002,R.drawable.vietnam,"da nang"),
        StudentList("name",2002,R.drawable.vietnam,"da nang"),
        StudentList("name",2002,R.drawable.vietnam,"da nang"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val studentRV = findViewById<RecyclerView>(R.id.StudentRecyclerView)
        val studentAdapter = StudentAdapter(this,studentList)
        studentRV.layoutManager = GridLayoutManager(this,1) // choose layout for recyclerview
        studentRV.adapter = studentAdapter // add adapter for recyclerview
        studentAdapter.onItemClick = { studentinfo -> // set behavior for element in adapter (click)
            val intent = Intent(this,StudentDescriptionActivity::class.java) // call countrydescription class and pass data
            intent.putExtra("img",studentinfo.imgResource)
            intent.putExtra("name", studentinfo.name)
            intent.putExtra("year", studentinfo.year)
            intent.putExtra("detail",studentinfo.detail)
            startActivity(intent)
        }
    }
}