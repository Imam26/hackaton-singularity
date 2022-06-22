package com.example.mobileapp.data

import com.example.mobileapp.domain.model.Tournament
import com.example.mobileapp.domain.model.TournamentType

object Data {
    val tournamentTypes = listOf(
        TournamentType(1, "Теннис"),
        TournamentType(1, "FIFA"),
        TournamentType(1, "Mortal Kombat"),
    )

    val tournaments = mutableListOf<Tournament>()
}