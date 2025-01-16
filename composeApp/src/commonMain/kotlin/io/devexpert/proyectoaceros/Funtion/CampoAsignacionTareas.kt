package io.devexpert.proyectoaceros.Funtion

import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.devexpert.proyectoaceros.Model.InfoCampo
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun campoAsignacionTareas (infoCampo: InfoCampo, icon: ImageVector, color:Color,onDismiss: () -> Unit){
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
                Text(infoCampo.id, style = MaterialTheme.typography.bodyLarge)
                Text(infoCampo.tittle, style = MaterialTheme.typography.titleMedium, color = color, textAlign = TextAlign.Center)
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .size(35.dp)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "icon",
                        modifier = Modifier.fillMaxSize(),
                        tint = color
                    )
                }
            }
            Text(infoCampo.description, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(infoCampo.bodyLeft, style = MaterialTheme.typography.labelLarge)
                Text(infoCampo.bodyRight, style = MaterialTheme.typography.labelLarge)
            }
        }
    }

}