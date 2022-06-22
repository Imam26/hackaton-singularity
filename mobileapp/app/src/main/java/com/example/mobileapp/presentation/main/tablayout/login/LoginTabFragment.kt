package com.example.mobileapp.presentation.main.tablayout.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.mobileapp.R
import com.example.mobileapp.presentation.main.model.LoginModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginTabFragment : Fragment(R.layout.login_tab_fragment) {

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextLogin = view.findViewById<EditText>(R.id.email)
        val editTextPassword = view.findViewById<EditText>(R.id.password)

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            // send model to viewModel`s function
            if (editTextLogin.text.toString().isEmpty() || editTextPassword.text.toString()
                    .isEmpty()
            ) return@setOnClickListener

            val loginModel =
                LoginModel(editTextLogin.text.toString(), editTextPassword.text.toString())

            loginViewModel.login(loginModel)
        }
    }

}