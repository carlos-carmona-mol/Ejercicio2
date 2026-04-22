package com.example.ejercicio2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private val vm : FormViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titulo = findViewById<EditText>(R.id.inputTitulo)
        val descripcion = findViewById<EditText>(R.id.inputDescripcion)
        val categoria = findViewById<EditText>(R.id.inputCategoria)
        val prioridad = findViewById<EditText>(R.id.inputPrioridad)
        val email = findViewById<EditText>(R.id.inputEmail)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        vm.formularioValido.observe(this) {valido ->
            btnEnviar.isEnabled = valido
        }

        titulo.addTextChangedListener{
            vm.titulo.value = it.toString()
            vm.validar()
        }

        descripcion.addTextChangedListener{
            vm.descripcion.value = it.toString()
            vm.validar()
        }

        categoria.addTextChangedListener{
            vm.categoria.value = it.toString()
            vm.validar()
        }

        prioridad.addTextChangedListener{
            vm.prioridad.value = it.toString()
            vm.validar()
        }

        email.addTextChangedListener{
            vm.email.value = it.toString()
            vm.validar()
        }

        btnEnviar.setOnClickListener {
            enviarDatos()
        }
    }

    fun enviarDatos() {
        Toast.makeText(this, "Enviando Formulario.....", Toast.LENGTH_SHORT).show()
    }
}