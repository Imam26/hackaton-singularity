package com.example.mobileapp.data.repository

import com.example.mobileapp.data.Data
import com.example.mobileapp.domain.model.Tournament
import com.example.mobileapp.domain.model.TournamentType
import com.example.mobileapp.domain.repository.TournamentRepository

class TournamentRepositoryImpl: TournamentRepository {
    override fun getTournaments(userId: Int): List<Tournament> {
        return Data.tournaments
    }

    override fun getTournamentTypes(): List<TournamentType> {
        return Data.tournamentTypes
    }

    override fun addTournament(tournament: Tournament) {
        if(tournament.statusId == 1){
            tournament.status = "Не начался"
        } else if(tournament.statusId == 2){
            tournament.status = "Идет"
        } else if(tournament.statusId == 3){
            tournament.status = "Завершился"
        }

        Data.tournaments.add(0, tournament)
    }
}