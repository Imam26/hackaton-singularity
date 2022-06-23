package com.example.mobileapp.presentation.start

import com.example.mobileapp.domain.model.Tournament

interface OnClickListener {

    fun onTournamentItemClicked(tournament: Tournament)

}