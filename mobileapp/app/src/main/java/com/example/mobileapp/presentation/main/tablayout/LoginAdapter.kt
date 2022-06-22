package com.example.mobileapp.presentation.main.tablayout

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mobileapp.presentation.main.LoginActivity
import com.example.mobileapp.presentation.main.tablayout.login.LoginTabFragment
import com.example.mobileapp.presentation.main.tablayout.signup.SignupTabFragment

class LoginAdapter(loginActivity: LoginActivity) : FragmentStateAdapter(loginActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginTabFragment()
            1 -> SignupTabFragment()
            else -> LoginTabFragment()
        }
    }

    fun getPageTitle(position: Int): String{
        return when(position){
            0 -> "Login"
            else -> "Signup"
        }
    }

}