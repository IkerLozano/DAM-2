package org.iesch.prueba1.model

import androidx.annotation.StringRes
import org.iesch.prueba1.R

data class Pregunta(
    @StringRes val texto: Int,
    @StringRes val opcion1Res: Int = 0,      // opción traducible (0 = no se usa)
    @StringRes val opcion2Res: Int = 0,
    val opcion1Texto: String = "",           // opción con texto fijo
    val opcion2Texto: String = "",
    val correcta: Int                        // 1 = opcion1, 2 = opcion2
)

object Cuestionario {
    val preguntas = listOf(
        Pregunta(
            texto = R.string.p1_texto,
            opcion1Res = R.string.p1_op1,
            opcion2Res = R.string.p1_op2,
            correcta = 1
        ),
        Pregunta(
            texto = R.string.p2_texto,
            opcion1Texto = "Madrid",
            opcion2Texto = "París",
            correcta = 2
        ),
        Pregunta(
            texto = R.string.p3_texto,
            opcion1Texto = "70",
            opcion2Texto = "17",
            correcta = 1
        )
    )
}