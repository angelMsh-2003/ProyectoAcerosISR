package io.devexpert.proyectoaceros.View.Apartados.Tareas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ReadTaskExisting
import io.devexpert.proyectoaceros.Funtion.CustomAlertTwoBottons
import io.devexpert.proyectoaceros.Funtion.CustomViewDialog
import io.devexpert.proyectoaceros.Funtion.DesignType
import io.devexpert.proyectoaceros.Funtion.Encabezado
import io.devexpert.proyectoaceros.Funtion.campoAsignacionTareas
import io.devexpert.proyectoaceros.Model.InfoCampo
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.TareasViewModel
import io.devexpert.proyectoaceros.other.Theme
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import proyectoacerosisr.composeapp.generated.resources.Res
import proyectoacerosisr.composeapp.generated.resources.note_menu

@Composable
fun AsignacionTareas (navController : Navigation, tareasViewModel: TareasViewModel) {
    LaunchedEffect(Unit) { tareasViewModel.loadTask() }
    val infoTask by tareasViewModel.task.collectAsState()
    var querySearch by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var infoArray by remember { mutableStateOf(arrayOf<String>()) }
    var currentDesign by remember { mutableStateOf(DesignType.DesignA) }
    var idActivity by remember { mutableStateOf(0L) }
    var actividades by remember { mutableStateOf(ReadTaskExisting(
        ActividadId = 0L,
        Descripcion = "",
        NumEmpleado = 0L,
        Area = "",
        Estado = "",
        MargenError = 0L,
        FechaInicio = "",
        FechaFin = ""
    )) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Encabezado()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
                .padding(top = 10.dp, start = 25.dp),
            horizontalArrangement = Arrangement.Start,
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
                    modifier = Modifier.fillMaxSize().background(Theme.secondaryColor),
                    tint = Color.White
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        Text(
            "Tareas pendientes",
            style = MaterialTheme.typography.headlineSmall,
            color = Theme.textColorBlack
        )
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(top = 10.dp, start = 40.dp, end = 40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    currentDesign = DesignType.DesignA
                    navController.navigateTo(AppScreen.AgregarTareas)
                },
                modifier = Modifier
                    .size(40.dp),
                enabled = (currentDesign != DesignType.DesignC &&
                        currentDesign != DesignType.DesignB),
                colors = IconButtonColors(
                    containerColor = Theme.secondaryColor,
                    contentColor = Theme.textColorWhite,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Theme.textColorWhite
                ),
            ) {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "Agregar",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {
                    currentDesign = if (currentDesign == DesignType.DesignB) {
                        DesignType.DesignA
                    } else {
                        DesignType.DesignB
                    }
                },
                modifier = Modifier
                    .size(40.dp),
                enabled = currentDesign != DesignType.DesignC,
                colors = IconButtonColors(
                    containerColor = Theme.secondaryColor,
                    contentColor = Theme.textColorWhite,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Theme.textColorWhite
                ),
            ) {
                Icon(
                    Icons.Rounded.Delete,
                    contentDescription = "Eliminar",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {
                    currentDesign = if (currentDesign == DesignType.DesignC) {
                        DesignType.DesignA
                    } else {
                        DesignType.DesignC
                    }
                },
                modifier = Modifier
                    .size(40.dp)
                    .clip(RectangleShape),
                enabled = currentDesign != DesignType.DesignB,
                colors = IconButtonColors(
                    containerColor = Theme.secondaryColor,
                    contentColor = Theme.textColorWhite,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Theme.textColorWhite

                ),
            ) {
                Icon(
                    Icons.Rounded.Edit,
                    contentDescription = "Editar",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = when (currentDesign) {
                DesignType.DesignB -> "Seleccionar tarea a eliminar"
                DesignType.DesignC -> "Seleccionar tarea para editar"
                else -> "Tareas"
            },
            style = MaterialTheme.typography.titleMedium,
            color = when (currentDesign) {
                DesignType.DesignB -> Theme.errorColor
                DesignType.DesignC -> Theme.secondaryColor
                else -> Theme.primaryColor
            },
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(infoTask) { item ->
                val infoCampo = InfoCampo(
                    id = "Id: ${item.ActividadId}",
                    tittle = item.Descripcion,
                    description = "Número de empleado: ${item.NumEmpleado}",
                    bodyLeft = "Inicio: ${item.FechaInicio}",
                    bodyRight = "Final: ${item.FechaFin}"
                )
                campoAsignacionTareas(
                    infoCampo = infoCampo,
                    icon = when (currentDesign) {
                        DesignType.DesignB -> Icons.Rounded.Delete
                        DesignType.DesignC -> Icons.Rounded.Edit
                        else -> Icons.Rounded.Info
                    },
                    color = when (currentDesign) {
                        DesignType.DesignB -> Theme.errorColor
                        DesignType.DesignC -> Theme.secondaryColor
                        else -> Theme.primaryColor
                    },
                    onDismiss = {
                        if (currentDesign == DesignType.DesignC) {
                            actividades = ReadTaskExisting(
                                ActividadId = item.ActividadId,
                                Descripcion = item.Descripcion,
                                NumEmpleado = item.NumEmpleado,
                                Area = item.Area,
                                Estado = item.Estado,
                                MargenError = item.MargenError,
                                FechaInicio = item.FechaInicio,
                                FechaFin = item.FechaFin
                            )
                            navController.navigateTo(AppScreen.EditarTarea(actividades))
                        } else {
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

                    }
                )
            }
        }

        when (currentDesign) {
            DesignType.DesignA ->
                CustomViewDialog(
                    showDialog = showDialog,
                    tittle = "Tareas",
                    infoViewAlert = infoArray,
                    fraction = 0.65f,
                    color = Theme.primaryColor,
                    icon = Icons.Default.Close,
                    bandButton = false,
                    onDismiss = { showDialog = false },
                    onDismissCancel = {},
                    onDismissOk = {}
                )

            DesignType.DesignB ->
                CustomAlertTwoBottons(
                    showDialog = showDialog,
                    onDismissCancel = { showDialog = false },
                    onDismissOk = {
                        showDialog = false
                        tareasViewModel.deleteTask(idActivity)
                    },
                    messages = "¿Deseas eliminar esta tarea?"
                )

            else -> Text("Define una alerta")
        }
    }

}


