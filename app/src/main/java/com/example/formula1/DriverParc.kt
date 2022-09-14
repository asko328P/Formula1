package com.example.formula1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class DriverParc(val givenName : String, val familyName : String, val driverId : String, val nationality : String,
val url : String, val dateOfBirth : String, val permanentNumber: String): Parcelable {
}