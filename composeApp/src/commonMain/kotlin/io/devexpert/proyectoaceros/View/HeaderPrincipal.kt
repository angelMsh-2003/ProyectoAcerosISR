package io.devexpert.proyectoaceros.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun Header () {
    Row (modifier = Modifier
        .fillMaxWidth()
        .background(Theme.fifthColor)
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("Aceros Inoxidables",
            style = MaterialTheme.typography.headlineMedium,
            color = Theme.textColorWhite
        )
        Icon(Icons.Rounded.AccountCircle, contentDescription = "Localized description",
            modifier = Modifier.size(40.dp),
            tint = Theme.textColorWhite
        )
    }
}