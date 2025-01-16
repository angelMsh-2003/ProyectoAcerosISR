package io.devexpert.proyectoaceros.View.Apartados.ProcesoActividades

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.devexpert.proyectoaceros.Funtion.CustomViewDialog
import io.devexpert.proyectoaceros.Funtion.DesignType
import io.devexpert.proyectoaceros.Funtion.Encabezado
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.Funtion.campoAsignacionTareas
import io.devexpert.proyectoaceros.Model.InfoCampo
import io.devexpert.proyectoaceros.ViewModel.TareasViewModel
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun MainProcesoActividades (navController : Navigation, tareasViewModel: TareasViewModel) {
    ProcesoActividades(navController, tareasViewModel)
}

@Composable
fun ProcesoActividades (navController: Navigation, tareasViewModel: TareasViewModel) {
    LaunchedEffect(Unit) {tareasViewModel.loadTask()}
    val infoTask by tareasViewModel.task.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var infoArray by remember { mutableStateOf(arrayOf<String>()) }
    var currentDesign by remember { mutableStateOf(DesignType.DesignA) }
    var idActivity by remember { mutableStateOf(0L) }



    Column (modifier = Modifier
        .fillMaxSize()
        .background(Theme.backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Encabezado()
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(82.dp)
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { navController.navigateTo(AppScreen.MenuInicio) },
                modifier = Modifier
                    .size(40.dp)
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = "Atras",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Theme.secondaryColor),
                    tint = Color.White
                )
            }
            Text("Progreso de Actividades",
                style = MaterialTheme.typography.headlineSmall,
                color = Theme.textColorBlack
            )
        }
        LazyColumn (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ){
            items (infoTask) {item ->
                val infoCampo = InfoCampo(
                    id = "Id: ${item.ActividadId}",
                    tittle = item.Descripcion,
                    description = "Número de empleado: ${item.NumEmpleado}",
                    bodyLeft = "Inicio: ${item.FechaInicio}",
                    bodyRight = "Final: ${item.FechaFin}"
                )
                campoAsignacionTareas(
                    infoCampo = infoCampo,
                    icon = Icons.Rounded.Info,
                    color = Theme.tertiaryColor,
                    onDismiss = {
                        showDialog = true
                        idActivity = item.ActividadId
                        infoArray = arrayOf(
                            "ID: ${item.ActividadId.toString()}",
                            item.Descripcion,
                            "Num Empleado: ${item.NumEmpleado.toString()}",
                            "Area: ${item.Area}",
                            "Estado ${item.Estado}",
                            "Margen de error: ${item.MargenError.toString()}%",
                            "Fecha inico: ${item.FechaInicio}",
                            "Fecha fin: ${item.FechaFin}"
                        )
                    }
                )
            }
        }
        CustomViewDialog(
            showDialog = showDialog,
            tittle = "Proceso de actividades",
            infoViewAlert = infoArray,
            fraction = 0.75f,
            color = Theme.tertiaryColor,
            icon = Icons.Default.Close,
            bandButton = true,
            onDismiss = { showDialog = false },
            onDismissCancel = {},
            onDismissOk = {}
        )
        Spacer(Modifier.height(10.dp))


    }
}