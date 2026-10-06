package org.iesch.prueba1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Creo un objeto parcelizable para poder pasar los objetos de forma más sencilla
@Parcelize
data class Superheroe(
    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val poder: Float
) : Parcelable