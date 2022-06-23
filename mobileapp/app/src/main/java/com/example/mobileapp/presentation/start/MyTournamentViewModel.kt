package com.example.mobileapp.presentation.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.Data
import com.example.mobileapp.domain.model.Tournament
import com.example.mobileapp.domain.repository.TournamentRepository
import kotlinx.coroutines.launch

class MyTournamentViewModel(
    private val repository: TournamentRepository
): ViewModel() {

    val tournamentStatuses = MutableLiveData<List<Tournament>>()

    fun loadTournamentStatuses(){
        viewModelScope.launch {
            Data.currentUser?.let {
                tournamentStatuses.value = repository.getTournaments(it.id)
            }
        }
    }
}