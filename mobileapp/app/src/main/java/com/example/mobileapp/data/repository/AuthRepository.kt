package com.example.mobileapp.data.repository

import android.util.Log
import com.example.mobileapp.data.LoginService
import com.example.mobileapp.data.SignupService
import com.example.mobileapp.presentation.main.model.LoginModel
import com.example.mobileapp.presentation.main.model.SignupModel

class AuthRepository : LoginService, SignupService {

    override fun login(model: LoginModel) {
        Log.i("AuthRepository", model.login)
    }

    override fun signup(model: SignupModel): String {
        return "success"
    }

}