package io.devexpert.proyectoaceros.Navigation

/*
Es una clase que se encarga de definir una ruta para para cierta pantalla,
no necesariamente esta ligada a la pantalla creada, es solo una direccion
para tener mas centralizado el uso de pantallas
* */

sealed class AppScreen (val router: String) {
    object fistScreen : AppScreen("fistScreen_app")
    object seconScreen : AppScreen("seconScreen_app")
    object InicioApp : AppScreen ("inicio_app")
    object Registro : AppScreen ("registro_app")
    object Login : AppScreen ("login_app")
    object MenuInicio : AppScreen ("manuInicio_app")
    object AsignarTareas : AppScreen ("asignarTa_app")
    object ProcesoTareas : AppScreen ("procesoTa_app")
}