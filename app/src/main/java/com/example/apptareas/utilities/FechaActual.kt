package com.example.apptareas.utilities

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun obtenerFechaActual() : String{
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date())
}