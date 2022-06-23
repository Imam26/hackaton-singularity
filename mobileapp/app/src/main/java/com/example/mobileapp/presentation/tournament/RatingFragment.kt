package com.example.mobileapp.presentation.tournament

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileapp.R

class RatingFragment : Fragment(R.layout.fragment_rating) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(context, "rating fragment", Toast.LENGTH_SHORT).show()
        //TODO: setup recyclerView

    }

}