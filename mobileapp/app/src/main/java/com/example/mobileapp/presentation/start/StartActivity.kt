package com.example.mobileapp.presentation.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileapp.R
import com.google.android.material.navigation.NavigationBarView

class StartActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: NavigationBarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        bottomNavigationView = findViewById(R.id.bottomNav)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.create -> {
                    Toast.makeText(this, "create tournaments clicked", Toast.LENGTH_SHORT).show()
                    replaceFragment(CreateTournamentFragment(), false)
                    true
                }
                R.id.tournamentList -> {
                    Toast.makeText(this, "my tournaments clicked", Toast.LENGTH_SHORT).show()
                    replaceFragment(MyTournamentFragment(), false)
                    true
                }
                else -> false
            }
        }
        bottomNavigationView.selectedItemId = R.id.tournamentList
    }

    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer)?.javaClass == fragment.javaClass) return

        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)

        if (addToBackStack)
            transaction.addToBackStack(null)

        transaction.commit()
    }

    private fun addFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, fragment)

        if (addToBackStack)
            transaction.addToBackStack(null)

        transaction.commit()
    }
}