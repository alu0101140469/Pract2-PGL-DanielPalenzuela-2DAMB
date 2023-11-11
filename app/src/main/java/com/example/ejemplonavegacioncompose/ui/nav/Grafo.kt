package com.example.ejemplonavegacioncompose.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejemplonavegacioncompose.ui.PantallaCuest
import com.example.ejemplonavegacioncompose.ui.home.PantallaHome
import com.example.ejemplonavegacioncompose.ui.rutas.Rutas


@Composable
fun GrafoNavegacion() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.PantallaHome.ruta){
        composable(Rutas.PantallaHome.ruta) {
            PantallaHome(navController = navController)
        }

        composable(Rutas.PantallaCuest.ruta) {
            PantallaCuest(navController = navController)
        }
    }
}


