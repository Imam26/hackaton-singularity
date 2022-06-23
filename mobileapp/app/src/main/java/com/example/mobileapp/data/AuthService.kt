package com.example.mobileapp.data

import com.example.mobileapp.presentation.main.model.LoginModel
import com.example.mobileapp.presentation.main.model.SignupModel

interface AuthService {
    fun login(model: LoginModel): String
    fun signup(model: SignupModel): String
}