package com.example.formula1.data

import androidx.lifecycle.LiveData

class DriverRepository(private val driverDao: DriverDao){
    val readAllData: LiveData<List<DriverEntity>> = driverDao.readAllData()

    suspend fun add(driverEntity: DriverEntity){
        driverDao.add(driverEntity)
    }
}