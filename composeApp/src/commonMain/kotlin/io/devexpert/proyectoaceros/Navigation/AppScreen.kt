package io.devexpert.proyectoaceros.Navigation

import com.example.Herramienta
import com.example.Laminas
import com.example.ReadTaskExisting
import com.example.Soldadura
import com.example.Tubos

sealed class AppScreen () {
    object InicioApp : AppScreen ()
    object ValidarRegistro : AppScreen ()
    data class Registro(val userActual: Long) : AppScreen()
    object Login : AppScreen ()
    // Menu
    object MenuInicio : AppScreen ()
    object MenuMateriales : AppScreen ()
    // Asignar Tareas
    object AsignarTareas : AppScreen ()
    object AgregarTareas : AppScreen ()
    data class EditarTarea (val taskInfo: ReadTaskExisting): AppScreen()
    // Proceso de tareas
    object ProcesoTareas : AppScreen ()
    object EditarEmpleado: AppScreen()
    // herramientas
    object RegistroHerramienta: AppScreen()
    object AgregarHerramienta: AppScreen()
    data class EditarHerramienta(val herramienta: Herramienta): AppScreen()
    // Material - laminas
    object RegistroLaminas : AppScreen()
    object NuevaLamina: AppScreen ()
    data class EditarLaminas (val laminas: Laminas) : AppScreen ()
    // Material - Soldadura
    object RegistroSoldadura : AppScreen()
    object NuevaSoldadura: AppScreen ()
    data class EditarSoldadura (val soldadura: Soldadura) : AppScreen ()
    // Material - tubos
    object RegistroTubos : AppScreen()
    object NuevosTubos: AppScreen ()
    data class EditarTubos (val tubos: Tubos) : AppScreen ()
    // other
    object fistScreen : AppScreen()
    object seconScreen : AppScreen()
    object NavigationBar: AppScreen()
    object pruebaUno: AppScreen()
    object pruebaDos: AppScreen()
}