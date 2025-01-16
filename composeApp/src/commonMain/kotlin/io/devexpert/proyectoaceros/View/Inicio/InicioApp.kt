package io.devexpert.proyectoaceros.View.Inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.SelectActualUser
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.UserViewModel
import io.devexpert.proyectoaceros.other.Theme
import org.jetbrains.compose.resources.painterResource
import proyectoacerosisr.composeapp.generated.resources.Res
import proyectoacerosisr.composeapp.generated.resources.isr_logo

@Composable
fun MainInicioApp (userViewModel: UserViewModel, navController : Navigation) {
    InicioApp (userViewModel, navController)
}

@Composable
fun InicioApp (userViewModel: UserViewModel, navController : Navigation){
    val scrollState = rememberScrollState()
    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .background(Color.White)
        .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(modifier = Modifier
            .size(300.dp)
        ) {
            Image(
                painterResource(Res.drawable.isr_logo),
                contentDescription = "Logo_ISR",
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(Modifier.height(200.dp))
        OutlinedButton(
            onClick = {
                val existingUser = userViewModel.existingValidUser()
                if (existingUser) {
                    navController.navigateTo(AppScreen.MenuInicio)
                } else {
                    navController.navigateTo(AppScreen.Login)
                }
                      },
            colors = ButtonColors(
                containerColor = Theme.primaryColor,
                contentColor = Theme.textColorWhite,
                disabledContainerColor = Theme.textColorWhite,
                disabledContentColor = Theme.primaryColor,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(50.dp)
                .width(250.dp)
        ){
            Text("Iniciar Sesión", style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(Modifier.height(20.dp))
        OutlinedButton(
            onClick = {navController.navigateTo(AppScreen.ValidarRegistro)},
            colors = ButtonColors(
                containerColor = Theme.primaryColor,
                contentColor = Theme.textColorWhite,
                disabledContainerColor = Theme.textColorWhite,
                disabledContentColor = Theme.primaryColor,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(50.dp)
                .width(250.dp)
        ){
            Text("Registrarse", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
