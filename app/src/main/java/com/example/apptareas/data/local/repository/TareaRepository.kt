package com.example.apptareas.data.local.repository

import com.example.apptareas.data.local.dao.TareaDAO
import com.example.apptareas.data.local.entity.TareaEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TareaRepository @Inject constructor(
    private val dao : TareaDAO
) {

    suspend fun insertarTarea(tarea : TareaEntity){
        dao.insertarTarea(tarea)
    }

    fun obtenerTareas() : Flow<List<TareaEntity>> {
        return dao.obtenerTareas()
    }

    suspend fun obtenerTareaPorId(id : Int) : TareaEntity? {
        return dao.obtenerTareaPorId(id)
    }

    fun buscarTareas(query : String) : Flow<List<TareaEntity>> {
        return dao.buscarTareas(query)
    }

    suspend fun actualizarTarea(tarea : TareaEntity){
        dao.actualizarTarea(tarea)
    }

    suspend fun eliminarTarea(tarea: TareaEntity){
        dao.eliminarTarea(tarea)
    }

    suspend fun eliminarTodasLasTareas() {
        dao.eliminarTodasLasTareas()
    }

}