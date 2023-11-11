package com.example.ejemplonavegacioncompose.ui.metodos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.ejemplonavegacioncompose.ui.objetos.Pregunta


class MetodosCuest {
    companion object {
        fun getTextoSolucion(Solucion: Boolean, opcionSeleccionada: Boolean): String {
            return if (Solucion == opcionSeleccionada) {
                "Has acertado, la respuesta correcta era ${Solucion.toString()}"
            } else {
                "Lo siento! Has elegido ${opcionSeleccionada.toString()}, pero la respuesta correcta era ${Solucion.toString()}"
            }
        }

        fun getBooleanSolucion(Solucion: Boolean, opcionSeleccionada: Boolean): Boolean {
            return Solucion == opcionSeleccionada
        }

//        fun llenarListaImagenes(): MutableList<Imagen> {
//            val imagenes = mutableListOf<Imagen>()
//
//            imagenes.add(Imagen(R.drawable.), 10)
//            imagenes.add(Imagen(R.drawable.), 10)
//            imagenes.add(Imagen(R.drawable.), 10)
//            imagenes.add(Imagen(R.drawable.), 10)
//            imagenes.add(Imagen(R.drawable.), 10)
//
//            return imagenes
//        }

        fun llenarListaPreg(): ArrayList<Pregunta> {
            val listaPreguntas = ArrayList<Pregunta>()

            val preg1 = Pregunta().apply {
                textoPregunta = "1"
                solucion = true
            }
            val preg2 = Pregunta().apply {
                textoPregunta = "2"
                solucion = false
            }
            val preg3 = Pregunta().apply {
                textoPregunta = "3"
                solucion = false
            }
            val preg4 = Pregunta().apply {
                textoPregunta = "4"
                solucion = true
            }
            val preg5 = Pregunta().apply {
                textoPregunta = "5"
                solucion = false
            }

            listaPreguntas.add(preg1)
            listaPreguntas.add(preg2)
            listaPreguntas.add(preg3)
            listaPreguntas.add(preg4)
            listaPreguntas.add(preg5)

            return listaPreguntas
        }

        @Composable
        fun ButtonConFuncion(
            texto: String,
            funcion: () -> Unit,
            colorFondo: Color = Color.Blue,
            colorTexto: Color = Color.Black,
            icono: ImageVector? = null) {
            OutlinedButton(onClick = funcion,
                border = BorderStroke(1.dp, colorFondo),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = colorTexto)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    if (icono != null) {
                        Icon(imageVector = icono, contentDescription = null, tint = colorTexto)
                    }
                    Text(text = texto, color = colorTexto)
                }
            }
        }

        @Composable
        fun BotonesNavegacion(
            funcionAnterior: () -> Unit,
            funcionAleatoria: () -> Unit,
            funcionSiguiente: () -> Unit
        ) {
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                ButtonConFuncion("Anterior", funcionAnterior, icono = Icons.Default.ArrowBack)
                ButtonConFuncion("Aleatorio", funcionAleatoria)
                ButtonConFuncion("Siguiente", funcionSiguiente, icono = Icons.Default.ArrowForward)
            }
        }
    }
}