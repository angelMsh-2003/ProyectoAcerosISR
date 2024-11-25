package io.devexpert.proyectoaceros.Navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/*
Es la clase que va a definir la navegacion entre pantallas, indicando cual sera la
pantalla inicial al arrancar la app, ademas esta busca manejar el cambio entre pantallas
actualizando el estado actual por el estado siguiente
* */

class Navigation {
    private val _currentScreen = MutableStateFlow<AppScreen>(AppScreen.MenuInicio)
    val currentScreen: StateFlow<AppScreen> = _currentScreen.asStateFlow()

    fun navigateTo(screen: AppScreen) {
        _currentScreen.value = screen
    }
}