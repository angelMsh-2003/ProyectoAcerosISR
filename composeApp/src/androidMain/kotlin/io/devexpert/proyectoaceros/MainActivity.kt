package io.devexpert.proyectoaceros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.Navigation.defineMainScreen
import io.devexpert.proyectoaceros.View.FirstMainScreen
import io.devexpert.proyectoaceros.View.MenuInicio
import io.devexpert.proyectoaceros.View.SeconMainScreen
import io.devexpert.proyectoaceros.other.getBody.typographyTheme.AppTypographyInstance
import androidx.compose.material3.MaterialTheme as M3MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        // Crea el driver para Android (base de datos SQLite)
        val driver = AndroidSqliteDriver(AppDatabase.Schema, this, "AppDatabase.db")

        // Ahora puedes crear la instancia de la base de datos
        val database = AppDatabase(driver)

        // Crear el ViewModel con la base de datos utilizando el ViewModelFactory
        val userViewModel: UserViewModel by viewModels { UserViewModelFactory(database) }
        */
        setContent {
            M3MaterialTheme (
                typography = AppTypographyInstance
            ){
                defineMainScreen (navController = Navigation())
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun AppAndroidPreview() {
    //MenuInicio()
}