package com.example.apptareas.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tareas")
data class TareaEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val titulo : String,
    val descripcion : String?,
    val fechaDeCreacion : String,
    val completada : Boolean = false
)
