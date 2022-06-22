package com.example.mobileapp.domain.repository

import com.example.mobileapp.domain.model.Tournament
import com.example.mobileapp.domain.model.TournamentType

interface TournamentRepository {
    fun getTournaments(userId: Int): List<Tournament>
    fun getTournamentTypes(): List<TournamentType>
    fun addTournament(tournament: Tournament)
}