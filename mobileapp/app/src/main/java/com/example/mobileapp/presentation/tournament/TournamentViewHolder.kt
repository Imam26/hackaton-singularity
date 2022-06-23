package com.example.mobileapp.presentation.tournament

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.R

class TournamentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvPlayer1: TextView = itemView.findViewById(R.id.tv_player1)
    private val tvPlayer2: TextView = itemView.findViewById(R.id.tv_player2)
    private val enterScoreET1: EditText = itemView.findViewById(R.id.et_edit_score1)
    private val enterScoreET2: EditText = itemView.findViewById(R.id.et_edit_score2)


}