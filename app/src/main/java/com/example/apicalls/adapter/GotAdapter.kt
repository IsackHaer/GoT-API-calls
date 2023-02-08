package com.example.apicalls.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.apicalls.R
import com.example.apicalls.data.model.GotCharacter

class GotAdapter : RecyclerView.Adapter<GotAdapter.itemViewHolder>() {

    private var dataset = listOf<GotCharacter>()

    class itemViewHolder(view: View) : ViewHolder(view) {
        val fullname: TextView = view.findViewById(R.id.got_fullname)
        val title: TextView = view.findViewById(R.id.got_title)
        val family: TextView = view.findViewById(R.id.got_family)
    }

    fun submitList(list: List<GotCharacter>) {
        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.got_item, parent, false)
        return itemViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val character = dataset[position]
        holder.fullname.text = character.fullName
        holder.title.text = character.title
        holder.family.text = character.family
    }
}