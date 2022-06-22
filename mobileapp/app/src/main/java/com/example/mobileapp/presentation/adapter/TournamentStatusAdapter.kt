package com.example.mobileapp.presentation.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.domain.model.Tournament
import com.example.mobileapp.presentation.viewholder.TournamentStatusViewHolder

class TournamentStatusAdapter(
    private val clickListener: (item: Tournament) -> Unit,
): RecyclerView.Adapter<TournamentStatusViewHolder>() {
    private val data = mutableListOf<Tournament>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentStatusViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TournamentStatusViewHolder(inflater, parent)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: TournamentStatusViewHolder, position: Int) {
        holder.onBind(data[position], clickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setItems(list: List<Tournament>){
        data.clear()
        data.addAll(0, list)
        notifyDataSetChanged()
    }
}