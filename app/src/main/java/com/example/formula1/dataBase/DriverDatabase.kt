package com.example.formula1.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DriverEntity::class], version = 1, exportSchema = false)
abstract class DriverDatabase : RoomDatabase() {

    abstract fun driverDao(): DriverDao

    companion object {
        @Volatile
        private var INSTANCE: DriverDatabase? = null

        fun getDatabase(context: Context): DriverDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DriverDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}