package com.example.ejercicio2

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    val titulo = MutableLiveData("")
    val descripcion = MutableLiveData("")
    val categoria = MutableLiveData("")
    val prioridad = MutableLiveData("")
    val email = MutableLiveData("")
    val formularioValido = MutableLiveData(false)

    val enviando = MutableLiveData(false)

    fun validar() {
        val ti = titulo.value!!.length in 5..60
        val de = descripcion.value!!.length in 20..500
        val pr = prioridad.value!!.toIntOrNull() in 1..5
        val em = Patterns.EMAIL_ADDRESS.matcher(email.value!!).matches()

        formularioValido.value = ti && de && pr && em
    }
}