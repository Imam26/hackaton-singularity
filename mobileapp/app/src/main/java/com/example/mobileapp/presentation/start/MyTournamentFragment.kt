package com.example.mobileapp.presentation.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.R
import com.example.mobileapp.presentation.adapter.TournamentStatusAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyTournamentFragment : Fragment() {

    private val viewModel: MyTournamentViewModel by viewModel()
    private lateinit var tournamentStatusAdapter: TournamentStatusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.tournamentStatuses.observe(this){
            tournamentStatusAdapter.setItems(it)
        }
        viewModel.loadTournamentStatuses()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_tournament, container, false)
        setupRecyclerView(view)
        return view
    }

    private fun setupRecyclerView(view: View){
        tournamentStatusAdapter = TournamentStatusAdapter{
            TODO()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.tournamentListRv).apply {
            adapter = tournamentStatusAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }

        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
    }
}