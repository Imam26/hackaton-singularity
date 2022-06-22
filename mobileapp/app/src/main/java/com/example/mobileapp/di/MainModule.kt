package com.example.mobileapp.di

import com.example.mobileapp.presentation.start.MyTournamentViewModel
import org.koin.dsl.module

val mainModule = module {
    factory { MyTournamentViewModel() }
}