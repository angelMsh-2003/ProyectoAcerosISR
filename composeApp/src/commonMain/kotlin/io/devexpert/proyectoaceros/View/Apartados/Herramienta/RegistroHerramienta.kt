package io.devexpert.proyectoaceros.View.Apartados.Herramienta

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.DecoyImplementation
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.Herramienta
import io.devexpert.proyectoaceros.Funtion.CustomAlertDialog
import io.devexpert.proyectoaceros.Funtion.CustomAlertTwoBottons
import io.devexpert.proyectoaceros.Funtion.CustomViewDialog
import io.devexpert.proyectoaceros.Funtion.DesignType
import io.devexpert.proyectoaceros.Funtion.Encabezado
import io.devexpert.proyectoaceros.Funtion.campoAsignacionTareas
import io.devexpert.proyectoaceros.Model.InfoCampo
import io.devexpert.proyectoaceros.Model.InfoViewAlert
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.HerramientaViewModel
import io.devexpert.proyectoaceros.other.Theme
import kotlinx.coroutines.joinAll
import proyectoacerosisr.composeapp.generated.resources.Res

@Composable
fun RegistroHerramienta (navigation: Navigation, herramientaViewModel: HerramientaViewModel) {
    LaunchedEffect(Unit) { herramientaViewModel.loadTools() }
    var querySearch by remember { mutableStateOf("") }
    val infoTools by herramientaViewModel.tools.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var infoArray by remember { mutableStateOf(arrayOf<String>()) }
    var currentDesign by remember { mutableStateOf(DesignType.DesignA) }
    var idTool by remember { mutableStateOf(0L) }
    var herramienta by remember { mutableStateOf(Herramienta(0L, "Ninguna", 0L, "")) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Encabezado()
        // Campo buscar y boton atras
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
                .padding(top = 10.dp, start = 25.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { navigation.navigateTo(AppScreen.MenuInicio) },
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
        Text("Registro de Herramientas",
            style = MaterialTheme.typography.headlineSmall,
            color = Theme.textColorBlack
        )
        Spacer(Modifier.height(10.dp))
        // CONTENEDOR DE LAS HERRAMIENTAS
        Row (modifier = Modifier
            .padding(top = 10.dp, start = 40.dp, end = 40.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    currentDesign = DesignType.DesignA
                    navigation.navigateTo(AppScreen.AgregarHerramienta)
                          },
                modifier = Modifier
                    .size(40.dp),
                enabled = (currentDesign != DesignType.DesignC&&currentDesign != DesignType.DesignB),
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
                DesignType.DesignB -> "Seleccionar herramienta para eliminar"
                DesignType.DesignC -> "Seleccionar herramienta para editar"
                else -> "Herramientas"
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
            items(infoTools) { item ->
                    val infoCampo = InfoCampo(
                        id = "Id: ${item.HerramientaID}",
                        tittle = item.NombreHerramienta,
                        description = "Ubicación: ${item.Ubicacion}",
                        bodyLeft = "Cantidad: ${item.Cantidad}",
                        bodyRight = ""
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
                            herramienta = Herramienta(
                                HerramientaID = item.HerramientaID,
                                NombreHerramienta = item.NombreHerramienta,
                                Cantidad = item.Cantidad,
                                Ubicacion = item.Ubicacion
                            )
                            navigation.navigateTo(AppScreen.EditarHerramienta(herramienta))
                        } else {
                            showDialog = true
                            idTool = item.HerramientaID
                            infoArray = arrayOf(
                                "Id: ${item.HerramientaID}",
                                item.NombreHerramienta,
                                "Ubicación: ${item.Ubicacion}",
                                "Cantidad: ${item.Cantidad}"
                            )
                        }
                    }
                )
            }
        }
        when (currentDesign){
            DesignType.DesignA ->
                CustomViewDialog(
                    showDialog,
                    "Herramientas",
                    infoArray,
                    0.4f,
                    Theme.primaryColor,
                    Icons.Default.Close,
                    bandButton = false,
                    onDismiss = { showDialog = false },
                    onDismissCancel = {},
                    onDismissOk = {}
                )
            DesignType.DesignB ->
                CustomAlertTwoBottons (
                    showDialog,
                    onDismissCancel = {showDialog = false},
                    onDismissOk = {
                        showDialog = false
                        herramientaViewModel.deleteTool(idTool)
                                  },
                    "¿Deseas eliminar esta herramienta?"
                )
            else -> Text("Define una alerta")
        }
    }
}
