package com.example.mobileapp.presentation.start

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.example.mobileapp.R
import com.example.mobileapp.domain.model.Player
import com.example.mobileapp.domain.model.Tournament
import com.example.mobileapp.domain.model.TournamentType
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateTournamentFragment : Fragment() {

    private lateinit var tournamentNameEt: EditText
    private lateinit var playerListEt: EditText
    private lateinit var tournamentKindS: Spinner
    private lateinit var saveBtn: Button
    private var tournament: Tournament = Tournament()
    private var tournamentTypes = listOf<TournamentType>()
    private val viewModel: CreateTournamentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.tournamentKinds.observe(this){ it ->
            val adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item,
                it.map{ item -> item.name})
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            tournamentKindS.adapter = adapter
            tournamentTypes = it
        }
        viewModel.loadTournamentKinds()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create_tournament, container, false)

        tournamentNameEt = view.findViewById(R.id.tournamentNameEt)
        playerListEt = view.findViewById(R.id.playerListEt)
        tournamentKindS = view.findViewById(R.id.tournamentKindS)
        saveBtn = view.findViewById(R.id.saveBtn)

        tournamentKindS.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tournament.tournamentTypeId = tournamentTypes?.get(position)?.id
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                tournament.tournamentTypeId = 0
            }
        }

        saveBtn.setOnClickListener {
            val playerList = playerListEt.text.split(" ", "\n")

            for(item in playerList){
                tournament.players.add(Player(0, item))
            }

            tournament.name = tournamentNameEt.text.toString()
            tournament.statusId = 1

            viewModel.addTournament(tournament)
            Toast.makeText(this.requireContext(), "Успешно сохранено!", Toast.LENGTH_SHORT)
                .show()
            hideKeyboard(this.requireActivity())
        }

        return view
    }

    private fun hideKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
    }
}