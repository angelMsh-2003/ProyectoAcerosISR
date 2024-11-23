package io.devexpert.proyectoaceros.View

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun MainMenuInicio (navController: Navigation) {
    MenuInicio(navController)
}

@Composable
fun MenuInicio (navController: Navigation) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Theme.backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // HEADER
        Header()
        // CONTENT
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Column (modifier = Modifier.width(170.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .width(150.dp)
                        .height(30.dp)
                        .background(Theme.primaryColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Asignación de Tareas",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Theme.textColorWhite
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        navController.navigateTo(AppScreen.fistScreen)
                    },
                    modifier = Modifier
                        .size(150.dp)
                        .border(3.dp, Theme.secondaryColor)
                ) {
                    Icon(
                        Icons.Rounded.AddCircle,
                        contentDescription = "Localized description",
                        tint = Theme.secondaryColor,
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }
            Spacer(Modifier.width(10.dp ))
            Column (modifier = Modifier.width(170.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .width(150.dp)
                        .height(30.dp)
                        .background(Theme.primaryColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Progreso de Actividades",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Theme.textColorWhite
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        // Acción al hacer clic
                    },
                    modifier = Modifier
                        .size(150.dp)
                        .border(3.dp, Theme.secondaryColor)
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = "Localized description",
                        tint = Theme.secondaryColor,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Column (modifier = Modifier.width(170.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .width(150.dp)
                        .height(30.dp)
                        .background(Theme.primaryColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Herramientas",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Theme.textColorWhite
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        // Acción al hacer clic
                    },
                    modifier = Modifier
                        .size(150.dp)
                        .border(3.dp, Theme.secondaryColor)
                ) {
                    Icon(
                        Icons.Rounded.Settings,
                        contentDescription = "Localized description",
                        tint = Theme.secondaryColor,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Spacer(Modifier.width(10.dp))
            Column (modifier = Modifier.width(170.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .width(150.dp)
                        .height(30.dp)
                        .background(Theme.primaryColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Material",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Theme.textColorWhite
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        // Acción al hacer clic
                    },
                    modifier = Modifier
                        .size(150.dp)
                        .border(3.dp, Theme.secondaryColor)
                ) {
                    Icon(
                        Icons.Rounded.Send,
                        contentDescription = "Localized description",
                        tint = Theme.secondaryColor,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

