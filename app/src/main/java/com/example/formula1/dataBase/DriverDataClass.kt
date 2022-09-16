package com.example.formula1.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driver_table")
data class DriverDataClass (
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val surName: String,
        val nationality: String,
        val dateOfBirth: String,
        val racingNumber: String
)
