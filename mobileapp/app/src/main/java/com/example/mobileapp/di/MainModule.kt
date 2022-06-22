package com.example.mobileapp.di

import com.example.mobileapp.data.MyRepository
import com.example.mobileapp.presentation.main.tablayout.login.LoginViewModel
import com.example.mobileapp.presentation.main.tablayout.signup.SignupViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.example.mobileapp.presentation.start.MyTournamentViewModel

val mainModule = module {
    factory { }
    factory { MyRepository() }
    viewModel { LoginViewModel(get()) }
    viewModel { SignupViewModel(get()) }
    factory { MyTournamentViewModel() }
}