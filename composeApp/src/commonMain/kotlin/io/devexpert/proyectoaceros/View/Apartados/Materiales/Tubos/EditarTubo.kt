package io.devexpert.proyectoaceros.View.Apartados.Materiales.Tubos

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
import com.example.Tubos
import io.devexpert.proyectoaceros.Funtion.ColorsTextFiel
import io.devexpert.proyectoaceros.Funtion.CustomAlertDialog
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.ViewModel.HerramientaViewModel
import io.devexpert.proyectoaceros.ViewModel.LaminasViewModel
import io.devexpert.proyectoaceros.ViewModel.TubosViewModel
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun EditarTubo (navController: Navigation, tubos: Tubos , tubosViewModel: TubosViewModel) {
    var queryMaterial by remember { mutableStateOf("") }
    var queryCalibre by remember { mutableStateOf("") }
    var queryTipo by remember { mutableStateOf("") }
    var queryForma by remember { mutableStateOf("") }
    var queryCantidad by remember { mutableStateOf("") }
    var queryAcabado by remember { mutableStateOf("") }
    var queryMedida by remember { mutableStateOf("") }
    var queryProveedor by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()


    var expandedUbicacion by remember { mutableStateOf(false) }
    var isVisibleRegular by remember { mutableStateOf(0) }
    var textAlert by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    // val areas : List<String> = listOf("Area Central","Ensamblaje","Oficina","Soldador","Soldadura","Soldar","Tablero A","Tablero B")
    val notEmptyOrSpacesRegex = ".*\\S.*".toRegex()
    var tubosCambio : Tubos

    Column (modifier = Modifier
        .padding(top = 10.dp, start = 40.dp, end = 40.dp)
        .fillMaxWidth()
        .verticalScroll(scrollState),
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
                onClick = { navController.navigateTo(AppScreen.RegistroTubos) },
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
            Text("Modificar Tubos",
                style = MaterialTheme.typography.titleMedium,
                color = Theme.textColorBlack
            )
        }
        // CONTENEDOR DE LAS HERRAMIENTAS
        Column (modifier = Modifier.fillMaxWidth().height(300.dp)) {
            Text(
                "Herramienta ha editar",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge
            )
            Text("ID: ${tubos.TubosID}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("MATERIAL: ${tubos.Material}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("CALIBRE: ${tubos.Calibre}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("TIPO: ${tubos.Tipo}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("FORMA: ${tubos.Forma}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("CANTIDAD: ${tubos.Cantidad}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("ACABADO: ${tubos.Acabado}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("MEDIDA: ${tubos.Medida}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)
            Text("PROVEEDOR: ${tubos.Proveedor}", modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyLarge)

        }
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = queryMaterial,
            onValueChange = { queryMaterial = it },
            label = { Text("Tipo de material", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel(),
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryCalibre,
            onValueChange = {queryCalibre = it},
            label = { Text("Calibre", style = MaterialTheme.typography.bodyLarge) },
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
            value = queryTipo,
            onValueChange = {queryTipo = it},
            label = { Text("Tipo de tubo", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel() ,
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryForma,
            onValueChange = {queryForma = it},
            label = { Text("Forma", style = MaterialTheme.typography.bodyLarge) },
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
            value = queryAcabado,
            onValueChange = {queryAcabado = it},
            label = { Text("Acabado", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel() ,
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryMedida,
            onValueChange = { queryMedida = it },
            label = { Text("Medidas (cm x cm)", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel(),
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = queryProveedor,
            onValueChange = { queryProveedor = it },
            label = { Text("Proveedor", style = MaterialTheme.typography.bodyLarge) },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ColorsTextFiel(),
            singleLine = true
        )
        Spacer(Modifier.height(20.dp))
        Text(if (textAlert=="Good"){""}else{textAlert}, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center, color = Theme.errorColor)
        Spacer(Modifier.height(20.dp))

        Row (modifier = Modifier.fillMaxWidth().padding(bottom = 100.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            OutlinedButton(
                onClick = {navController.navigateTo(AppScreen.RegistroTubos)},
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
                    if (!queryMaterial.matches(notEmptyOrSpacesRegex) &&
                        !queryCalibre.matches(notEmptyOrSpacesRegex) &&
                        !queryTipo.matches(notEmptyOrSpacesRegex) &&
                        !queryForma.matches(notEmptyOrSpacesRegex) &&
                        !queryCantidad.matches(notEmptyOrSpacesRegex) &&
                        !queryAcabado.matches(notEmptyOrSpacesRegex) &&
                        !queryMedida.matches(notEmptyOrSpacesRegex) &&
                        !queryProveedor.matches(notEmptyOrSpacesRegex)
                    ){
                        textAlert = "Aun sin modificaciones"
                    } else {
                        try {
                            tubosCambio = Tubos (
                                TubosID = tubos.TubosID,
                                Material = if (!queryMaterial.matches(notEmptyOrSpacesRegex)){tubos.Material} else {queryMaterial},
                                Calibre = if (!queryCalibre.toString().matches(notEmptyOrSpacesRegex)) { tubos.Calibre } else { queryCalibre.toLong() },
                                Tipo = if (!queryTipo.matches(notEmptyOrSpacesRegex)) { tubos.Tipo } else { queryTipo },
                                Forma = if (!queryForma.toString().matches(notEmptyOrSpacesRegex)) { tubos.Forma } else { queryForma },
                                Cantidad = if (!queryCantidad.matches(notEmptyOrSpacesRegex)) { tubos.Cantidad} else { queryCantidad.toLong() },
                                Acabado = if (!queryAcabado.matches(notEmptyOrSpacesRegex)) { tubos.Acabado } else { queryAcabado },
                                Medida = if (!queryMedida.matches(notEmptyOrSpacesRegex)) { tubos.Medida } else { queryMedida },
                                Proveedor = if (!queryProveedor.matches(notEmptyOrSpacesRegex)) { tubos.Proveedor } else { queryProveedor }
                            )
                            textAlert = tubosViewModel.updateTubos(tubosCambio)
                            if (textAlert == "Good") {
                                showDialog = true
                            }

                        } catch (e: Exception){
                            textAlert = "Ingresa valores validos"
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
                navController.navigateTo(AppScreen.RegistroTubos)
            },
            "Tubo modificado",
            Theme.fourthColor,
            icon = Icons.Default.Check
        )
    }
}