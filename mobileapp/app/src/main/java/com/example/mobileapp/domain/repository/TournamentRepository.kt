package com.example.mobileapp.domain.repository

import com.example.mobileapp.domain.model.TournamentStatus
import com.example.mobileapp.domain.model.TournamentType

interface TournamentRepository {
    fun getTournamentStatuses(userId: Int): List<TournamentStatus>
    fun getTournamentTypes(): List<TournamentType>
}