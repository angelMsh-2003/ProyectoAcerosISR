package io.devexpert.proyectoaceros.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.other.Theme
import org.jetbrains.compose.resources.painterResource
import proyectoacerosisr.composeapp.generated.resources.Res
import proyectoacerosisr.composeapp.generated.resources.isr_logo
import proyectoacerosisr.composeapp.generated.resources.logo_isr
import proyectoacerosisr.composeapp.generated.resources.visibility
import proyectoacerosisr.composeapp.generated.resources.visibility_off

@Composable
fun MainLogin (navController : Navigation) {
    Login (navController)
}

@Composable
fun Login (navController : Navigation) {
    var queryUser by remember { mutableStateOf("") }
    var queryPassword by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Theme.backgroundColor)
        .padding(start = 40.dp, end = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .size(210.dp)
        ) {
            Image(
                painterResource(Res.drawable.isr_logo),
                contentDescription = "Imagen_Logo",
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(Modifier.height(10.dp))
        Text("¡Bienvenido!", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(40.dp))
        OutlinedTextField(
            value = queryUser,
            onValueChange = { queryUser = it },
            label = {Text("Usuario", textAlign = TextAlign.Center)},
            shape = RoundedCornerShape(5.dp),
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Usuario", tint = Theme.primaryColor) },
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
            label = {Text("Contraseña", textAlign = TextAlign.Center)},
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
        Spacer(Modifier.height(50.dp))
        OutlinedButton(
            onClick = {navController.navigateTo(AppScreen.MenuInicio)},
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
            Text("Iniciar Sesión", style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(Modifier.height(20.dp))
        Text("¿No tienes cuenta?", style = MaterialTheme.typography.labelLarge, color = Theme.primaryColor)
        Spacer(Modifier.height(3.dp))
        OutlinedButton(
            onClick = {navController.navigateTo(AppScreen.Registro)},
            colors = ButtonColors(
                containerColor = Theme.backgroundColor,
                contentColor = Theme.textColorBlue,
                disabledContentColor = Theme.backgroundColor,
                disabledContainerColor = Theme.textColorBlue
            ),
            modifier = Modifier
                .height(50.dp),
        ){
            Text("Crear cuenta", fontSize = 15.sp)
        }
    }
}