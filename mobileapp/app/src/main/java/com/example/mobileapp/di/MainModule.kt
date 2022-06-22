package com.example.mobileapp.di

<<<<<<< HEAD
import com.example.mobileapp.data.MyRepository
import com.example.mobileapp.presentation.main.tablayout.login.LoginViewModel
import com.example.mobileapp.presentation.main.tablayout.signup.SignupViewModel
=======
import com.example.mobileapp.data.repository.TournamentRepositoryImpl
import com.example.mobileapp.domain.repository.TournamentRepository
import com.example.mobileapp.presentation.start.CreateTournamentViewModel
import com.example.mobileapp.presentation.start.MyTournamentViewModel
>>>>>>> 8323ea226b4330b19d7b92a9a9a8d6cb1a600b49
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.example.mobileapp.presentation.start.MyTournamentViewModel

val mainModule = module {
<<<<<<< HEAD
    factory { }
    factory { MyRepository() }
    viewModel { LoginViewModel(get()) }
    viewModel { SignupViewModel(get()) }
    factory { MyTournamentViewModel() }
=======
    factory<TournamentRepository> { TournamentRepositoryImpl()}
    viewModel { MyTournamentViewModel(get()) }
    viewModel { CreateTournamentViewModel(get()) }
>>>>>>> 8323ea226b4330b19d7b92a9a9a8d6cb1a600b49
}