package com.example.mobileapp.di

import com.example.mobileapp.data.repository.TournamentRepositoryImpl
import com.example.mobileapp.domain.repository.TournamentRepository
import com.example.mobileapp.presentation.start.CreateTournamentViewModel
import com.example.mobileapp.presentation.start.MyTournamentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory<TournamentRepository> { TournamentRepositoryImpl()}
    viewModel { MyTournamentViewModel(get()) }
    viewModel { CreateTournamentViewModel(get()) }
}