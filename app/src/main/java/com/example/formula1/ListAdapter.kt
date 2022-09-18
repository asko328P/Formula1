package com.example.formula1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.formula1.R
import com.example.formula1.dataBase.DriverEntity


class ListAdapter: RecyclerView.Adapter<com.example.formula1.ListAdapter.MyViewHolder>() {

    private var userList = emptyList<DriverEntity>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.textView11).text=currentItem.name

        holder.itemView.findViewById<TextView>(R.id.textView12).text = currentItem.surName
        holder.itemView.findViewById<TextView>(R.id.textView28).text = currentItem.nationality
        holder.itemView.findViewById<TextView>(R.id.textView29).text = currentItem.dateOfBirth
        holder.itemView.findViewById<TextView>(R.id.textView30).text = currentItem.permanentNumber
    }

    fun setData(user: List<DriverEntity>){
        this.userList = user
        notifyDataSetChanged()
    }
}