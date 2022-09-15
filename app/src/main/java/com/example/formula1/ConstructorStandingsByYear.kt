package com.example.formula1

import android.app.DatePickerDialog
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class ConstructorStandingsByYear : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_constructor_standings_by_year, container, false)
        activity?.requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val yearTextView = view.findViewById<TextView>(R.id.textViewYear)
        val buttonRaiseyear = view.findViewById<Button>(R.id.buttonRaiseYear)
        val buttonLowerYear = view.findViewById<Button>(R.id.buttonLowerYear)

        var yearNumber=yearTextView.text.toString().toInt()

        var urlBase = "http://ergast.com/api/f1/"+yearTextView.text+"/"

        var recycler3 = view.findViewById<RecyclerView>(R.id.recyclerConsYear)

        var retrofit = Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var myAPICall = retrofit.create(MyAPICall::class.java)


        var resp=arrayOf(ConStanding("1", "545", ConstructorData("Red Bull")))
        var adapter2 = GridItemAdapter(resp)
        val gridLayout = GridLayoutManager(context, 2)
        recycler3.layoutManager=gridLayout
        recycler3.adapter=adapter2

        myAPICall.getConstructorStandingsByYear().enqueue(object : Callback<CurrentConstructorModel> {
            override fun onResponse(call: Call<CurrentConstructorModel>, response: Response<CurrentConstructorModel>) {
                if(response.body() != null){
                    resp = response.body()?.mrData!!.standingTable.standingsLists.get(0).constructorStandings.copyOf()
                    adapter2.setItemList(resp)
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<CurrentConstructorModel>, t: Throwable) {
                return
            }

        })


        buttonRaiseyear.setOnClickListener{
            if(yearNumber<2022) {
                yearNumber++
                yearTextView.setText(yearNumber.toString())

                urlBase = "http://ergast.com/api/f1/"+yearTextView.text+"/"

                retrofit = Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                myAPICall = retrofit.create(MyAPICall::class.java)

                myAPICall.getConstructorStandingsByYear().enqueue(object : Callback<CurrentConstructorModel> {
                    override fun onResponse(call: Call<CurrentConstructorModel>, response: Response<CurrentConstructorModel>) {
                        if(response.body() != null){
                            resp = response.body()?.mrData!!.standingTable.standingsLists.get(0).constructorStandings.copyOf()
                            adapter2.setItemList(resp)
                        }
                        else{
                            return
                        }
                    }
                    override fun onFailure(call: Call<CurrentConstructorModel>, t: Throwable) {
                        return
                    }

                })
            }
        }
        buttonLowerYear.setOnClickListener{
            if(yearNumber>1970) {
                yearNumber--
                yearTextView.setText(yearNumber.toString())

                urlBase = "http://ergast.com/api/f1/"+yearTextView.text+"/"

                retrofit = Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                myAPICall = retrofit.create(MyAPICall::class.java)

                myAPICall.getConstructorStandingsByYear().enqueue(object : Callback<CurrentConstructorModel> {
                    override fun onResponse(call: Call<CurrentConstructorModel>, response: Response<CurrentConstructorModel>) {
                        if(response.body() != null){
                            resp = response.body()?.mrData!!.standingTable.standingsLists.get(0).constructorStandings.copyOf()
                            adapter2.setItemList(resp)
                        }
                        else{
                            return
                        }
                    }
                    override fun onFailure(call: Call<CurrentConstructorModel>, t: Throwable) {
                        return
                    }

                })

            }
        }

        return view
    }

}