package io.devexpert.proyectoaceros.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.devexpert.proyectoaceros.View.Apartados.Tareas.AsignacionTareas
import io.devexpert.proyectoaceros.View.Apartados.Herramienta.AgregarHerramientaNueva
import io.devexpert.proyectoaceros.View.Apartados.Herramienta.EditarHerramienta
import io.devexpert.proyectoaceros.View.Inicio.Login
import io.devexpert.proyectoaceros.View.Inicio.MainInicioApp
import io.devexpert.proyectoaceros.View.Menu.MainMenuInicio
import io.devexpert.proyectoaceros.View.Apartados.ProcesoActividades.MainProcesoActividades
import io.devexpert.proyectoaceros.View.Apartados.NuevoEmpleado.MainEditarEmpleado
import io.devexpert.proyectoaceros.View.Apartados.Herramienta.RegistroHerramienta
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Laminas.EditarLamina
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Laminas.NuevaLamina
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Laminas.RegistroLaminasLaminas
import io.devexpert.proyectoaceros.View.Apartados.Materiales.NavigationBottonBar
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Soldadura.EditarSoldadura
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Soldadura.NuevaSoldadura
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Soldadura.RegistroSoldadura
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Tubos.EditarTubo
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Tubos.NuevoTubo
import io.devexpert.proyectoaceros.View.Apartados.Materiales.Tubos.RegistrarTubos
import io.devexpert.proyectoaceros.View.Apartados.Tareas.AgregarTareaNueva
import io.devexpert.proyectoaceros.View.Apartados.Tareas.EditarTarea
import io.devexpert.proyectoaceros.View.Inicio.Registro
import io.devexpert.proyectoaceros.View.Inicio.ValidarNumUsuario
import io.devexpert.proyectoaceros.View.Menu.MenuMateriales
import io.devexpert.proyectoaceros.ViewModel.HerramientaViewModel
import io.devexpert.proyectoaceros.ViewModel.LaminasViewModel
import io.devexpert.proyectoaceros.ViewModel.SoldaduraViewModel
import io.devexpert.proyectoaceros.ViewModel.TareasViewModel
import io.devexpert.proyectoaceros.ViewModel.TubosViewModel
import io.devexpert.proyectoaceros.ViewModel.UserViewModel
import io.devexpert.proyectoaceros.other.AppCloser

@Composable
fun defineMainScreen (navController:Navigation, userViewModel: UserViewModel, toolViewModel: HerramientaViewModel, taskViewModel: TareasViewModel, laminasViewModel: LaminasViewModel, soldaduraViewModel: SoldaduraViewModel, tubosViewModel: TubosViewModel, appCloser: AppCloser) {
    val currentScreen by navController.currentScreen.collectAsState(initial = AppScreen.InicioApp)
    val selectedItem : Int = 0

    when (val screen = currentScreen) {
        is AppScreen.InicioApp -> MainInicioApp(userViewModel, navController)
        is AppScreen.Login -> Login(navController, userViewModel)
        is AppScreen.ValidarRegistro -> ValidarNumUsuario(navController, userViewModel)
        is AppScreen.Registro -> Registro(navController, userViewModel, screen.userActual)
        // -------------MENU-----------------
        is AppScreen.MenuInicio -> MainMenuInicio (navController, appCloser, userViewModel)
        is AppScreen.MenuMateriales -> MenuMateriales (userViewModel, appCloser , navController)
        // -------------TAREAS-----------------
        is AppScreen.AsignarTareas -> AsignacionTareas(navController, taskViewModel)
        is AppScreen.AgregarTareas -> AgregarTareaNueva (navController, taskViewModel)
        is AppScreen.EditarTarea -> EditarTarea(navController, screen.taskInfo , taskViewModel)
        // -------------PROCESO TAREAS-----------------

        is AppScreen.ProcesoTareas -> MainProcesoActividades(navController, taskViewModel)
        // -------------REGISTRO HERRAMIENTA-----------------
        is AppScreen.RegistroHerramienta -> RegistroHerramienta (navController,toolViewModel,)
        is AppScreen.AgregarHerramienta -> AgregarHerramientaNueva (navController,toolViewModel)
        is AppScreen.EditarHerramienta -> EditarHerramienta (navController, screen.herramienta,toolViewModel)
        // ---- EDITAR EMPLEADO ----
        is AppScreen.EditarEmpleado -> MainEditarEmpleado(navController, userViewModel)
        // -------------MATERIALES laminas-----------------
        is AppScreen.RegistroLaminas -> RegistroLaminasLaminas (navController, laminasViewModel)
        is AppScreen.NuevaLamina -> NuevaLamina (navController, laminasViewModel)
        is AppScreen.EditarLaminas -> EditarLamina(navController, screen.laminas, laminasViewModel)
        // -------------MATERIALES soldadura-----------------
        is AppScreen.RegistroSoldadura -> RegistroSoldadura (navController, soldaduraViewModel)
        is AppScreen.NuevaSoldadura -> NuevaSoldadura (navController, soldaduraViewModel)
        is AppScreen.EditarSoldadura -> EditarSoldadura(navController, screen.soldadura, soldaduraViewModel)
        // -------------MATERIALES tubos-----------------
        is AppScreen.RegistroTubos -> RegistrarTubos (navController, tubosViewModel)
        is AppScreen.NuevosTubos -> NuevoTubo (navController, tubosViewModel)
        is AppScreen.EditarTubos -> EditarTubo(navController, screen.tubos, tubosViewModel)
        // PANTALLAS DE PRUEBA
        is AppScreen.NavigationBar -> NavigationBottonBar (navController,selectedItem)

        else -> {
            Text("Screen undefined")
        }
    }
}

