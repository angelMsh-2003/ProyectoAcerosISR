package io.devexpert.navigationkmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.AppDatabase
import io.devexpert.proyectoaceros.ViewModel.HerramientaViewModel
import io.devexpert.proyectoaceros.ViewModel.LaminasViewModel
import io.devexpert.proyectoaceros.ViewModel.SoldaduraViewModel
import io.devexpert.proyectoaceros.ViewModel.TareasViewModel
import io.devexpert.proyectoaceros.ViewModel.TubosViewModel
import io.devexpert.proyectoaceros.ViewModel.UserViewModel

class GenericViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(UserViewModel::class.java) -> UserViewModel(database) as T
            modelClass.isAssignableFrom(HerramientaViewModel::class.java) -> HerramientaViewModel(database) as T
            modelClass.isAssignableFrom(TareasViewModel::class.java) -> TareasViewModel(database) as T
            modelClass.isAssignableFrom(LaminasViewModel::class.java) -> LaminasViewModel(database) as T
            modelClass.isAssignableFrom(SoldaduraViewModel::class.java) -> SoldaduraViewModel(database) as T
            modelClass.isAssignableFrom(TubosViewModel::class.java) -> TubosViewModel(database) as T
            // Agrega más ViewModel aquí
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}