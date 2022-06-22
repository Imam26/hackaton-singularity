package com.example.mobileapp.presentation.viewholder

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.R
import com.example.mobileapp.presentation.model.TournamentStatus

class TournamentStatusViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_tournament_status, parent, false))  {

    @RequiresApi(Build.VERSION_CODES.M)
    fun onBind(item: TournamentStatus, clickListener: (item: TournamentStatus) -> Unit){
        itemView.findViewById<TextView>(R.id.tournamentName).text = item.name
        var tournamentStatusTw = itemView.findViewById<TextView>(R.id.tournamentStatus)
        tournamentStatusTw.text = item.status

        if(item.statusId == 1 ){
            tournamentStatusTw.setTextColor(itemView.context.getColor(R.color.color_complete))
        } else {
            tournamentStatusTw.setTextColor(itemView.context.getColor(R.color.color_goes))
        }

        itemView.setOnClickListener {
            clickListener(item)
        }
    }
}