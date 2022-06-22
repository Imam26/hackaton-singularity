package com.example.mobileapp.presentation.main.tablayout.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobileapp.data.MyRepository
import com.example.mobileapp.presentation.main.model.SignupModel

class SignupViewModel(private val repository: MyRepository) : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    fun register(model: SignupModel) {
        _response.value = repository.signup(model)
    }

}