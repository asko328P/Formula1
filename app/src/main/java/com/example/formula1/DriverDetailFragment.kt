package com.example.formula1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import org.w3c.dom.Text

class DriverDetailFragment : Fragment() {

    private val args: DriverDetailFragmentArgs by navArgs()
    private lateinit var driver: DriverParc

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_driver_detail, container, false)

        driver = args.driverParc

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nekiTextView = view.findViewById<TextView>(R.id.textView18)
        nekiTextView.setText(driver.givenName)

    }

}