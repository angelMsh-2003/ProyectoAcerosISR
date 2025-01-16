package io.devexpert.proyectoaceros.View.Apartados.NuevoEmpleado

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.devexpert.proyectoaceros.Funtion.CustomAlertDialog
import io.devexpert.proyectoaceros.Model.Empleados
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.Funtion.Encabezado
import io.devexpert.proyectoaceros.ViewModel.UserViewModel
import io.devexpert.proyectoaceros.other.Notifier
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun MainEditarEmpleado (navController: Navigation, userViewModel: UserViewModel)  {
    val notifier = object : Notifier {
        override fun showMessage(message: String) {
            println(message)
        }
    }
    NuevoEmpleado(navController, userViewModel, notifier)
}

@Composable
fun EditarEmpleado (navController: Navigation,userViewModel: UserViewModel, notifier: Notifier) {
    var queryLevel by remember { mutableStateOf( "") }
    var queryUserName by remember { mutableStateOf("") }
    var queryNumUser by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .background(Theme.backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // HEADER
        Encabezado()
        // CONTENT
        Column (modifier = Modifier.fillMaxWidth().padding(start = 40.dp, end = 40.dp, top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Registra a un nuevo empleado", style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center)
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                value = queryNumUser,
                onValueChange = { queryNumUser = it },
                label = { Text("Número de trabajador", textAlign = TextAlign.Center) },
                shape = RoundedCornerShape(5.dp),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "NumUser", tint = Theme.primaryColor) },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Theme.primaryColor,
                    unfocusedTextColor = Theme.primaryColor,

                    focusedContainerColor = Theme.backgroundColorTwo,
                    unfocusedContainerColor = Theme.backgroundColorTwo,

                    focusedLabelColor = Theme.textColorBlack,
                    unfocusedLabelColor = Theme.textColorBlack,

                    cursorColor = Theme.primaryColor,
                    selectionColors = TextSelectionColors(Theme.primaryColor, Theme.primaryColor.copy(alpha = 0.3f)),

                    focusedIndicatorColor = Theme.primaryColor,
                    unfocusedIndicatorColor = Theme.primaryColor,
                ),
                singleLine = true
            )
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = queryUserName,
                onValueChange = { queryUserName = it },
                label = { Text("Nombre del usuario", textAlign = TextAlign.Center) },
                shape = RoundedCornerShape(5.dp),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "UserName", tint = Theme.primaryColor) },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Theme.primaryColor,
                    unfocusedTextColor = Theme.primaryColor,

                    focusedContainerColor = Theme.backgroundColorTwo,
                    unfocusedContainerColor = Theme.backgroundColorTwo,

                    focusedLabelColor = Theme.textColorBlack,
                    unfocusedLabelColor = Theme.textColorBlack,

                    cursorColor = Theme.primaryColor,
                    selectionColors = TextSelectionColors(Theme.primaryColor, Theme.primaryColor.copy(alpha = 0.3f)),

                    focusedIndicatorColor = Theme.primaryColor,
                    unfocusedIndicatorColor = Theme.primaryColor,
                ),
                singleLine = true
            )
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = queryLevel,
                onValueChange = { queryLevel = it },
                label = { Text("Cargo", textAlign = TextAlign.Center) },
                shape = RoundedCornerShape(5.dp),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Cargo", tint = Theme.primaryColor) },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Theme.primaryColor,
                    unfocusedTextColor = Theme.primaryColor,

                    focusedContainerColor = Theme.backgroundColorTwo,
                    unfocusedContainerColor = Theme.backgroundColorTwo,

                    focusedLabelColor = Theme.textColorBlack,
                    unfocusedLabelColor = Theme.textColorBlack,

                    cursorColor = Theme.primaryColor,
                    selectionColors = TextSelectionColors(Theme.primaryColor, Theme.primaryColor.copy(alpha = 0.3f)),

                    focusedIndicatorColor = Theme.primaryColor,
                    unfocusedIndicatorColor = Theme.primaryColor,
                ),
                singleLine = true
            )
            Spacer(Modifier.height(50.dp))
            OutlinedButton(
                onClick = {
                    //val newEmpleado = Empleados ()
                    // loginModel.insertUser()
                    //navController.navigateTo(AppScreen.Login)

                },
                colors = ButtonColors(
                    containerColor = Theme.primaryColor,
                    contentColor = Theme.textColorWhite,
                    disabledContentColor = Theme.primaryColor,
                    disabledContainerColor = Theme.backgroundColor
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(230.dp),
            ){
                Text("Registrar", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
fun NuevoEmpleado (navController: Navigation, userViewModel: UserViewModel, notifier: Notifier) {
    var queryNumUser by remember { mutableStateOf("") }
    var queryUserName by remember { mutableStateOf( "".uppercase()) }
    var queryLevel by remember { mutableStateOf( "".uppercase()) }
    var textAlert by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var showDialogError by remember { mutableStateOf(false) }
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Theme.backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // HEADER
        Encabezado()
        // CONTENT
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(82.dp)
            .padding(start = 40.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                    navController.navigateTo(AppScreen.MenuInicio)
                },
                modifier = Modifier
                    .size(40.dp)
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = "Atras",
                    modifier = Modifier
                        .background(Theme.secondaryColor)
                        .fillMaxSize(),
                    tint = Color.White
                )
            }
        }
        Column (modifier = Modifier.fillMaxWidth().padding(start = 40.dp, end = 40.dp, top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text("Registra a un nuevo empleado", style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center)
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                value = queryNumUser,
                onValueChange = { queryNumUser = it },
                label = { Text("Número de trabajador", textAlign = TextAlign.Center) },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Theme.primaryColor,
                    unfocusedTextColor = Theme.primaryColor,

                    focusedContainerColor = Theme.backgroundColorTwo,
                    unfocusedContainerColor = Theme.backgroundColorTwo,

                    focusedLabelColor = Theme.textColorBlack,
                    unfocusedLabelColor = Theme.textColorBlack,

                    cursorColor = Theme.primaryColor,
                    selectionColors = TextSelectionColors(Theme.primaryColor, Theme.primaryColor.copy(alpha = 0.3f)),

                    focusedIndicatorColor = Theme.primaryColor,
                    unfocusedIndicatorColor = Theme.primaryColor,
                ),
                singleLine = true
            )
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = queryUserName,
                onValueChange = { queryUserName = it.uppercase() },
                label = { Text("Nombre del trabajador", textAlign = TextAlign.Center) },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Theme.primaryColor,
                    unfocusedTextColor = Theme.primaryColor,

                    focusedContainerColor = Theme.backgroundColorTwo,
                    unfocusedContainerColor = Theme.backgroundColorTwo,

                    focusedLabelColor = Theme.textColorBlack,
                    unfocusedLabelColor = Theme.textColorBlack,

                    cursorColor = Theme.primaryColor,
                    selectionColors = TextSelectionColors(Theme.primaryColor, Theme.primaryColor.copy(alpha = 0.3f)),

                    focusedIndicatorColor = Theme.primaryColor,
                    unfocusedIndicatorColor = Theme.primaryColor,
                ),
                singleLine = true
            )
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = queryLevel,
                onValueChange = { queryLevel = it.uppercase() },
                label = { Text("Cargo", textAlign = TextAlign.Center) },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Theme.primaryColor,
                    unfocusedTextColor = Theme.primaryColor,

                    focusedContainerColor = Theme.backgroundColorTwo,
                    unfocusedContainerColor = Theme.backgroundColorTwo,

                    focusedLabelColor = Theme.textColorBlack,
                    unfocusedLabelColor = Theme.textColorBlack,

                    cursorColor = Theme.primaryColor,
                    selectionColors = TextSelectionColors(Theme.primaryColor, Theme.primaryColor.copy(alpha = 0.3f)),

                    focusedIndicatorColor = Theme.primaryColor,
                    unfocusedIndicatorColor = Theme.primaryColor,
                ),
                singleLine = true
            )
            Spacer(Modifier.height(20.dp))
            Text(if (textAlert == "Good" || textAlert == "UserExist"){""} else {textAlert}, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center, color = if (textAlert =="Good"){Theme.secondaryColor} else {Theme.errorColor})
            Spacer(Modifier.height(20.dp))
            OutlinedButton(
                onClick = {
                    val notEmptyOrSpacesRegex = ".*\\S.*".toRegex()
                    if (!queryNumUser.matches(notEmptyOrSpacesRegex) ||
                        !queryUserName.matches(notEmptyOrSpacesRegex) ||
                        !queryLevel.matches(notEmptyOrSpacesRegex)
                        ) {
                        textAlert = "Llena todos los campos"
                    } else if (!queryNumUser.matches("^[0-9]{7}\$".toRegex())) {
                        textAlert = "El número de empleado debe contener 7 digitos"
                    } else {
                        val newEmpleado = Empleados (queryNumUser.toLong(), queryUserName, queryLevel)
                        textAlert = userViewModel.insertUser(newEmpleado)
                        if (textAlert == "Good") {
                            showDialog = true
                            showDialogError = false
                        }
                        else if (textAlert == "UserExist") {
                            showDialog = false
                            showDialogError = true
                        }
                    }
                },
                colors = ButtonColors(
                    containerColor = Theme.primaryColor,
                    contentColor = Theme.textColorWhite,
                    disabledContentColor = Theme.primaryColor,
                    disabledContainerColor = Theme.backgroundColor
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(230.dp),
            ) {
                Text("Registrar", style = MaterialTheme.typography.bodyLarge)
            }
            CustomAlertDialog(
                showDialog = showDialog,
                onDismiss = { showDialog = false },
                "Usuario creado exitosamente",
                Theme.primaryColor,
                icon = Icons.Default.Check
            )
            CustomAlertDialog(
                showDialog = showDialogError,
                onDismiss = { showDialogError = false },
                "El usuario ya existe",
                Theme.errorColor,
                icon = Icons.Default.Warning
            )

        }
    }
}

