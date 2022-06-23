package com.example.mobileapp.presentation.tournament

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.R
import com.example.mobileapp.presentation.const.Const

class RoundFragment : Fragment(R.layout.fragment_tournament_detail) {

    companion object {
        fun newInstance(tournamentName: String?): RoundFragment {
            val args = Bundle()
            args.putString(Const.tournamentTypeName, tournamentName)

            val fragment = RoundFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name: String? = arguments?.getString(Const.tournamentTypeName)
        view.findViewById<TextView>(R.id.tv_tournament_type).text = name

        view.findViewById<Button>(R.id.btn_save).setOnClickListener {

        }
        view.findViewById<Button>(R.id.btn_finish).setOnClickListener {

        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = requireView().findViewById<RecyclerView>(R.id.rv_score_list)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val tournamentAdapter = TournamentAdapter()
        recyclerView.adapter = tournamentAdapter
        tournamentAdapter.setData()
    }
}