package com.example.apptareas.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apptareas.data.local.dao.TareaDAO
import com.example.apptareas.data.local.entity.TareaEntity

@Database(
    entities = [TareaEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun tareaDao(): TareaDAO

}