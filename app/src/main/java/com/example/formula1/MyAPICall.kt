package com.example.formula1

import android.util.JsonReader
import com.google.gson.Gson
import org.json.JSONObject
import org.json.JSONStringer
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

interface MyAPICall {

    @GET("current/last/results.json")
    fun getLastResult() : Call<lastRaceModelDriver>

    @GET("current/constructorStandings.json")
    fun getCurrentConstructorStandings() : Call<CurrentConstructorModel>


}