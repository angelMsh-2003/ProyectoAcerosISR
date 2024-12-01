package io.devexpert.proyectoaceros.View

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun MainProcesoActividades (navController : Navigation) {
    ProcesoActividades(navController)
}

@Composable
fun ProcesoActividades (navController: Navigation) {
    val scrollState = rememberScrollState()
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Theme.backgroundColor)
        .verticalScroll(scrollState),
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
            Text("Progreso de Actividades",
                style = MaterialTheme.typography.headlineSmall,
                color = Theme.textColorBlack
            )
        }
        Spacer(Modifier.height(10.dp))
        repeat(5) {
            campoAsignacionTareas()
        }
    }
}