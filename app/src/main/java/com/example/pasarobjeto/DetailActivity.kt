package com.example.pasarobjeto

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val usuario = intent.getParcelableExtra<Usuario>("CLAVE_USUARIO")
        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvCorreo = findViewById<TextView>(R.id.tvCorreo)
        val tvTelefono = findViewById<TextView>(R.id.tvTelefono)

        if (usuario != null) {
            tvNombre.text = usuario.nombre
            tvCorreo.text = usuario.correo
            tvTelefono.text = usuario.telefono
        }
    }
}