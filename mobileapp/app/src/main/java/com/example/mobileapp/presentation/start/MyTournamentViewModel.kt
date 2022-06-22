package com.example.mobileapp.presentation.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.presentation.model.TournamentStatus
import kotlinx.coroutines.launch

class MyTournamentViewModel: ViewModel() {

    val tournamentStatuses = MutableLiveData<List<TournamentStatus>>()

    fun loadTournamentStatuses(){
        viewModelScope.launch {
            tournamentStatuses.value = getFakeStatuses()
        }
    }

    fun getFakeStatuses(): List<TournamentStatus>{
        return listOf(
            TournamentStatus(1, "Турнир 1", "Завершен",1),
            TournamentStatus(2, "Турнир 2", "Завершен",1),
            TournamentStatus(3, "Турнир 3", "Завершен",1),
            TournamentStatus(4, "Турнир 4", "Завершен",1),
            TournamentStatus(5, "Турнир 5", "Идет",2),
            TournamentStatus(6, "Турнир 6", "Идет",2),
            TournamentStatus(7, "Турнир 7", "Идет",2),
            TournamentStatus(8, "Турнир 8", "Идет",2)
        )
    }
}