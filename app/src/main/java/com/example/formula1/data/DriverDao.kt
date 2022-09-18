package com.example.formula1.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DriverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(driver: DriverEntity)

    @Query("SELECT * FROM driver_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<DriverEntity>>
}