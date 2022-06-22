package com.example.mobileapp.presentation.main.tablayout.login

import androidx.lifecycle.ViewModel
import com.example.mobileapp.data.repository.AuthRepository
import com.example.mobileapp.presentation.main.model.LoginModel

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    fun login(model: LoginModel) {
        repository.login(model)
    }

}