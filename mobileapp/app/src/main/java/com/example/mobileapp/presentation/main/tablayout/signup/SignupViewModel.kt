package com.example.mobileapp.presentation.main.tablayout.signup

import androidx.lifecycle.ViewModel
import com.example.mobileapp.data.MyRepository
import com.example.mobileapp.presentation.main.model.SignupModel

class SignupViewModel(private val repository: MyRepository) : ViewModel() {

    fun register(model: SignupModel) {
        repository.signup(model)
    }

}