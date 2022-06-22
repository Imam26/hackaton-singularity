package com.example.mobileapp.data

import android.util.Log
import com.example.mobileapp.presentation.main.model.LoginModel
import com.example.mobileapp.presentation.main.model.SignupModel

class MyRepository : LoginService, SignupService {

    override fun login(model: LoginModel) {
        Log.i("MyRepository", model.login)
    }

    override fun signup(model: SignupModel): String {
        return "success"
    }

}