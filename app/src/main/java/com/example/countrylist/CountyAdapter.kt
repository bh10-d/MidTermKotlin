package com.example.countrylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class CountyAdapter(val context: Context, val countrylist: List<CountryInfo>):RecyclerView.Adapter<CountyAdapter.ViewHolder>() {

    var onItemClick: ((CountryInfo) -> Unit)?= null // tra ve unit la tra ve khong gi ca

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {// tao che do xem moi do trinh quan ly bo cuc goi
        val view = LayoutInflater.from(context).inflate(R.layout.country_item,parent,false)
        return ViewHolder(view) // 1 phan tu cua recycler view
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // thay the noi dung cua 1 dang xem (thay doi gia tri cua cac element trong 1 bo cuc)
        holder.nameTV.text = countrylist[position].name
        holder.population.text = "${countrylist[position].population} milions"
        holder.flagTV.setImageResource(countrylist[position].imageResourceID)
    }

    override fun getItemCount(): Int { // tra ve so luong cac muc co trong danh sach
        return countrylist.count()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val flagTV = view.findViewById<ImageView>(R.id.flagimageView)
        val nameTV = view.findViewById<TextView>(R.id.nameTV)
        val population = view.findViewById<TextView>(R.id.populationTV)
        init {// code trong ham init se luon duoc khoi chay khi ma ham dc khoi tao (goi)
            view.setOnClickListener{
                onItemClick?.invoke(countrylist[adapterPosition])
            }
        }
    }
}