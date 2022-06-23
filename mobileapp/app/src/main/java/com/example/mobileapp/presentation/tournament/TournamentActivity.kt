package com.example.mobileapp.presentation.tournament

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobileapp.R
import com.example.mobileapp.presentation.const.Const
import com.google.android.material.bottomnavigation.BottomNavigationView

class TournamentActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament)

        val tournamentTypeName: String? = intent.getStringExtra(Const.tournamentTypeName)
        
        bottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.round_menu_item -> {
                    replaceFragment(RoundFragment.newInstance(tournamentTypeName))
                    true
                }
                R.id.rating_menu_item -> {
                    replaceFragment(RatingFragment())
                    true
                }
                else -> false
            }
        }
        bottomNavigationView.selectedItemId = R.id.round_menu_item
    }

    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        if (supportFragmentManager.findFragmentById(R.id.fragment_container_view)?.javaClass == fragment.javaClass) return

        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, fragment)

        if (addToBackStack)
            transaction.addToBackStack(null)

        transaction.commit()
    }
}