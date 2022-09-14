package com.example.formula1

import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class lastRaceAdapter(private val dataSet: Array<Result>) : RecyclerView.Adapter<lastRaceAdapter.ViewHolder>() {
    class ViewHolder(view: View, var driverParc: DriverParc? = null) : RecyclerView.ViewHolder(view) {
        val givenName: TextView
        val familyName: TextView
        val position: TextView
        val points: TextView


        init {
            // Define click listener for the ViewHolder's View.
            givenName = view.findViewById(R.id.textView4)
            familyName = view.findViewById(R.id.textView5)
            position = view.findViewById(R.id.textView6)
            points = view.findViewById(R.id.textView9)

            view.setOnClickListener{
                driverParc?.let {
                    val directions = LastRaceResultsDirections.actionLastRaceResultsToDriverDetailFragment2(it)
                    view.findNavController().navigate(directions)
                }
            }
        }
    }
    class ViewHolderFirstPlace(view: View) : RecyclerView.ViewHolder(view) {
        val givenName: TextView
        val familyName: TextView
        val position: TextView
        val points: TextView


        init {
            // Define click listener for the ViewHolder's View.
            givenName = view.findViewById(R.id.textView4)
            familyName = view.findViewById(R.id.textView5)
            position = view.findViewById(R.id.textView6)
            points = view.findViewById(R.id.textView9)
        }
    }
    class ViewHolderSecondPlace(view: View) : RecyclerView.ViewHolder(view) {
        val givenName: TextView
        val familyName: TextView
        val position: TextView
        val points: TextView


        init {
            // Define click listener for the ViewHolder's View.
            givenName = view.findViewById(R.id.textView4)
            familyName = view.findViewById(R.id.textView5)
            position = view.findViewById(R.id.textView6)
            points = view.findViewById(R.id.textView9)
        }
    }
    class ViewHolderThirdPlace(view: View) : RecyclerView.ViewHolder(view) {
        val givenName: TextView
        val familyName: TextView
        val position: TextView
        val points: TextView


        init {
            // Define click listener for the ViewHolder's View.
            givenName = view.findViewById(R.id.textView4)
            familyName = view.findViewById(R.id.textView5)
            position = view.findViewById(R.id.textView6)
            points = view.findViewById(R.id.textView9)
        }
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item

        if(viewType==R.layout.driver_item1){
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.driver_item1, viewGroup, false)

            return ViewHolder(view)
        }
        if(viewType==R.layout.driver_item2){
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.driver_item2, viewGroup, false)

            return ViewHolder(view)
        }
        if(viewType==R.layout.driver_item3){
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.driver_item3, viewGroup, false)

            return ViewHolder(view)
        }

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.driver_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.givenName.text = dataSet.get(position).driver.givenName
        viewHolder.familyName.text = dataSet.get(position).driver.familyName
        viewHolder.position.text = dataSet.get(position).position
        viewHolder.points.text = dataSet.get(position).points.toString()

        var tempDriverParc=DriverParc(
            dataSet.get(position).driver.givenName,
            dataSet.get(position).driver.familyName,
            dataSet.get(position).driver.driverId,
            dataSet.get(position).driver.nationality,
            dataSet.get(position).driver.url,
            dataSet.get(position).driver.dateOfBirth,
            dataSet.get(position).driver.permanentNumber
        )

        viewHolder.driverParc = tempDriverParc
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> R.layout.driver_item1
            1 -> R.layout.driver_item2
            2 -> R.layout.driver_item3
            else -> R.layout.driver_item
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}