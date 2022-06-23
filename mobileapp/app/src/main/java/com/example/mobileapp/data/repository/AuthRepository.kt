package com.example.mobileapp.data.repository

import com.example.mobileapp.data.AuthService
import com.example.mobileapp.data.Data
import com.example.mobileapp.domain.model.User
import com.example.mobileapp.presentation.main.model.LoginModel
import com.example.mobileapp.presentation.main.model.SignupModel
import retrofit2.Retrofit

class AuthRepository(private val retrofit: Retrofit) {

    val service = retrofit.create(AuthService::class.java)

    suspend fun login(model: LoginModel):String {
        val userId = service.login(model)
        return if(userId == 0){
            "Неверный логин или пароль"
        } else {
            Data.currentUser = User(userId, model.login, model.password)
            "success"
        }
        /*if(Data.users.any{it.login == model.login && it.password == model.password}){
            val user = Data.users.find{it.login == model.login && it.password == model.password}
            Data.currentUser = User(user!!.id, user.login, user.password)
            return "success"
        }
        return "Неверный логин или пароль"*/
    }

    fun signup(model: SignupModel): String {
        if(Data.users.any{it.login == model.login}){
            return "Пользователь уже зарегистрирован в системе"
        }

        Data.currentUser = User(Data.users.size + 1, model.login, model.password)
        Data.users.add(0, Data.currentUser!!)
        return "success"
    }
}