package io.devexpert.proyectoaceros.View.Apartados.Tareas

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
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
import io.devexpert.proyectoaceros.Funtion.CustomAlertDialog
import io.devexpert.proyectoaceros.Funtion.DatePickerModal
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.TareasViewModel
import io.devexpert.proyectoaceros.other.Theme
import io.devexpert.proyectoaceros.other.convertLongToDate

@Composable
fun AgregarTareaNueva (navController: Navigation, tareasViewModel: TareasViewModel) {
    var queryDescription by remember { mutableStateOf("") }
    var queryNumUser by remember { mutableStateOf("") }
    var queryArea by remember { mutableStateOf("") }
    var queryError by remember { mutableStateOf("") }
    var selectedDateInit by remember { mutableStateOf("") }
    var selectedDateFinish by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    var showDatePickerInit by remember { mutableStateOf(false) }
    var showDatePickerFinish by remember { mutableStateOf(false) }

    var expandedArea by remember { mutableStateOf(false) }
    var isVisibleRegular by remember { mutableStateOf(0) }
    var textAlert by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val areas : List<String> = listOf("Area Central","Ensamblaje","Oficina","Soldador","Soldadura","Soldar","Tablero A","Tablero B")

    Column (modifier = Modifier
        .padding(top = 10.dp, start = 40.dp, end = 40.dp)
        .verticalScroll(scrollState)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { navController.navigateTo(AppScreen.AsignarTareas) },
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
            Text(
                "Nueva tarea",
                style = MaterialTheme.typography.titleMedium,
                color = Theme.textColorBlack
            )
        }
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = queryDescription,
            onValueChange = { queryDescription = it },
            label = { Text("Descripcion", style = MaterialTheme.typography.bodyLarge) },
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
                selectionColors = TextSelectionColors(
                    Theme.secondaryColor,
                    Theme.secondaryColor.copy(alpha = 0.3f)
                ),

                focusedIndicatorColor = Theme.secondaryColor,
                unfocusedIndicatorColor = Theme.secondaryColor,
            ),
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryNumUser,
            onValueChange = { queryNumUser = it },
            label = {
                Text(
                    "Asignar a (Número de empleado)",
                    style = MaterialTheme.typography.bodyLarge
                )
            },
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
                selectionColors = TextSelectionColors(
                    Theme.secondaryColor,
                    Theme.secondaryColor.copy(alpha = 0.3f)
                ),

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
                onClick = { expandedArea = true },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Theme.secondaryColor),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonColors(
                    containerColor = Theme.backgroundColorThree,
                    contentColor = Theme.textColorBlack,
                    disabledContentColor = Theme.textColorBlack,
                    disabledContainerColor = Theme.backgroundColorThree
                ),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        if (queryArea == "") {
                            "Área"
                        } else {
                            queryArea
                        }, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Start
                    )
                    Icon(
                        imageVector = if (expandedArea) {
                            Icons.Default.KeyboardArrowUp
                        } else {
                            Icons.Default.KeyboardArrowDown
                        },
                        contentDescription = "FlechaUP/Down",
                        tint = Color.Black
                    )
                }
                DropdownMenu(
                    expanded = expandedArea,
                    onDismissRequest = {
                        expandedArea = false
                        isVisibleRegular = 0
                    },
                    containerColor = Theme.backgroundColor
                ) {
                    areas.forEach { area ->
                        DropdownMenuItem(
                            onClick = {
                                queryArea = area
                                expandedArea = false
                            },
                            text = { Text(area) }
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryError,
            onValueChange = { queryError = it },
            label = { Text("Error permitido en % (1-99)", style = MaterialTheme.typography.bodyLarge) },
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
                selectionColors = TextSelectionColors(
                    Theme.secondaryColor,
                    Theme.secondaryColor.copy(alpha = 0.3f)
                ),

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
        ){
            OutlinedButton(
                onClick = { showDatePickerInit = true },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Theme.secondaryColor),
                modifier = Modifier.width(200.dp),
                colors = ButtonColors(
                    containerColor = Theme.backgroundColorThree,
                    contentColor = Theme.textColorBlack,
                    disabledContentColor = Theme.textColorBlack,
                    disabledContainerColor = Theme.backgroundColorThree
                ),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        if (selectedDateInit == "") {
                            "Fecha inicio"
                        } else {
                            selectedDateInit
                        },
                        style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Start
                    )
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "FlechaUP/Down",
                        tint = Color.Black
                    )
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ){
            OutlinedButton(
                onClick = { showDatePickerFinish = true },
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Theme.secondaryColor),
                modifier = Modifier.width(200.dp),
                colors = ButtonColors(
                    containerColor = Theme.backgroundColorThree,
                    contentColor = Theme.textColorBlack,
                    disabledContentColor = Theme.textColorBlack,
                    disabledContainerColor = Theme.backgroundColorThree
                ),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        if (selectedDateFinish == "") {
                            "Fecha fin"
                        } else {
                            selectedDateFinish
                        },
                        style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Start
                    )
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "FlechaUP/Down",
                        tint = Color.Black
                     )
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
                onClick = {navController.navigateTo(AppScreen.AsignarTareas)},
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
                    val notEmptyOrSpacesRegex = ".*\\S.*".toRegex()
                    if (!queryDescription.matches(notEmptyOrSpacesRegex)||
                        !queryNumUser.matches(notEmptyOrSpacesRegex)||
                        !queryArea.matches(notEmptyOrSpacesRegex)||
                        !queryError.matches(notEmptyOrSpacesRegex)||
                        !selectedDateInit.matches(notEmptyOrSpacesRegex)||
                        !selectedDateFinish.matches(notEmptyOrSpacesRegex)
                        ) {
                        textAlert = "Llena todos los campos"
                    } else {
                        textAlert = tareasViewModel.insertActivity(
                            description = queryDescription,
                            error = queryError,
                            area = queryArea,
                            numUser = queryNumUser,
                            estado = "En proceso",
                            dateInit = selectedDateInit,
                            dateFinish = selectedDateFinish
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
                Text("Guardar", fontSize = 15.sp)
            }

        }


        if (showDatePickerInit) {
            DatePickerModal(
                onDateSelected = { date -> selectedDateInit = date },
                onDismiss = { showDatePickerInit = false }
            )
        } else if (showDatePickerFinish){
            DatePickerModal(
                onDateSelected = { date -> selectedDateFinish = date },
                onDismiss = { showDatePickerFinish = false }
            )
        }

        CustomAlertDialog(
            showDialog = showDialog,
            onDismiss = {
                showDialog = false
                navController.navigateTo(AppScreen.AsignarTareas)
            },
            "Tarea asignada",
            Theme.secondaryColor,
            icon = Icons.Default.Check
        )
    }
}
