package io.devexpert.proyectoaceros.View.Apartados.Materiales

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.other.Theme

@Composable
fun NavigationBottonBar (navController: Navigation, selectedItem: Int) {
    val items = listOf("Laminas", "Soldadura", "Tubos")
    val selectedIcons = listOf(Icons.Filled.KeyboardArrowUp, Icons.Filled.KeyboardArrowUp, Icons.Filled.KeyboardArrowUp)
    val unselectedIcons =
        listOf(Icons.Outlined.KeyboardArrowDown, Icons.Outlined.KeyboardArrowDown, Icons.Outlined.KeyboardArrowDown)
    NavigationBar (
        modifier = Modifier.zIndex(1F),
        containerColor = Theme.primaryColor){
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = {
                    when (index) {
                        0 -> { navController.navigateTo(AppScreen.RegistroLaminas) }
                        1 -> { navController.navigateTo(AppScreen.RegistroSoldadura) }
                        2 -> { navController.navigateTo(AppScreen.RegistroTubos) }
                    }

                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Theme.primaryColor,
                    selectedTextColor = Theme.textColorWhite,
                    selectedIndicatorColor = Theme.iconColorSecundary,
                    unselectedIconColor = Theme.textColorWhite,
                    unselectedTextColor = Theme.textColorWhite,
                    disabledIconColor = Theme.errorColor,
                    disabledTextColor = Theme.errorColor,
                )
            )
        }
    }
}