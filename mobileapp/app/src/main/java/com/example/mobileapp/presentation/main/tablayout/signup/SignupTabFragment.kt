package com.example.mobileapp.presentation.main.tablayout.signup

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.mobileapp.R
import com.example.mobileapp.presentation.main.model.SignupModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignupTabFragment : Fragment(R.layout.signup_tab_fragment) {

    private val signupViewModel: SignupViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailET = view.findViewById<EditText>(R.id.et_email)
        val passwordET = view.findViewById<EditText>(R.id.et_password)
        val confirmedPasswordET = view.findViewById<EditText>(R.id.et_confirmed_password)

        view.findViewById<Button>(R.id.btn_signup).setOnClickListener {
            val login = emailET.text.toString()
            val password = passwordET.text.toString()
            val confirmedPassword = confirmedPasswordET.text.toString()

            if (login.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) return@setOnClickListener

            val modelSignup = SignupModel(login, password, confirmedPassword)

            val confirmed = checkForConfirmation(modelSignup.password, modelSignup.confirmedPassword)
            Log.i("SignupTabFragment", "is confirmed: $confirmed")
            if (confirmed) {
                signupViewModel.register(modelSignup)
            }else{
                // passwords are not the same, enter again
            }
        }
    }

    private fun checkForConfirmation(password: String, confirmedPassword: String): Boolean {
        return password == confirmedPassword
    }
}