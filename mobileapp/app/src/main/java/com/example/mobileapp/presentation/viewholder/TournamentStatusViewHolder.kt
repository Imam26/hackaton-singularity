package com.example.mobileapp.presentation.viewholder

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.R
import com.example.mobileapp.domain.model.Tournament

class TournamentStatusViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_tournament_status, parent, false))  {

    @RequiresApi(Build.VERSION_CODES.M)
    fun onBind(item: Tournament, clickListener: (item: Tournament) -> Unit){
        itemView.findViewById<TextView>(R.id.tournamentName).text = item.name
        var tournamentStatusTw = itemView.findViewById<TextView>(R.id.tournamentStatus)
        tournamentStatusTw.text = item.status

        when (item.statusId) {
            1 -> {
                tournamentStatusTw.setTextColor(itemView.context.getColor(R.color.color_not_start))
            }
            2 -> {
                tournamentStatusTw.setTextColor(itemView.context.getColor(R.color.color_goes))
            }
            3 -> {
                tournamentStatusTw.setTextColor(itemView.context.getColor(R.color.color_complete))
            }
        }

        itemView.setOnClickListener {
            clickListener(item)
        }
    }
}