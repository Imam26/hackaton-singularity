package com.example.mobileapp.presentation.tournament

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.R
import com.example.mobileapp.domain.model.Tournament
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TOURNEY_KEY = "TOURNEY_KEY"

class TournamentDetailFragment : Fragment(R.layout.fragment_tournament_detail) {

    private lateinit var bottomNavigationView: BottomNavigationView

    companion object {
        fun newInstance(tournament: Tournament): TournamentDetailFragment {
            val args = Bundle()
            args.putSerializable(TOURNEY_KEY, tournament)

            val fragment = TournamentDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tournament = arguments?.getSerializable(TOURNEY_KEY) as Tournament

        bottomNavigationView = view.findViewById(R.id.bottom_nav_view)
        hideActivitiesBtmNavigation()

        view.findViewById<Button>(R.id.btn_save).setOnClickListener {

        }
        view.findViewById<Button>(R.id.btn_finish).setOnClickListener {

        }

        setupRecyclerView()
        onBtmNavItemsClicked()
    }

    private fun hideActivitiesBtmNavigation() {
        (activity)?.findViewById<BottomNavigationView>(R.id.bottomNav)?.visibility = View.GONE
    }

    private fun setupRecyclerView() {
        val recyclerView = requireView().findViewById<RecyclerView>(R.id.rv_score_list)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val tournamentAdapter = TournamentAdapter()
        recyclerView.adapter = tournamentAdapter
        tournamentAdapter.setData()
    }

    private fun onBtmNavItemsClicked() {
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.round_menu_item -> {
                    Toast.makeText(context, "round clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.rating_menu_item -> {
                    Toast.makeText(context, "rating clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

}