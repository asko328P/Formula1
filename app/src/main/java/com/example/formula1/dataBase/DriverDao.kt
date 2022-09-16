package com.example.formula1.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DriverDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDriver(driver: DriverDataClass)

    @Query("SELECT * FROM driver_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<DriverDataClass>>
}