package io.devexpert.proyectoaceros.View.Menu

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devexpert.proyectoaceros.Funtion.Encabezado
import io.devexpert.proyectoaceros.Funtion.MenuDrawer
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.UserViewModel
import io.devexpert.proyectoaceros.other.AppCloser
import io.devexpert.proyectoaceros.other.Theme
import org.jetbrains.compose.resources.painterResource
import proyectoacerosisr.composeapp.generated.resources.Res
import proyectoacerosisr.composeapp.generated.resources.laminas
import proyectoacerosisr.composeapp.generated.resources.soldadura
import proyectoacerosisr.composeapp.generated.resources.tubos

@Composable
fun MenuMateriales (userViewModel: UserViewModel, appCloser: AppCloser, navController: Navigation) {
    val scrollState = rememberScrollState()
    MenuDrawer (userViewModel, appCloser) {
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Theme.backgroundColorThree),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Encabezado()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(82.dp)
                    .padding(top = 10.dp, start = 15.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = { navController.navigateTo(AppScreen.MenuInicio) },
                    modifier = Modifier
                        .size(40.dp)
                ) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = "Atras",
                        modifier = Modifier.fillMaxSize().background(Theme.secondaryColor),
                        tint = Color.White
                    )
                }
            }
            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier
                        .width(170.dp)
                        .height(220.dp)
                        .padding(bottom = 10.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(150.dp)
                            .height(30.dp)
                            .background(Theme.secondaryColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Laminas",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Theme.textColorWhite
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            navController.navigateTo(AppScreen.RegistroLaminas)
                        },
                        modifier = Modifier
                            .size(150.dp)
                            .border(2.dp, Theme.secondaryColor)
                    ) {
                        Image(
                            painterResource(Res.drawable.laminas),
                            null
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .width(170.dp)
                        .height(220.dp)
                        .padding(bottom = 10.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(150.dp)
                            .height(30.dp)
                            .background(Theme.secondaryColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Soldadura",
                            style = MaterialTheme.typography.bodyMedium,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Theme.textColorWhite
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            navController.navigateTo(AppScreen.RegistroSoldadura)
                        },
                        modifier = Modifier
                            .size(150.dp)
                            .border(2.dp, Theme.secondaryColor)
                    ) {
                        Image(
                            painterResource(Res.drawable.soldadura),
                            null
                        )
                    }
                }
            }


            Row (
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp, start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Column (modifier = Modifier
                    .width(170.dp)
                    .height(220.dp)
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(150.dp)
                            .height(30.dp)
                            .background(Theme.secondaryColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Tubos",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Theme.textColorWhite
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            navController.navigateTo(AppScreen.RegistroTubos)
                        },
                        modifier = Modifier
                            .size(150.dp)
                            .border(2.dp, Theme.secondaryColor)
                    ) {
                        Image(
                            painterResource(Res.drawable.tubos),
                            null
                        )
                    }
                }
            }


        }
    }
}