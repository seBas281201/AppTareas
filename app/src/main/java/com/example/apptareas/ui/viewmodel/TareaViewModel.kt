package com.example.apptareas.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptareas.data.local.entity.TareaEntity
import com.example.apptareas.data.local.repository.TareaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TareaViewModel @Inject constructor(
    private val repositorio: TareaRepository
) : ViewModel() {

    companion object {
        private const val TAG = "TareaViewModel"
    }

    private val _tareas = MutableStateFlow<List<TareaEntity>>(emptyList())
    val tareas: StateFlow<List<TareaEntity>> = _tareas
    private val _tareaSeleccionada = MutableStateFlow<TareaEntity?>(null)
    val tareaSeleccionada: StateFlow<TareaEntity?> = _tareaSeleccionada
    private val _query = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val tareasFiltradas: StateFlow<List<TareaEntity>> = _query
        .flatMapLatest { query ->
            if (query.isBlank()) {
                flowOf(emptyList())
            } else {
                repositorio.buscarTareas(query)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    private var tareaEliminada: TareaEntity? = null
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        viewModelScope.launch {
            try {
                repositorio.obtenerTareas().collect {
                    _tareas.value = it
                }
            } catch (e: Exception) {
                _error.value = "Error al cargar las tareas"
                Log.e(TAG, "init obtenerTareas: ${e.message}")
            }
        }
    }

    fun insertarTarea(tarea: TareaEntity) {
        viewModelScope.launch {
            try {
                repositorio.insertarTarea(tarea)
            } catch (e: Exception) {
                _error.value = "Error inesperado al insertar la tarea"
                Log.e(TAG, "insertarTarea: ${e.message}")
            }
        }
    }

    fun eliminarTarea(tarea: TareaEntity) {
        viewModelScope.launch {
            try {
                repositorio.eliminarTarea(tarea)
                tareaEliminada = tarea
            } catch (e: Exception) {
                _error.value = "Error inesperado al eliminar la tarea"
                Log.e(TAG, "eliminarTarea: ${e.message}")
            }
        }
    }

    fun actualizarTarea(tarea: TareaEntity) {
        viewModelScope.launch {
            try {
                repositorio.actualizarTarea(tarea)
            } catch (e: Exception) {
                _error.value = "Error inesperado al actualizar la tarea"
                Log.e(TAG, "actualizarTarea: ${e.message}")
            }
        }
    }

    fun obtenerTareaPorId(id: Int) {
        viewModelScope.launch {
            try {
                val tarea = repositorio.obtenerTareaPorId(id)
                _tareaSeleccionada.value = tarea
            } catch (e: Exception) {
                _error.value = "Error inesperado al obtener la tarea"
                Log.e(TAG, "obtenerTareaPorId: ${e.message}")
            }
        }
    }

    fun buscarTareas(query: String) {
        _query.value = query
    }

    fun restaurarTarea() {
        viewModelScope.launch {
            try {
                tareaEliminada?.let {
                    repositorio.insertarTarea(it)
                    tareaEliminada = null
                }

            } catch (e: Exception) {
                _error.value = "Error inesperado al restaurar la tarea"
                Log.e(TAG, "restaurarTarea: ${e.message}")
            }

        }
    }

    fun limpiarErrores() {
        _error.value = null
    }

}