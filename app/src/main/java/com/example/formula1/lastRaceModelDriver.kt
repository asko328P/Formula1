package com.example.formula1


import com.google.gson.annotations.SerializedName

data class lastRaceModelDriver (
    @SerializedName("MRData")
    val mrData : MRdata,


)
data class MRdata (
    @SerializedName("RaceTable")
    val raceTable : RaceTable,
    @SerializedName("series")
    val series : String,
)
data class RaceTable (
    @SerializedName("Races")
    val races : Array<Race>,
)

data class Race (
    @SerializedName("Results")
    val results : Array<Result>,
    @SerializedName("raceName")
    val raceName : String,
)

data class Result (
    @SerializedName("position")
    val position : String,
    @SerializedName("points")
    val points : Int,
    @SerializedName("Driver")
    val driver : Driver

)

data class Driver (
    @SerializedName("givenName")
    val givenName : String,
    @SerializedName("familyName")
    val familyName : String,
    @SerializedName("driverId")
    val driverId : String,
    @SerializedName("nationality")
    val nationality : String,
    @SerializedName("url")
    val url : String,
    @SerializedName("dateOfBirth")
    val dateOfBirth : String,
    @SerializedName("permanentNumber")
    val permanentNumber : String,

)