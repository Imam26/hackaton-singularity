package com.example.mobileapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.domain.model.TournamentStatus
import com.example.mobileapp.presentation.viewholder.TournamentStatusViewHolder

class TournamentStatusAdapter(
    private val clickListener: (item: TournamentStatus) -> Unit,
): RecyclerView.Adapter<TournamentStatusViewHolder>() {
    private val data = mutableListOf<TournamentStatus>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentStatusViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TournamentStatusViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TournamentStatusViewHolder, position: Int) {
        holder.onBind(data[position], clickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setItems(list: List<TournamentStatus>){
        data.clear()
        data.addAll(0, list)
        notifyDataSetChanged()
    }
}