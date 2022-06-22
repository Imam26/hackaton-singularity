package com.example.mobileapp.presentation.main.tablayout.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobileapp.data.repository.AuthRepository
import com.example.mobileapp.presentation.main.model.SignupModel

class SignupViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    fun register(model: SignupModel) {
        _response.value = repository.signup(model)
    }

}