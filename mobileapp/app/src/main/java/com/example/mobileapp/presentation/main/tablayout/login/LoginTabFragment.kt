package com.example.mobileapp.presentation.main.tablayout.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileapp.R
import com.example.mobileapp.presentation.main.contract.navigator
import com.example.mobileapp.presentation.main.model.LoginModel
import com.example.mobileapp.presentation.main.model.SignupModel
import com.example.mobileapp.presentation.start.StartActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginTabFragment : Fragment(R.layout.login_tab_fragment) {

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextLogin = view.findViewById<EditText>(R.id.email)
        val editTextPassword = view.findViewById<EditText>(R.id.password)

        navigator().listenResult(SignupModel::class.java, this){
            editTextLogin.text.clear()
            editTextLogin.text.append(it.login)
            editTextPassword.text.clear()
            editTextPassword.text.append(it.password)
        }

        loginViewModel.responseLiveData.observe(viewLifecycleOwner){
            Toast.makeText(this.requireContext(), it, Toast.LENGTH_SHORT)
                .show()

            if(it == "success"){
                val intent = Intent(context, StartActivity::class.java)
                startActivity(intent)
            }
        }

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            if (editTextLogin.text.toString().isEmpty() || editTextPassword.text.toString().isEmpty()){
                Toast.makeText(this.requireContext(), "Заполните поля", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val loginModel =
                LoginModel(editTextLogin.text.toString(), editTextPassword.text.toString())

            loginViewModel.login(loginModel)
        }
    }

}