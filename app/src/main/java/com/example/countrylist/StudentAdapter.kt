package com.example.countrylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val context: Context, val studentList: List<StudentList>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {



    var onItemClick: ((StudentList) -> Unit)?= null // tra ve unit la tra ve khong gi ca

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {// tao che do xem moi do trinh quan ly bo cuc goi
        val view = LayoutInflater.from(context).inflate(R.layout.student_item,parent,false)
        return ViewHolder(view) // 1 phan tu cua recycler view
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // thay the noi dung cua 1 dang xem (thay doi gia tri cua cac element trong 1 bo cuc)
        holder.name.text = studentList[position].name
        holder.detail.text = "${studentList[position].year}"
        holder.img.setImageResource(studentList[position].imgResource)
    }

    override fun getItemCount(): Int { // tra ve so luong cac muc co trong danh sach (con goi la dem so luong phan tu trong array)
        return studentList.count()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img = view.findViewById<ImageView>(R.id.imageView)
        val name = view.findViewById<TextView>(R.id.nameTV)
        val detail = view.findViewById<TextView>(R.id.yearTV)
        init {// code trong ham init se luon duoc khoi chay khi ma ham dc khoi tao (goi)
            view.setOnClickListener{
               onItemClick?.invoke(studentList[adapterPosition])
            }
        }
    }
}