package com.example.formula1

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
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
        val buttonConstructorsStandings = view.findViewById<Button>(R.id.buttonCurrentChampionship)
        buttonConstructorsStandings.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_currentConstructorsStandings)
        }
        val buttonConstructorByYear = view.findViewById<Button>(R.id.buttonConsByYear)
        buttonConstructorByYear.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_constructorStandingsByYear)
        }

        val buttonShare = view.findViewById<Button>(R.id.buttonSHare)
        buttonShare.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Download the Formula1 companion app now:")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }
        return view
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

    }


}