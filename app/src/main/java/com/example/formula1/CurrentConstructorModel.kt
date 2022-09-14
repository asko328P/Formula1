package com.example.formula1

import com.google.gson.annotations.SerializedName

data class CurrentConstructorModel(
    @SerializedName("MRData")
    val mrData : MRdataConstructor,

)

data class MRdataConstructor (
    @SerializedName("StandingsTable")
    val standingTable : StandingsTable,
)

data class StandingsTable (
    @SerializedName("StandingsLists")
    val standingsLists : Array<Standing>,
)
data class Standing (
    @SerializedName("ConstructorStandings")
    val constructorStandings : Array<ConStanding>,
)
data class ConStanding (
    @SerializedName("position")
    val position : String,
    @SerializedName("points")
    val points : String,
    @SerializedName("Constructor")
    val constructorData : ConstructorData,
)
data class ConstructorData (
    @SerializedName("name")
    val name : String,
)