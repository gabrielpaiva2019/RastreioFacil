package com.rastreiofacil.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rastreiofacil.R
import com.rastreiofacil.model.Track

class MainAdapter(private val listTracking: MutableList<Track>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_tracking_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var track = listTracking[position]

        holder.textTeste.text = track.data.tracking.trackingNumber
    }

    override fun getItemCount(): Int {
        return listTracking.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textTeste = itemView.findViewById<TextView>(R.id.textViewTeste)
    }
}