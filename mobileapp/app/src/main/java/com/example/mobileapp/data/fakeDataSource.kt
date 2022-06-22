package com.example.mobileapp.data

import com.example.mobileapp.domain.model.TournamentStatus
import com.example.mobileapp.domain.model.TournamentType

object Data {
    val tournamentStatuses = listOf(
        TournamentStatus(1, "Турнир 1", "Завершен",1),
        TournamentStatus(2, "Турнир 2", "Завершен",1),
        TournamentStatus(3, "Турнир 3", "Завершен",1),
        TournamentStatus(4, "Турнир 4", "Завершен",1),
        TournamentStatus(5, "Турнир 5", "Идет",2),
        TournamentStatus(6, "Турнир 6", "Идет",2),
        TournamentStatus(7, "Турнир 7", "Идет",2),
        TournamentStatus(8, "Турнир 8", "Идет",2)
    )

    val tournamentTypes = listOf(
        TournamentType(1, "Теннис"),
        TournamentType(1, "FIFA"),
        TournamentType(1, "Mortal Kombat"),
    )
}