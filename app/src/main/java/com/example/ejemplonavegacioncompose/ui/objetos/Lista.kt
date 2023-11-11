package com.example.ejemplonavegacioncompose.ui.objetos

//import com.example.pract2PreguntasApp.ui.metodos.MetodosCuest.Companion.llenarListaImagenes
import com.example.ejemplonavegacioncompose.ui.metodos.MetodosCuest.Companion.llenarListaPreg

object Preguntas {
    var listaPreguntas: MutableList<Pregunta> = llenarListaPreg()
}

object Respuestas {
    val Respuestas = mutableMapOf<Int, Int>()
}

object Imagenes {
    //val imagenes: MutableList<Imagen> = llenarListaImagenes()
}