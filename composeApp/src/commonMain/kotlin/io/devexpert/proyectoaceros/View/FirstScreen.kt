package io.devexpert.proyectoaceros.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.unit.dp
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun FirstMainScreen (navController: Navigation) {
    FirstScreen(navController)
}
@Composable
fun FirstScreen (navController: Navigation) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Theme.backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row (modifier = Modifier.background(Theme.primaryColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text("Primer Color",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorWhite)
        }
        Row (modifier = Modifier.background(Theme.secondaryColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text("Segundo Color",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorWhite)
        }
        Row (modifier = Modifier.background(Theme.tertiaryColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text("Tercer Color",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorWhite)
        }
        Row (modifier = Modifier.background(Theme.fourthColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Cuarto Color",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorWhite
            )
        }
        Row (modifier = Modifier.background(Theme.fifthColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Quinto Color",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorWhite
            )
        }
        Row (modifier = Modifier.background(Theme.errorColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Error Color",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorWhite
            )
        }
        Row (modifier = Modifier.background(Theme.backgroundColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Background Color",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorBlack
            )
        }
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            OutlinedButton(
                onClick = {navController.navigateTo(AppScreen.seconScreen)}
            ) {
                Text("Tipografia", color = Theme.textColorBlack)
            }
        }
    }
}
