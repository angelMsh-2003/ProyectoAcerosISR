package io.devexpert.proyectoaceros.View

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun MainAsignacionTareas (navController : Navigation) {
    AsignacionTareas(navController)
}

@Composable
fun AsignacionTareas (navController : Navigation) {
    var query by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    var i by remember { mutableStateOf(1) }

    Box (modifier = Modifier.fillMaxSize().background(Theme.backgroundColor)) {
        Column (modifier = Modifier
            .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Encabezado()
            // Campo buscar y boton atras
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = { navController.navigateTo(AppScreen.MenuInicio )},
                    modifier = Modifier
                        .background(Theme.secondaryColor)
                        .size(40.dp)
                ) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = "Atras",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Spacer(Modifier.width(80.dp))
                Box (modifier = Modifier
                    .width(150.dp)
                    .fillMaxHeight()
                ) {
                    OutlinedTextField(
                        value = query,
                        onValueChange = { query = it },
                        label = { Text("Buscar") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Theme.textColorBlack) },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = Theme.secondaryColor,
                            unfocusedTextColor = Theme.secondaryColor,
                            focusedContainerColor = Theme.backgroundColor,
                            unfocusedContainerColor = Theme.backgroundColor,
                            focusedLabelColor = Theme.textColorBlack,
                            unfocusedLabelColor = Theme.textColorBlack,
                            cursorColor = Theme.secondaryColor,
                            selectionColors = TextSelectionColors(Theme.secondaryColor, Theme.secondaryColor.copy(alpha = 0.3f)),
                            focusedIndicatorColor = Theme.secondaryColor,
                            unfocusedIndicatorColor = Theme.secondaryColor,
                        )
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text("Tareas pendientes",
                style = MaterialTheme.typography.headlineSmall,
                color = Theme.textColorBlack
            )
            Spacer(Modifier.height(10.dp))
            // CONTENEDOR DE LAS TAREAS
            repeat(i) {
                campoAsignacionTareas()
            }
        }
        Box(
            modifier = Modifier
                .height(170.dp)
                .width(120.dp)
                .zIndex(1F)
                .align(Alignment.BottomEnd)
        ) {
            IconButton(
                onClick = { i++ },
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.TopCenter),
                colors = IconButtonColors(Theme.secondaryColor, Color.White, Theme.secondaryColor, Color.Black)
            ){
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "Agregar Tarea"
                )
            }
        }
    }
}

