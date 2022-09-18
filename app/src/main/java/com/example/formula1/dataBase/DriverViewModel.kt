package com.example.formula1.dataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DriverViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<DriverEntity>>
    private val repository: DriverRepository

    init {
        val driverDao = DriverDatabase.getDatabase(application).driverDao()
        repository = DriverRepository(driverDao)
        readAllData = repository.readAllData
    }

    fun add(driverEntity: DriverEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(driverEntity)
        }
    }

}