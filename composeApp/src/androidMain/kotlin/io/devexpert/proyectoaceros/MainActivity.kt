package io.devexpert.proyectoaceros

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.viewModelFactory
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.AppDatabase
import io.devexpert.navigationkmp.GenericViewModelFactory
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.Navigation.defineMainScreen
import io.devexpert.proyectoaceros.ViewModel.HerramientaViewModel
import io.devexpert.proyectoaceros.ViewModel.LaminasViewModel
import io.devexpert.proyectoaceros.ViewModel.SoldaduraViewModel
import io.devexpert.proyectoaceros.ViewModel.TareasViewModel
import io.devexpert.proyectoaceros.ViewModel.TubosViewModel
import io.devexpert.proyectoaceros.ViewModel.UserViewModel
import io.devexpert.proyectoaceros.other.AndroidAppCloser
import io.devexpert.proyectoaceros.other.AppCloser
import io.devexpert.proyectoaceros.other.getBody.typographyTheme.AppTypographyInstance
import androidx.compose.material3.MaterialTheme as M3MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val driver = AndroidSqliteDriver(AppDatabase.Schema, this, "AppDatabase.db")
        val database = AppDatabase(driver)
        val userViewModel: UserViewModel by viewModels { GenericViewModelFactory (database) }
        val toolViewModel: HerramientaViewModel by viewModels { GenericViewModelFactory (database) }
        val taskViewModel: TareasViewModel by viewModels { GenericViewModelFactory (database) }
        val laminasViewModel : LaminasViewModel by viewModels { GenericViewModelFactory (database) }
        val soldaduraViewModel: SoldaduraViewModel by viewModels { GenericViewModelFactory (database) }
        val tubosViewModel : TubosViewModel  by viewModels { GenericViewModelFactory (database) }
        val appCloser = AndroidAppCloser(this)
        setContent {
            M3MaterialTheme (
                typography = AppTypographyInstance
            ){
                defineMainScreen (navController = Navigation(), userViewModel, toolViewModel, taskViewModel, laminasViewModel, soldaduraViewModel, tubosViewModel, appCloser)
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun AppAndroidPreview() {
    // AgregarHerramientaNuevaMO()
    // Icon { Icons.Default.KeyboardArrowUp}
}