package com.example.ejemplonavegacioncompose.ui.objetos

data class Pregunta(var textoPregunta: String, var solucion: Boolean) {
    constructor() : this("", false)
}