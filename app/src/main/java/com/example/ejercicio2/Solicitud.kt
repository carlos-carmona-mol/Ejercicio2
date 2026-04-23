package com.example.ejercicio2

import kotlinx.serialization.Serializable

@Serializable
data class Solicitud (
    val titulo: String,
    val descripcion: String,
    val categoria: String?,
    val prioridad: Int,
    val email: String
)