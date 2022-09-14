package com.example.formula1

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrentConstructorsStandings : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_current_constructors_standings, container, false)
        activity?.requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        var recycler2 = view.findViewById<RecyclerView>(R.id.recyclerCons)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://ergast.com/api/f1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var myAPICall = retrofit.create(MyAPICall::class.java)

        myAPICall.getCurrentConstructorStandings().enqueue(object : Callback<CurrentConstructorModel> {
            override fun onResponse(call: Call<CurrentConstructorModel>, response: Response<CurrentConstructorModel>) {
                if(response.body() != null){


                    var resp = response.body()
                    Log.d("asko",resp?.mrData!!.standingTable.standingsLists.get(0).constructorStandings.copyOf().contentToString())
                    var adapter2 = GridItemAdapter(resp?.mrData!!.standingTable.standingsLists.get(0).constructorStandings.copyOf())
                    val gridLayout = GridLayoutManager(context, 2)
                    recycler2.layoutManager=gridLayout
                    recycler2.adapter=adapter2

                }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<CurrentConstructorModel>, t: Throwable) {
                return
            }

        })


        return view
    }

}