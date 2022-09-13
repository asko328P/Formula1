package com.example.formula1

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        activity?.requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        val buttonLastRaceResults = view.findViewById<Button>(R.id.buttonLastRaceResults)
        buttonLastRaceResults.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_lastRaceResults)
        }
        return view
    }


}