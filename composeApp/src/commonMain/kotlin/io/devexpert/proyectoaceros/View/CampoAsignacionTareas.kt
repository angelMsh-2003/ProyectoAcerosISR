package io.devexpert.proyectoaceros.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun campoAsignacionTareas () {
    Column (modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column (modifier = Modifier.width(350.dp).padding(top = 10.dp))  {
            HorizontalDivider(thickness = 1.dp, color = Color.Black)
            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("1", style = MaterialTheme.typography.bodyLarge)
                Text("Rolar Laminas", style = MaterialTheme.typography.bodyLarge)
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(35.dp)
                ) {
                    Icon(
                        Icons.Rounded.Info,
                        contentDescription = "Advertencia",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
            Text("Responsable: dani18", style = MaterialTheme.typography.bodyLarge)
            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Inicio: 01/10/2024", style = MaterialTheme.typography.labelLarge)
                Text("Fin: 12/10/2024", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}