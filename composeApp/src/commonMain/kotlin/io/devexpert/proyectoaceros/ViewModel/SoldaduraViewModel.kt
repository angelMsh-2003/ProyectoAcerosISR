package io.devexpert.proyectoaceros.ViewModel

import androidx.annotation.IntDef
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppDatabase
import com.example.Soldadura
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SoldaduraViewModel (private val database: AppDatabase) : ViewModel() {
    private var alertResult : String = ""
    private val nombreSoldaduraValidation = """^.{1,15}$""".toRegex()
    private val tipoValidation = """^.{1,20}$""".toRegex()
    private val cantidadValidation = """^\d{1,5}$""".toRegex()
    private val proveedorValidation = """^.{1,35}$""".toRegex()

    private val _Sol = MutableStateFlow<List<Soldadura>>(emptyList())
    val Sol: StateFlow<List<Soldadura>> = _Sol.asStateFlow()

    fun loadSol() {
        viewModelScope.launch {
            val infoSol = database.iSRDataBaseQueries.readSolExisting().executeAsList()
            _Sol.value = infoSol
        }
    }

    fun insertNewSol (soldadura: Soldadura) : String{
        viewModelScope.launch {
            if (!soldadura.NombreSoldadura.matches(nombreSoldaduraValidation)) alertResult = "La soldadura debe contener maximo 15 caracteres"
             else if (!soldadura.Tipo.matches(tipoValidation)) alertResult = "El tipo debe ser de maximo 20 caracteres"
             else if (!soldadura.Cantidad.toString().matches(cantidadValidation)) alertResult = "La cantidad debe ser de maximo 5 dígitos"
             else if (!soldadura.Proveedor.matches(proveedorValidation)) alertResult = "El proveedor debe ser de máximo 35 caracteres"
             else{
                try {
                    database.iSRDataBaseQueries.insertNewSol(
                        NombreSoldadura = soldadura.NombreSoldadura,
                        Tipo = soldadura.Tipo,
                        Cantidad = soldadura.Cantidad,
                        Proveedor = soldadura.Proveedor
                    )
                    alertResult = "Good"
                } catch (e: Exception) {
                    alertResult = "ErrorInsert"
                }

            }
        }
        return alertResult
    }

    fun deleteSheet (idSol : Long) {
        try {
            database.iSRDataBaseQueries.deleteSolExisting (idSol)
            //alertResult = "eliminado , $idTool"
            loadSol()
        } catch (e:Exception){
            //alertResult = "error"
        }
    }

    fun updateSol (soldadura: Soldadura) : String {
        viewModelScope.launch {
            if (!soldadura.NombreSoldadura.matches(nombreSoldaduraValidation)) alertResult = "La soldadura debe contener maximo 15 caracteres"
            else if (!soldadura.Tipo.matches(tipoValidation)) alertResult = "El tipo debe ser de maximo 20 caracteres"
            else if (!soldadura.Cantidad.toString().matches(cantidadValidation)) alertResult = "La cantidad debe ser de maximo 5 dígitos"
            else if (!soldadura.Proveedor.matches(proveedorValidation)) alertResult = "El proveedor debe ser de máximo 35 caracteres"
            else{
                try {
                    database.iSRDataBaseQueries.updateSolExisting(
                        NombreSoldadura = soldadura.NombreSoldadura,
                        Tipo = soldadura.Tipo,
                        Cantidad = soldadura.Cantidad,
                        Proveedor = soldadura.Proveedor,
                        SoldaduraID = soldadura.SoldaduraID
                    )
                    alertResult = "Good"
                } catch (e: Exception) {
                    alertResult = "ErrorInsert"
                }

            }
        }
        return alertResult
    }
}