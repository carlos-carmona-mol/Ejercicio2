package com.example.ejercicio2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.example.ejercicio2.client.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val vm: FormViewModel by viewModels()

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

    private fun enviarDatos() {
        val solicitud = Solicitud(
            titulo = vm.titulo.value.orEmpty(),
            descripcion = vm.descripcion.value.orEmpty(),
            categoria = vm.categoria.value.orEmpty(),
            prioridad = vm.prioridad.value?.toIntOrNull() ?: 0,
            email = vm.email.value.orEmpty()
        )
        lifecycleScope.launch {
            try {
                SupabaseClient.client.postgrest["solicitudes"].insert(solicitud)
                Toast.makeText(this@MainActivity, "Enviado con éxito", Toast.LENGTH_LONG).show()
            }catch (e: Exception){
                e.printStackTrace()
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}