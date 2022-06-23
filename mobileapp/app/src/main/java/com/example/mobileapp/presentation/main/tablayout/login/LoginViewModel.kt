package com.example.mobileapp.presentation.main.tablayout.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.data.repository.AuthRepository
import com.example.mobileapp.presentation.main.model.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    val responseLiveData = MutableLiveData<String>()

    fun login(model: LoginModel) {
        viewModelScope.launch {
            responseLiveData.value = repository.login(model)
        }
    }
}