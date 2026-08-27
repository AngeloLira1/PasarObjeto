package com.example.pasarobjeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            val nombreIngresado = findViewById<EditText>(R.id.etNombre).text.toString().trim()
            val correoIngresado= findViewById<EditText>(R.id.etCorreo).text.toString().trim()
            val telefonoIngresado= findViewById<EditText>(R.id.etTelefono).text.toString().trim()

            val objetoUsuario= Usuario(nombreIngresado,correoIngresado,telefonoIngresado)

            viewModel.usuario= objetoUsuario

            if (nombreIngresado.isEmpty()){
                // USO DE TOAST: Mensaje rápido si el campo está vacío
                Toast.makeText(
                    this, "Por favor, escribe un precio",
                    Toast.LENGTH_SHORT
                ).show()

            }
            else if(correoIngresado.isEmpty()){
                Toast.makeText(
                    this,"Por favor, escribe el correo", Toast.LENGTH_SHORT
                ).show()
            }
            else if (telefonoIngresado.isEmpty()){
                Toast.makeText(
                    this,"Por favor, escribe el telefono",Toast.LENGTH_SHORT
                ).show()
            }else{
                val intent= Intent(this,DetailActivity::class.java).apply {
                    putExtra("CLAVE_USUARIO",objetoUsuario)
                }
                startActivity(intent)

            }

        }




    }
}
