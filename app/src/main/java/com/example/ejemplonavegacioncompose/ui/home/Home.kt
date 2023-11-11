package com.example.ejemplonavegacioncompose.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ejemplonavegacioncompose.ui.rutas.Rutas

@Composable
fun PantallaHome(navController : NavHostController?){
    MostrarHome(navController)
}

@Composable
fun MostrarHome(navController: NavHostController?){
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)) {

        var texto by rememberSaveable { mutableStateOf("") }

        Text("Bienvenido al cuestionario de preguntas de Daniel!")
        //CuadroTexto(texto, {texto = it}) // Final:  ¿Por qué se hace esto?

        Button(onClick = {
            navController?.navigate(Rutas.PantallaCuest.ruta)},
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically)
            {
                Icon(imageVector = Icons.Filled.Create, contentDescription = "")
                Text("Comenzar")
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CuadroTexto(texto: String, funcionLambda : (String) -> Unit){
//    OutlinedTextField(value = texto, onValueChange = funcionLambda)
//}


//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun PreviewHome(){
//    PantallaHome(navController = null)
//}