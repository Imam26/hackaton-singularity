package com.example.mobileapp.presentation.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.mobileapp.R
import com.example.mobileapp.domain.model.Tournament
import com.example.mobileapp.domain.model.TournamentType
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateTournamentFragment : Fragment() {

    lateinit var tournamentNameEt: EditText
    lateinit var playerListEt: EditText
    lateinit var tournamentKindS: Spinner
    var tournament: Tournament = Tournament()
    var tournamentTypes = listOf<TournamentType>()
    private val viewModel: CreateTournamentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.tournamentKinds.observe(this){ it ->
            val adapter = ArrayAdapter<String>(this.requireContext(), android.R.layout.simple_spinner_item,
                it.map{ item -> item.name})
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            tournamentKindS.adapter = adapter
            tournamentTypes = it
        }
        viewModel.loadTournamentKinds()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create_tournament, container, false)

        tournamentKindS = view.findViewById(R.id.tournamentKindS)
        tournamentKindS.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tournament.tournamentTypeId = tournamentTypes?.get(position)?.id
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                tournament.tournamentTypeId = 0
            }

        }

        return view
    }
}