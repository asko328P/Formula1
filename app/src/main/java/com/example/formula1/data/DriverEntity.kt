package com.example.formula1.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driver_table")
data class DriverEntity(
        val id: Int,
        @PrimaryKey
        val driverId: String,
        val name: String,
        val surName: String,
        val nationality: String,
        val dateOfBirth: String,
        val permanentNumber: String,
)