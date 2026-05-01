package com.example.apptareas.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.apptareas.data.local.entity.TareaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTarea(tarea: TareaEntity)
    @Query("SELECT * FROM tareas WHERE id = :id")
    suspend fun obtenerTareaPorId(id: Int): TareaEntity?
    @Query("SELECT * FROM tareas ORDER BY id DESC")
    fun obtenerTareas(): Flow<List<TareaEntity>>
    @Query("SELECT * FROM tareas WHERE titulo LIKE '%' || :query || '%' OR descripcion LIKE '%' || :query || '%' ")
    fun buscarTareas(query: String): Flow<List<TareaEntity>>
    @Update
    suspend fun actualizarTarea(tarea: TareaEntity)
    @Delete
    suspend fun eliminarTarea(tarea : TareaEntity)
    @Query("DELETE FROM tareas")
    suspend fun eliminarTodasLasTareas()

}