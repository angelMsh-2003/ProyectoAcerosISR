package io.devexpert.proyectoaceros.View.Apartados.Herramienta

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.Herramienta
import io.devexpert.proyectoaceros.Funtion.CustomAlertDialog
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.HerramientaViewModel
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun EditarHerramienta (navController: Navigation, herramienta:Herramienta,herramientaViewModel: HerramientaViewModel) {
    var queryNameTool by remember { mutableStateOf("") }
    var queryCount by remember { mutableStateOf("") }
    var queryLocations by remember { mutableStateOf("") }
    var expandedUbicacion by remember { mutableStateOf(false) }
    var isVisibleRegular by remember { mutableStateOf(0) }
    var textAlert by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val areas : List<String> = listOf("Area Central","Ensamblaje","Oficina","Soldador","Soldadura","Soldar","Tablero A","Tablero B")
    val notEmptyOrSpacesRegex = ".*\\S.*".toRegex()
    val scrollState = rememberScrollState()

    Column (modifier = Modifier
        .padding(top = 10.dp, start = 40.dp, end = 40.dp)
        .verticalScroll(scrollState)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo buscar y boton atras
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(82.dp)
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { navController.navigateTo(AppScreen.RegistroHerramienta) },
                modifier = Modifier
                    .size(40.dp)
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = "Atras",
                    modifier = Modifier.fillMaxSize()
                        .background(Theme.secondaryColor),
                    tint = Color.White
                )
            }
            Text("Modificar herramientas",
                style = MaterialTheme.typography.titleMedium,
                color = Theme.textColorBlack
            )
        }
        // CONTENEDOR DE LAS HERRAMIENTAS
        Column (modifier = Modifier.fillMaxWidth().height(150.dp)) {
            Text(
                "Herramienta ha editar",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge
            )
            Text("ID: ${herramienta.HerramientaID}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text(herramienta.NombreHerramienta, modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("CANTIDAD: ${herramienta.Cantidad}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("UBICADO: ${herramienta.Ubicacion}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
        }
        OutlinedTextField(
            value = queryNameTool,
            onValueChange = {queryNameTool = it},
            label = { Text("Nombre de la herramienta", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Theme.secondaryColor,
                unfocusedTextColor = Theme.secondaryColor,

                focusedContainerColor = Theme.backgroundColorThree,
                unfocusedContainerColor = Theme.backgroundColorThree,

                focusedLabelColor = Theme.textColorBlack,
                unfocusedLabelColor = Theme.textColorBlack,

                cursorColor = Theme.secondaryColor,
                selectionColors = TextSelectionColors(Theme.secondaryColor, Theme.secondaryColor.copy(alpha = 0.3f)),

                focusedIndicatorColor = Theme.secondaryColor,
                unfocusedIndicatorColor = Theme.secondaryColor,
            ),
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryCount,
            onValueChange = {queryCount = it},
            label = { Text("Cantidad", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Theme.secondaryColor,
                unfocusedTextColor = Theme.secondaryColor,

                focusedContainerColor = Theme.backgroundColorThree,
                unfocusedContainerColor = Theme.backgroundColorThree,

                focusedLabelColor = Theme.textColorBlack,
                unfocusedLabelColor = Theme.textColorBlack,

                cursorColor = Theme.secondaryColor,
                selectionColors = TextSelectionColors(Theme.secondaryColor, Theme.secondaryColor.copy(alpha = 0.3f)),

                focusedIndicatorColor = Theme.secondaryColor,
                unfocusedIndicatorColor = Theme.secondaryColor,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )

        Spacer(Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            OutlinedButton(
                onClick = {expandedUbicacion = true},
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Theme.secondaryColor),
                modifier = Modifier.fillMaxSize(),
                colors = ButtonColors(
                    containerColor = Theme.backgroundColorThree,
                    contentColor = Theme.textColorBlack,
                    disabledContentColor = Theme.textColorBlack,
                    disabledContainerColor = Theme.backgroundColorThree
                ),
            ) {
                Row (modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(if (queryLocations==""){"Ubicación en Almacen"}else{queryLocations}, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Start)
                    Icon(
                        imageVector = if (expandedUbicacion) {
                            Icons.Default.KeyboardArrowUp
                        } else {
                            Icons.Default.KeyboardArrowDown
                        },
                        contentDescription = "FlechaUP/Down",
                        tint = Color.Black
                    )
                }
                DropdownMenu(
                    expanded = expandedUbicacion,
                    onDismissRequest = {
                        expandedUbicacion = false
                        isVisibleRegular = 0
                    },
                    containerColor = Theme.backgroundColor
                ) {
                    areas.forEach { area ->
                        DropdownMenuItem(
                            onClick = {
                                queryLocations = area
                                expandedUbicacion = false
                            },
                            text = { Text(area) }
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(if (textAlert=="Good"){""}else{textAlert}, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center, color = Theme.errorColor)
        Spacer(Modifier.height(20.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            OutlinedButton(
                onClick = {navController.navigateTo(AppScreen.RegistroHerramienta)},
                colors = ButtonColors(
                    containerColor = Theme.backgroundColorTwo,
                    contentColor = Theme.textColorBlack,
                    disabledContentColor = Theme.primaryColor,
                    disabledContainerColor = Theme.textColorWhite
                ),
                modifier = Modifier
                    .height(50.dp),
            ){
                Text("Cancelar", fontSize = 15.sp)
            }
            OutlinedButton(
                onClick = {
                    if (!queryNameTool.matches(notEmptyOrSpacesRegex) &&
                        !queryCount.matches(notEmptyOrSpacesRegex) &&
                        !queryLocations.matches(notEmptyOrSpacesRegex)) {
                        textAlert = "Aun sin modificaciones"
                    } else {
                        textAlert = herramientaViewModel.updateTool(
                            herramienta.HerramientaID,
                            if (!queryNameTool.matches(notEmptyOrSpacesRegex)) {
                                herramienta.NombreHerramienta
                            } else {
                                queryNameTool
                            },
                            if (!queryCount.matches(notEmptyOrSpacesRegex)) {
                                herramienta.Cantidad.toString()
                            } else {
                                queryCount
                            },
                            if (!queryLocations.matches(notEmptyOrSpacesRegex)) {
                                herramienta.Ubicacion
                            } else {
                                queryLocations
                            }
                        )
                        if (textAlert == "Good") {
                            showDialog = true
                        }
                    }
                },
                colors = ButtonColors(
                    containerColor = Theme.primaryColor,
                    contentColor = Theme.textColorWhite,
                    disabledContentColor = Theme.primaryColor,
                    disabledContainerColor = Theme.textColorWhite
                ),
                modifier = Modifier
                    .height(50.dp),
            ){
                Text("Modificar", fontSize = 15.sp)
            }
        }
        CustomAlertDialog(
            showDialog = showDialog,
            onDismiss = {
                showDialog = false
                navController.navigateTo(AppScreen.RegistroHerramienta)
            },
            "Herramienta modificada",
            Theme.fourthColor,
            icon = Icons.Default.Check
        )
    }
}