package io.devexpert.proyectoaceros.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun SeconMainScreen (navController : Navigation) {
    SeconScreen(navController)
}
@Composable
fun SeconScreen (navController : Navigation) {
    Column (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(Modifier.height(40.dp))
        Text("Texto Titulo (Type: Poppins)",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp
        )
        Spacer(Modifier.height(20.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("(Type: Nunito Sans) \n Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(30.dp),
            )
        }
        Row (modifier = Modifier.background(Theme.fifthColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Primer color de texto",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorWhite,
                fontWeight = FontWeight.Bold
            )
        }
        Row (modifier = Modifier.background(Theme.backgroundColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Segundo color de texto",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorBlue,
                fontWeight = FontWeight.Bold
            )
        }
        Row (modifier = Modifier.background(Theme.backgroundColor).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Tercer color de texto",
                modifier = Modifier.padding(30.dp),
                color = Theme.textColorBlack,
                fontWeight = FontWeight.Bold
            )
        }
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            OutlinedButton(
                onClick = {navController.navigateTo(AppScreen.fistScreen)}
            ) {
                Text("Colores", color = Theme.textColorBlue)
            }
        }
    }

}