package com.example.pasarobjeto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(val nombre: String, val correo: String, val telefono:String) : Parcelable{}

