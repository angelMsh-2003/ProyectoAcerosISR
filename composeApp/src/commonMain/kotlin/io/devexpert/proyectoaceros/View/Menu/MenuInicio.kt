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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.SelectActualUser
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.Funtion.Encabezado
import io.devexpert.proyectoaceros.Funtion.MenuDrawer
import io.devexpert.proyectoaceros.ViewModel.UserViewModel
import io.devexpert.proyectoaceros.other.AppCloser
import io.devexpert.proyectoaceros.other.Theme
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import proyectoacerosisr.composeapp.generated.resources.Res
import proyectoacerosisr.composeapp.generated.resources.herramientas
import proyectoacerosisr.composeapp.generated.resources.materiales
import proyectoacerosisr.composeapp.generated.resources.note_menu
import proyectoacerosisr.composeapp.generated.resources.progreso_actividades

@Composable
fun MainMenuInicio (navController: Navigation, appCloser: AppCloser, userViewModel: UserViewModel) {
    MenuInicio(navController, appCloser, userViewModel)
}

@Composable
fun MenuInicio (navController: Navigation, appCloser: AppCloser, userViewModel: UserViewModel) {
    val scrollState = rememberScrollState()

    MenuDrawer (userViewModel, appCloser) {
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Theme.backgroundColorTwo),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // HEADER
            Encabezado()
            // CONTENT
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 10.dp, end = 10.dp),
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
                            .background(Theme.primaryColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Asignación de Tareas",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Theme.textColorWhite
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            navController.navigateTo(AppScreen.AsignarTareas)
                        },
                        modifier = Modifier
                            .size(150.dp)
                            .border(2.dp, Theme.secondaryColor)
                    ) {
                        Image(
                            painterResource(Res.drawable.note_menu),
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
                            .background(Theme.primaryColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Progreso de Actividades",
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
                            navController.navigateTo(AppScreen.ProcesoTareas)
                        },
                        modifier = Modifier
                            .size(150.dp)
                            .border(2.dp, Theme.secondaryColor)
                    ) {
                        Image(
                            painterResource(Res.drawable.progreso_actividades),
                            null
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp, start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
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
                            .background(Theme.primaryColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Herramientas",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Theme.textColorWhite
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            navController.navigateTo(AppScreen.RegistroHerramienta)
                        },
                        modifier = Modifier
                            .size(150.dp)
                            .border(2.dp, Theme.secondaryColor)
                    ) {
                        Image(
                            painterResource(Res.drawable.herramientas),
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
                            .background(Theme.primaryColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Material",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Theme.textColorWhite
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            navController.navigateTo(AppScreen.MenuMateriales)
                        },
                        modifier = Modifier
                            .size(150.dp)
                            .border(2.dp, Theme.secondaryColor)
                    ) {
                        Image(
                            painterResource(Res.drawable.materiales),
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
                            .background(Theme.primaryColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Nuevo Empleado",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Theme.textColorWhite
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            navController.navigateTo(AppScreen.EditarEmpleado)
                        },
                        modifier = Modifier
                            .size(150.dp)
                            .border(2.dp, Theme.secondaryColor)
                    ) {
                        Icon(
                            Icons.Rounded.Person,
                            contentDescription = "Localized description",

                            tint = Theme.secondaryColor,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

