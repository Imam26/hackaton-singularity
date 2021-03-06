package com.example.mobileapp.presentation.main.tablayout.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileapp.R
import com.example.mobileapp.presentation.main.contract.navigator
import com.example.mobileapp.presentation.main.model.SignupModel
import com.example.mobileapp.presentation.start.StartActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignupTabFragment : Fragment(R.layout.signup_tab_fragment) {

    private val signupViewModel: SignupViewModel by viewModel()
    private lateinit var model: SignupModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailET = view.findViewById<EditText>(R.id.et_email)
        val passwordET = view.findViewById<EditText>(R.id.et_password)
        val confirmedPasswordET = view.findViewById<EditText>(R.id.et_confirmed_password)

        signupViewModel.response.observe(viewLifecycleOwner) {
            Toast.makeText(this.requireContext(), it, Toast.LENGTH_SHORT)
                .show()

            if (it == "success") {
                navigator().openLoginTab()
                navigator().publishResult(model)
            }
        }

        view.findViewById<Button>(R.id.btn_signup).setOnClickListener {
            val login = emailET.text.toString()
            val password = passwordET.text.toString()
            val confirmedPassword = confirmedPasswordET.text.toString()

            if (login.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()){
                Toast.makeText(this.requireContext(), "Заполните поля", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            model = SignupModel(login, password, confirmedPassword)

            val confirmed =
                checkForConfirmation(model.password, model.confirmedPassword)

            if (confirmed) {
                signupViewModel.register(model)
            } else {
                Toast.makeText(this.requireContext(), "Не совпадают пароли", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun checkForConfirmation(password: String, confirmedPassword: String): Boolean {
        return password == confirmedPassword
    }
}