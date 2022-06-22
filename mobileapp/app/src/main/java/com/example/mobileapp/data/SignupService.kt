package com.example.mobileapp.data

import com.example.mobileapp.presentation.main.model.SignupModel

interface SignupService {

    fun signup(model: SignupModel): String

}