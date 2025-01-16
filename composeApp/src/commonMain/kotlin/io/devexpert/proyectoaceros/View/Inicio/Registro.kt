package io.devexpert.proyectoaceros.View.Inicio

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.devexpert.proyectoaceros.Funtion.CustomAlertDialog
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.UserViewModel
import io.devexpert.proyectoaceros.other.Theme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import proyectoacerosisr.composeapp.generated.resources.Res
import proyectoacerosisr.composeapp.generated.resources.isr_logo
import proyectoacerosisr.composeapp.generated.resources.visibility
import proyectoacerosisr.composeapp.generated.resources.visibility_off

@Composable
fun ValidarNumUsuario (navController: Navigation, loginModel: UserViewModel) {
    var queryNumUser by remember { mutableStateOf("") }
    var textAlert by remember { mutableStateOf("") }
    var showDialogError by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .background(Theme.backgroundColor)
        .padding(start = 40.dp, end = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .size(300.dp)
        ) {
            Image(
                painterResource(Res.drawable.isr_logo),
                contentDescription = "Logo_ISR",
                modifier = Modifier.fillMaxSize()
            )
        }
        Text("Ingresa tu número de usuario", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryNumUser,
            onValueChange = { queryNumUser = it },
            label = { Text("Número de usuario", textAlign = TextAlign.Center) },
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
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        Text(if (textAlert == "Good" || textAlert == "NoExistUser"){""} else {textAlert}, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center, color = if (textAlert =="Good"){Theme.secondaryColor} else {Theme.errorColor})
        Spacer(Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                textAlert = loginModel.existingUserValid(queryNumUser, navController)
                showDialogError = textAlert == "NoExistUser"
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
            Text("Validar", style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(Modifier.height(10.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("¿Ya te has registrado?", style = MaterialTheme.typography.bodyLarge, color = Theme.primaryColor)
            TextButton(
                onClick = {navController.navigateTo(AppScreen.Login)},
                colors = ButtonColors(
                    containerColor = Theme.backgroundColor,
                    contentColor = Theme.primaryColor,
                    disabledContentColor = Theme.backgroundColor,
                    disabledContainerColor = Theme.primaryColor
                ),
            ) {
                Text("Ingresa aquí.", style = MaterialTheme.typography.bodyLarge)
            }
        }
        CustomAlertDialog(
            showDialog = showDialogError,
            onDismiss = { showDialogError = false },
            "El usuario no existe",
            Theme.errorColor,
            icon = Icons.Default.Warning
        )
    }
}

@Composable
fun Registro (navController: Navigation, loginModel: UserViewModel, userActual : Long) {
    var queryMail by remember { mutableStateOf("") }
    var queryPassword by remember { mutableStateOf("") }
    var queryPasswordRepeat by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isPasswordVisibleRepeat by remember { mutableStateOf(false) }
    var textAlert by remember { mutableStateOf("") }
    var userNumInfo by remember { mutableStateOf("") }
    var userNameInfo by remember { mutableStateOf("") }
    var userLevelInfo by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val userInfo : List<String> = loginModel.readUserExisting(userActual)
    userNumInfo = userInfo[0]
    userNameInfo = userInfo[1]
    userLevelInfo = userInfo[2]

    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .background(Theme.backgroundColor)
        .padding(start = 40.dp, end = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .size(70.dp)
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = "Persona",
                modifier = Modifier.fillMaxSize(),
                tint = Theme.primaryColor
            )
        }
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally

            ) {
            Text(userNameInfo, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = Theme.primaryColor, textAlign = TextAlign.Center)
            Text(userLevelInfo, style = MaterialTheme.typography.titleMedium)
            Text(userNumInfo, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        }

        Text("¡Has tu registro!", style = MaterialTheme.typography.displaySmall)

        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryMail,
            onValueChange = { queryMail = it },
            label = { Text("Correo", textAlign = TextAlign.Center) },
            shape = RoundedCornerShape(5.dp),
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Correo", tint = Theme.primaryColor) },
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
            value = queryPassword,
            onValueChange = { queryPassword = it },
            label = { Text("Contraseña", textAlign = TextAlign.Center) },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Image(
                        painterResource(if (isPasswordVisible) Res.drawable.visibility else Res.drawable.visibility_off),
                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password"
                    )
                }
            },
            shape = RoundedCornerShape(5.dp),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Buscar", tint = Theme.primaryColor) },
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
            value = queryPasswordRepeat,
            onValueChange = { queryPasswordRepeat = it },
            label = { Text("Repetir contraseña", textAlign = TextAlign.Center) },
            visualTransformation = if (isPasswordVisibleRepeat) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisibleRepeat = !isPasswordVisibleRepeat }) {
                    Image(
                        painterResource(if (isPasswordVisibleRepeat) Res.drawable.visibility else Res.drawable.visibility_off),
                        contentDescription = if (isPasswordVisibleRepeat) "Hide password" else "Show password"
                    )
                }
            },
            shape = RoundedCornerShape(5.dp),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Buscar", tint = Theme.primaryColor) },
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
        Text(textAlert, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center, color = Theme.errorColor)
        Spacer(Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val notEmptyOrSpacesRegex = ".*\\S.*".toRegex()
                if (!queryMail.matches(notEmptyOrSpacesRegex) ||
                    !queryPassword.matches(notEmptyOrSpacesRegex) ||
                    !queryPasswordRepeat.matches(notEmptyOrSpacesRegex)
                ) {
                    textAlert = "Llena todos los campos"
                } else {
                    textAlert = loginModel.updateUser(queryMail, queryPassword, queryPasswordRepeat,1,userNumInfo, navController)
                    if (textAlert == "Good") {
                        showDialog = true
                    }
                }},
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
        CustomAlertDialog(
            showDialog = showDialog,
            onDismiss = { navController.navigateTo(AppScreen.Login) },
            "Te registraste exitosamente\nAhora inicia sesión",
            Theme.primaryColor,
            icon = Icons.Default.Check
        )
    }
}
