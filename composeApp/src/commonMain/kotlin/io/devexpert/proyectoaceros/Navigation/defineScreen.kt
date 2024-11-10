package io.devexpert.proyectoaceros.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.devexpert.proyectoaceros.View.FirstMainScreen
import io.devexpert.proyectoaceros.View.SeconMainScreen

/*
Funcion que va asociar la direccion que se establecio en el AppScreen con la funcion (pantalla)
composable que tendra la view de dicha pantalla
* */

@Composable
fun defineMainScreen (navController:Navigation) {
    val currentScreen by navController.currentScreen.collectAsState(initial = AppScreen.fistScreen)
    when (currentScreen) {
        is AppScreen.fistScreen -> FirstMainScreen (navController)
        is AppScreen.seconScreen -> SeconMainScreen (navController)
        else -> {
            Text("Screen undefined")
        }
    }
}