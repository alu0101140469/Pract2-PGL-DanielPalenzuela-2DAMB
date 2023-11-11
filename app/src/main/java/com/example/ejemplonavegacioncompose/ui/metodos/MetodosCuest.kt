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
import com.example.ejemplonavegacioncompose.R
import com.example.ejemplonavegacioncompose.ui.objetos.Imagen
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

        fun getColorSolucion(Solucion: Boolean, opcionSeleccionada: Boolean): Color {
            return if (Solucion == opcionSeleccionada) {
                Color.Green
            } else {
                Color.Red
            }
        }

        fun getBooleanSolucion(Solucion: Boolean, opcionSeleccionada: Boolean): Boolean {
            return Solucion == opcionSeleccionada
        }

        fun llenarListaImagenes(): MutableList<Imagen> {
            val imagenes = mutableListOf<Imagen>()

            imagenes.add(Imagen(R.drawable.aguacate))
            imagenes.add(Imagen(R.drawable.tomate))
            imagenes.add(Imagen(R.drawable.pepino))
            imagenes.add(Imagen(R.drawable.pimiento))
            imagenes.add(Imagen(R.drawable.calabaza))

            return imagenes
        }

        fun llenarListaPreg(): ArrayList<Pregunta> {
            val listaPreguntas = ArrayList<Pregunta>()

            val preg1 = Pregunta().apply {
                textoPregunta = "1. ¿El aguacate es una fruta?"
                solucion = true
            }
            val preg2 = Pregunta().apply {
                textoPregunta = "2. ¿El tomate es una verdura?"
                solucion = false
            }
            val preg3 = Pregunta().apply {
                textoPregunta = "3. ¿El pepino es una verdura?"
                solucion = false
            }
            val preg4 = Pregunta().apply {
                textoPregunta = "4. ¿El pimiento es una fruta?"
                solucion = true
            }
            val preg5 = Pregunta().apply {
                textoPregunta = "5. ¿La calabaza es una verdura?"
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
            func: () -> Unit,
            colorFondo: Color = Color.Blue,
            colorTexto: Color = Color.Blue,
            icono: ImageVector? = null,
            iconoDcha: Boolean = false) {
            OutlinedButton(onClick = func,
                border = BorderStroke(1.dp, colorFondo),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = colorTexto)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    if (icono != null && !iconoDcha) {
                        Icon(imageVector = icono, contentDescription = null, tint = colorTexto)
                    }
                    Text(
                        text = texto,
                        color = colorTexto
                    )
                    if (icono != null && iconoDcha) {
                        Icon(imageVector = icono, contentDescription = null, tint = colorTexto)
                    }
                }
            }
        }

        @Composable
        fun BotonesNavegacion(
            funAnterior: () -> Unit,
            funAleatoria: () -> Unit,
            funSiguiente: () -> Unit
        ) {
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                ButtonConFuncion("Previous", funAnterior, icono = Icons.Default.ArrowBack)
                ButtonConFuncion("Random", funAleatoria)
                ButtonConFuncion("Next", funSiguiente, icono = Icons.Default.ArrowForward, iconoDcha = true)
            }
        }
    }
}