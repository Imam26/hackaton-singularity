package com.example.mobileapp.di

import com.example.mobileapp.data.repository.AuthRepository
import com.example.mobileapp.presentation.main.tablayout.login.LoginViewModel
import com.example.mobileapp.presentation.main.tablayout.signup.SignupViewModel
import com.example.mobileapp.data.repository.TournamentRepositoryImpl
import com.example.mobileapp.domain.repository.TournamentRepository
import com.example.mobileapp.presentation.start.CreateTournamentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.example.mobileapp.presentation.start.MyTournamentViewModel

val mainModule = module {
    factory { AuthRepository(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { SignupViewModel(get()) }
    factory<TournamentRepository> { TournamentRepositoryImpl() }
    viewModel { MyTournamentViewModel(get()) }
    viewModel { CreateTournamentViewModel(get()) }
}