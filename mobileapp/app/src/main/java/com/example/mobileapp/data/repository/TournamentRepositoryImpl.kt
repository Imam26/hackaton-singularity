package com.example.mobileapp.data.repository

import com.example.mobileapp.data.Data
import com.example.mobileapp.domain.model.TournamentStatus
import com.example.mobileapp.domain.model.TournamentType
import com.example.mobileapp.domain.repository.TournamentRepository

class TournamentRepositoryImpl: TournamentRepository {
    override fun getTournamentStatuses(userId: Int): List<TournamentStatus> {
        return Data.tournamentStatuses
    }

    override fun getTournamentTypes(): List<TournamentType> {
        return Data.tournamentTypes
    }
}