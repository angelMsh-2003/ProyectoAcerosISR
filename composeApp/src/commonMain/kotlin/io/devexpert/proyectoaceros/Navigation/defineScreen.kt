package io.devexpert.proyectoaceros.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.devexpert.proyectoaceros.View.FirstMainScreen
import io.devexpert.proyectoaceros.View.MainAsignacionTareas
import io.devexpert.proyectoaceros.View.MainInicioApp
import io.devexpert.proyectoaceros.View.MainLogin
import io.devexpert.proyectoaceros.View.MainMenuInicio
import io.devexpert.proyectoaceros.View.MainProcesoActividades
import io.devexpert.proyectoaceros.View.MainRegistro
import io.devexpert.proyectoaceros.View.SeconMainScreen

/*
Funcion que va asociar la direccion que se establecio en el AppScreen con la funcion (pantalla)
composable que tendra la view de dicha pantalla
* */

@Composable
fun defineMainScreen (navController:Navigation) {
    val currentScreen by navController.currentScreen.collectAsState(initial = AppScreen.InicioApp)
    when (currentScreen) {
        is AppScreen.InicioApp -> MainInicioApp(navController)
        is AppScreen.Login -> MainLogin(navController)
        is AppScreen.Registro -> MainRegistro(navController)
        is AppScreen.MenuInicio -> MainMenuInicio (navController)
        is AppScreen.AsignarTareas -> MainAsignacionTareas(navController)
        is AppScreen.ProcesoTareas -> MainProcesoActividades(navController)
        // PANTALLAS DE PRUEBA
        is AppScreen.fistScreen -> FirstMainScreen (navController)
        is AppScreen.seconScreen -> SeconMainScreen (navController)
        else -> {
            Text("Screen undefined")
        }
    }
}