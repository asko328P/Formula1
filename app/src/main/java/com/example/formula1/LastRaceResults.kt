 package com.example.formula1

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.stream.JsonReader
import org.json.JSONObject
import org.json.JSONStringer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.POST
import java.util.*

 class LastRaceResults : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_last_race_results, container, false)

        var recycler = view.findViewById<RecyclerView>(R.id.recycler)

        var listOfDrivers = MutableLiveData<List<lastRaceModelDriver>>()

        val retrofit =Retrofit.Builder().
            baseUrl("http://ergast.com/api/f1/").
            addConverterFactory(GsonConverterFactory.create()).
            build()

        var myAPICall = retrofit.create(MyAPICall::class.java)



        myAPICall.getLastResult().enqueue(object: Callback<lastRaceModelDriver> {
            override fun onResponse(call: Call<lastRaceModelDriver>, response: Response<lastRaceModelDriver>) {

                if(response.body() != null){
                    var resp = response.body()
                    d("asko", resp!!.mrData.raceTable.races.get(0).results.get(0).driver.familyName)

                    var adapter = lastRaceAdapter (resp.mrData.raceTable.races.get(0).results.clone())
                    recycler.setLayoutManager(LinearLayoutManager(context))
                    recycler.adapter=adapter



                }
                else{
                    return
                }

            }

            override fun onFailure(call: Call<lastRaceModelDriver>, t: Throwable) {
                d("asko","bruh"+t.toString())
                return
            }

        })

        // Inflate the layout for this fragment


        return view



    }

 }