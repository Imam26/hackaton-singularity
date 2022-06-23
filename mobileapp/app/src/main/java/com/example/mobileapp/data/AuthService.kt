package com.example.mobileapp.data

import com.example.mobileapp.presentation.main.model.LoginModel
import com.example.mobileapp.presentation.main.model.SignupModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("signIn")
    suspend fun login(@Body model: LoginModel): Int
    @POST("signUp")
    suspend fun signup(@Body model: SignupModel): String
}