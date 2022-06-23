package com.example.mobileapp.data.repository

import com.example.mobileapp.data.AuthService
import com.example.mobileapp.data.Data
import com.example.mobileapp.domain.model.User
import com.example.mobileapp.presentation.main.model.LoginModel
import com.example.mobileapp.presentation.main.model.SignupModel

class AuthRepository : AuthService {

    override fun login(model: LoginModel):String {
        if(Data.users.any{it.login == model.login && it.password == model.password}){
            return "success"
        }
        return "Неверный логин или пароль"
    }

    override fun signup(model: SignupModel): String {
        if(Data.users.any{it.login == model.login}){
            return "Пользователь уже зарегистрирован в системе"
        }
        val user = User(model.login, model.password)
        Data.users.add(0, user)
        return "success"
    }
}