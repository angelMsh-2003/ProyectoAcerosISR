package io.devexpert.proyectoaceros.View

import androidx.compose.material3.MaterialTheme as M3MaterialTheme
import androidx.compose.runtime.*
import io.devexpert.proyectoaceros.other.getBody.typographyTheme.AppTypographyInstance
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    M3MaterialTheme (
        typography = AppTypographyInstance
    ) {

    }
}