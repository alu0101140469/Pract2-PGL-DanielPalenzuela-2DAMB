package com.example.ejemplonavegacioncompose.ui.objetos

import com.example.ejemplonavegacioncompose.ui.metodos.MetodosCuest
import com.example.ejemplonavegacioncompose.ui.metodos.MetodosCuest.Companion.llenarListaPreg

object Preguntas {
    var listaPreguntas: MutableList<Pregunta> = llenarListaPreg()
}

object Respuestas {
    val Respuestas = mutableMapOf<Int, Int>()
}

object Imagenes {
    val listaImagenes = MetodosCuest.llenarListaImagenes()
}