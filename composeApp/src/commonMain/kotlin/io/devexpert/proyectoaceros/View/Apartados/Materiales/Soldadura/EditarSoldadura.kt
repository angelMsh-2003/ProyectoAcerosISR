package io.devexpert.proyectoaceros.View.Apartados.Materiales.Soldadura

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.Herramienta
import com.example.Laminas
import com.example.Soldadura
import io.devexpert.proyectoaceros.Funtion.ColorsTextFiel
import io.devexpert.proyectoaceros.Funtion.CustomAlertDialog
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.HerramientaViewModel
import io.devexpert.proyectoaceros.ViewModel.LaminasViewModel
import io.devexpert.proyectoaceros.ViewModel.SoldaduraViewModel
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun EditarSoldadura (navController: Navigation, soldadura: Soldadura, soldaduraViewModel: SoldaduraViewModel) {
    var queryNameSoldadura by remember { mutableStateOf("") }
    var queryTipo by remember { mutableStateOf("") }
    var queryCantidad  by remember { mutableStateOf("") }
    var queryProveedor by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    var expandedUbicacion by remember { mutableStateOf(false) }
    var isVisibleRegular by remember { mutableStateOf(0) }
    var textAlert by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    // val areas : List<String> = listOf("Area Central","Ensamblaje","Oficina","Soldador","Soldadura","Soldar","Tablero A","Tablero B")
    val notEmptyOrSpacesRegex = ".*\\S.*".toRegex()
    var soldaduraCambio : Soldadura

    Column (modifier = Modifier
        .padding(top = 10.dp, start = 40.dp, end = 40.dp)
        .verticalScroll(scrollState)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo buscar y boton atras
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(82.dp)
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { navController.navigateTo(AppScreen.RegistroSoldadura) },
                modifier = Modifier
                    .size(40.dp)
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = "Atras",
                    modifier = Modifier.fillMaxSize()
                        .background(Theme.secondaryColor),
                    tint = Color.White
                )
            }
            Text("Modificar Soldadura",
                style = MaterialTheme.typography.titleMedium,
                color = Theme.textColorBlack
            )
        }
        // CONTENEDOR DE LAS HERRAMIENTAS
        Column (modifier = Modifier.fillMaxWidth().height(180.dp)) {
            Text(
                "Herramienta ha editar",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge
            )
            Text("ID: ${soldadura.SoldaduraID}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text(soldadura.NombreSoldadura, modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("TIPO: ${soldadura.Tipo}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("CANTIDAD: ${soldadura.Cantidad}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("PROVEEDOR: ${soldadura.Proveedor}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)

        }

        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = queryNameSoldadura,
            onValueChange = {  queryNameSoldadura = it },
            label = { Text("Nombre de la soldadura", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel(),
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryTipo,
            onValueChange = {queryTipo = it},
            label = { Text("Tipo de soldadura", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel() ,
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryCantidad,
            onValueChange = {queryCantidad = it},
            label = { Text("Cantidad", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel() ,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryProveedor,
            onValueChange = {queryProveedor = it},
            label = { Text("Proveedor", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel() ,
            singleLine = true
        )

        Spacer(Modifier.height(20.dp))
        Text(if (textAlert=="Good"){""}else{textAlert}, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center, color = Theme.errorColor)
        Spacer(Modifier.height(20.dp))

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            OutlinedButton(
                onClick = {navController.navigateTo(AppScreen.RegistroSoldadura)},
                colors = ButtonColors(
                    containerColor = Theme.backgroundColorTwo,
                    contentColor = Theme.textColorBlack,
                    disabledContentColor = Theme.primaryColor,
                    disabledContainerColor = Theme.textColorWhite
                ),
                modifier = Modifier
                    .height(50.dp),
            ){
                Text("Cancelar", fontSize = 15.sp)
            }
            OutlinedButton(
                onClick = {
                    if (!queryNameSoldadura.matches(notEmptyOrSpacesRegex) &&
                        !queryTipo.matches(notEmptyOrSpacesRegex) &&
                        !queryCantidad.matches(notEmptyOrSpacesRegex) &&
                        !queryProveedor.matches(notEmptyOrSpacesRegex)
                    ){
                        textAlert = "Aun sin modificaciones"
                    } else {
                        try {
                            soldaduraCambio = Soldadura(
                                SoldaduraID= soldadura.SoldaduraID,
                                NombreSoldadura= if (!queryNameSoldadura.matches(notEmptyOrSpacesRegex)){soldadura.NombreSoldadura} else {queryNameSoldadura},
                                Tipo = if (!queryTipo.toString().matches(notEmptyOrSpacesRegex)) { soldadura.Tipo } else { queryTipo },
                                Cantidad = if (!queryCantidad.matches(notEmptyOrSpacesRegex)) { soldadura.Cantidad } else { queryCantidad.toLong() },
                                Proveedor = if (!queryProveedor.toString().matches(notEmptyOrSpacesRegex)) { soldadura.Proveedor } else { queryProveedor },
                            )
                            textAlert = soldaduraViewModel.updateSol(soldaduraCambio)
                            if (textAlert == "Good") {
                                showDialog = true
                            }

                        } catch (e: Exception) {
                            textAlert = "Valores invalidos"
                        }
                    }
                },
                colors = ButtonColors(
                    containerColor = Theme.primaryColor,
                    contentColor = Theme.textColorWhite,
                    disabledContentColor = Theme.primaryColor,
                    disabledContainerColor = Theme.textColorWhite
                ),
                modifier = Modifier
                    .height(50.dp),
            ){
                Text("Modificar", fontSize = 15.sp)
            }
        }
        CustomAlertDialog(
            showDialog = showDialog,
            onDismiss = {
                showDialog = false
                navController.navigateTo(AppScreen.RegistroSoldadura)
            },
            "Soldadura modificada",
            Theme.fourthColor,
            icon = Icons.Default.Check
        )
    }
}