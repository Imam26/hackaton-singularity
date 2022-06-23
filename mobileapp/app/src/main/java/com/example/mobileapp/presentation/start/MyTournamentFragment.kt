package com.example.mobileapp.presentation.start

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.R
import com.example.mobileapp.domain.model.Tournament
import com.example.mobileapp.presentation.adapter.TournamentStatusAdapter
import com.example.mobileapp.presentation.const.Const
import com.example.mobileapp.presentation.tournament.TournamentActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyTournamentFragment : Fragment(), OnClickListener {

    private val viewModel: MyTournamentViewModel by viewModel()
    private lateinit var tournamentStatusAdapter: TournamentStatusAdapter
    private lateinit var notFoundTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.tournamentStatuses.observe(this) {
            tournamentStatusAdapter.setItems(it)
            if (it.isNotEmpty()) {
                notFoundTv.alpha = 0F
            }
        }
        viewModel.loadTournamentStatuses()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_tournament, container, false)
        setupRecyclerView(view)
        notFoundTv = view.findViewById(R.id.notFoundTv)
        notFoundTv.alpha = 1F
        return view
    }

    private fun setupRecyclerView(view: View) {
        tournamentStatusAdapter = TournamentStatusAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.tournamentListRv).apply {
            adapter = tournamentStatusAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onTournamentItemClicked(tournament: Tournament) {
        val intent = Intent(context, TournamentActivity::class.java)
        intent.putExtra(Const.tournamentTypeName, tournament.tournamentTypeName)
        startActivity(intent)
    }

}