package com.example.ejemplonavegacioncompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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

    var textoSolucion by remember {
        mutableStateOf("")
    }

    var textoPregunta by remember {
        mutableStateOf("")
    }

    LaunchedEffect(indicePreg) {
        val preguntaActual = Preguntas.listaPreguntas[indicePreg]
        textoSolucion = ""
        preguntaActual?.let {
            textoPregunta = it.textoPregunta
        }
    }

    Column(verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {

        ButtonConFuncion(texto = "Inicio", func = {
            navController?.navigate(Rutas.PantallaHome.ruta)
        })

        Text(text = textoPregunta)
        
        //Image(painter = painterResource(id = R.drawable.), contentDescription = "")
        
        Text(text = textoSolucion)

        Column {
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                ButtonConFuncion(texto = "True", func = {
                    textoSolucion = MetodosCuest.getTextoSolucion(Preguntas.listaPreguntas[indicePreg].solucion, true)
                    Respuestas.Respuestas[indicePreg] = -1

                })

                ButtonConFuncion(texto = "False", func = {
                    textoSolucion = MetodosCuest.getTextoSolucion(Preguntas.listaPreguntas[indicePreg].solucion, false)
                    Respuestas.Respuestas[indicePreg] = -1

                })
            }

            BotonesNavegacion(funAnterior = {
                if(indicePreg > 0) {
                    indicePreg--
                } else {
                    indicePreg = Preguntas.listaPreguntas.size - 1
                }
            }, funAleatoria = {

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