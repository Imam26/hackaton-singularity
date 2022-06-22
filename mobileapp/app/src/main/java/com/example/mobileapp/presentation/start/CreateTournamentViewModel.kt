package com.example.mobileapp.presentation.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.domain.model.TournamentType
import com.example.mobileapp.domain.repository.TournamentRepository
import kotlinx.coroutines.launch

class CreateTournamentViewModel(
    private val repository: TournamentRepository
): ViewModel() {

    val tournamentKinds = MutableLiveData<List<TournamentType>>()

    fun loadTournamentKinds(){
        viewModelScope.launch {
            tournamentKinds.value = repository.getTournamentTypes()
        }
    }
}