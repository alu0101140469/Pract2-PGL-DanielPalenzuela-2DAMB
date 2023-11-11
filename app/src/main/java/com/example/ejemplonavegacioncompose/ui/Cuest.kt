package com.example.ejemplonavegacioncompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.ejemplonavegacioncompose.ui.metodos.MetodosCuest
import com.example.ejemplonavegacioncompose.ui.metodos.MetodosCuest.Companion.BotonesNavegacion
import com.example.ejemplonavegacioncompose.ui.metodos.MetodosCuest.Companion.ButtonConFuncion
import com.example.ejemplonavegacioncompose.ui.metodos.MetodosCuest.Companion.getTextoSolucion
import com.example.ejemplonavegacioncompose.ui.objetos.Preguntas
import com.example.ejemplonavegacioncompose.ui.objetos.Respuestas
import com.example.ejemplonavegacioncompose.ui.rutas.Rutas

@Composable
fun PantallaCuest(navController: NavHostController?) {
    MostrarPregunta(navController)
}

@Composable
fun MostrarPregunta(navController: NavHostController?) {
    var indicePreg by remember {
        mutableIntStateOf(0)
    }

    var mostrarPreguntaRandom by remember {
        mutableStateOf(false)
    }

    var textoSolucion by remember {
        mutableStateOf("")
    }

    var textoPregunta by remember {
        mutableStateOf("")
    }

    var colorBotonFalse by remember {
        mutableStateOf(Color.Gray)
    }

    var colorBotonTrue by remember {
        mutableStateOf(Color.Gray)
    }

    var botonPresionado by remember {
        mutableStateOf("")
    }

    LaunchedEffect(indicePreg) {
        val preguntaActual = Preguntas.listaPreguntas[indicePreg]
        textoSolucion = ""
        preguntaActual?.let {
            textoPregunta = it.textoPregunta
        }
        colorBotonFalse = Color.Gray
        colorBotonTrue = Color.Gray
    }

    Column(verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {

        ButtonConFuncion(texto = "Home", func = {
            navController?.navigate(Rutas.PantallaHome.ruta)
        })

        Text(text = textoPregunta)
        
        //Image(painter = painterResource(id = R.drawable.), contentDescription = "")

        Text(
            text = textoSolucion,
            color = when (botonPresionado) {
                "True" -> colorBotonTrue
                "False" -> colorBotonFalse
                else -> Color.Gray
            }
        )

        Column {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {

                ButtonConFuncion(texto = "True", func = {
                    textoSolucion = MetodosCuest.getTextoSolucion(Preguntas.listaPreguntas[indicePreg].solucion, true)

                    colorBotonTrue = MetodosCuest.getColorSolucion(Preguntas.listaPreguntas[indicePreg].solucion, true)
                    colorBotonFalse = MetodosCuest.getColorSolucion(Preguntas.listaPreguntas[indicePreg].solucion, false)

                    botonPresionado = "True"

                    Respuestas.Respuestas[indicePreg] = -1
                }, colorFondo = colorBotonTrue, colorTexto = colorBotonTrue)

                ButtonConFuncion(texto = "False", func = {
                    textoSolucion = MetodosCuest.getTextoSolucion(Preguntas.listaPreguntas[indicePreg].solucion, false)

                    colorBotonFalse = MetodosCuest.getColorSolucion(Preguntas.listaPreguntas[indicePreg].solucion, false)
                    colorBotonTrue = MetodosCuest.getColorSolucion(Preguntas.listaPreguntas[indicePreg].solucion, true)

                    botonPresionado = "False"

                    Respuestas.Respuestas[indicePreg] = -1
                }, colorFondo = colorBotonFalse, colorTexto = colorBotonFalse)
            }

            BotonesNavegacion(funAnterior = {
                if(indicePreg > 0) {
                    indicePreg--
                } else {
                    indicePreg = Preguntas.listaPreguntas.size - 1
                }
            }, funAleatoria = {
                val randomIndice = (0 until Preguntas.listaPreguntas.size).random()
                textoPregunta = Preguntas.listaPreguntas[randomIndice].textoPregunta
                indicePreg = randomIndice
                mostrarPreguntaRandom = true
                textoSolucion = ""
                colorBotonFalse = Color.Gray
                colorBotonTrue = Color.Gray
                botonPresionado = ""
                Respuestas.Respuestas[indicePreg] = -1
            },
                funSiguiente = {
                    if(indicePreg < Preguntas.listaPreguntas.size - 1) {
                        indicePreg++
                    } else {
                        indicePreg = 0
                    }
                }
            )
        }
    }
}