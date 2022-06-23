package com.example.mobileapp.presentation.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class SignupModel(val login: String, val password: String, val confirmedPassword: String): Parcelable