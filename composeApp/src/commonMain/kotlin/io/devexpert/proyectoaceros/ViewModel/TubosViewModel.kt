package io.devexpert.proyectoaceros.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppDatabase
import com.example.Tubos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TubosViewModel (private val database: AppDatabase) : ViewModel() {
    private var alertResult : String = ""
    private val materialValidation = """^.{1,15}$""".toRegex()
    private val calibreValidation = """^\d{1,4}$""".toRegex()
    private val tipoValidation = """^.{1,20}$""".toRegex()
    private val formaValidation = """^.{1,20}$""".toRegex()
    private val cantidadValidation = """^\d{1,5}$""".toRegex()
    private val acabadoValidation = """^.{1,30}$""".toRegex()
    private val medidaValidation = """^.{1,30}$""".toRegex()
    private val proveedorValidation = """^.{1,35}$""".toRegex()

    private val _Tubos = MutableStateFlow<List<Tubos>>(emptyList())
        val tubos: StateFlow<List<Tubos>> = _Tubos.asStateFlow()

    fun loadTubos() {
        viewModelScope.launch {
            val infoTubos = database.iSRDataBaseQueries.readTubosExisting().executeAsList()
            _Tubos.value = infoTubos
        }
    }


    fun insertNewTubos (tubos: Tubos) : String{
        viewModelScope.launch {
            if (!tubos.Material.matches(materialValidation)) alertResult = "El material debe ser de maximo 15 caracteres"
             else if (!tubos.Calibre.toString().matches(calibreValidation)) alertResult = "El calibre debe ser de máximo 4 dígitos"
             else if (!tubos.Tipo.matches(tipoValidation)) alertResult = "El tipo debe ser de máximo 20 caracteres"
             else if (!tubos.Forma.matches(formaValidation)) alertResult = "La forma debe ser de máximo 20 caracteres"
             else if (!tubos.Cantidad.toString().matches(cantidadValidation)) alertResult = "La cantidad debe ser de maximo 5 dígitos"
             else if (!tubos.Acabado.matches(acabadoValidation)) alertResult = "El acabado debe ser de maximo 30 caracteres"
             else if (!tubos.Medida.matches(medidaValidation)) alertResult = "Las medidas deben ser e maximo 30 caracteres"
             else if (!tubos.Proveedor.matches(proveedorValidation)) alertResult = "El proveedor debe ser de máximo 35 caracteres"
             else{
                try {
                    database.iSRDataBaseQueries.insertNewTubos(
                        Material = tubos.Material,
                        Calibre = tubos.Calibre,
                        Tipo = tubos.Tipo,
                        Forma = tubos.Forma,
                        Cantidad = tubos.Cantidad,
                        Acabado = tubos.Acabado,
                        Medida = tubos.Medida,
                        Proveedor = tubos.Proveedor
                    )
                    alertResult = "Good"
                } catch (e: Exception) {
                    alertResult = "ErrorInsert"
                }

            }
        }
        return alertResult
    }

    fun deleteTubos (idTubos : Long) {
        try {
            database.iSRDataBaseQueries.deleteTubosExisting (idTubos)
            //alertResult = "eliminado , $idTool"
            loadTubos()
        } catch (e:Exception){
            //alertResult = "error"
        }
    }

    fun updateTubos (tubos: Tubos) : String {
        viewModelScope.launch {
            if (!tubos.Material.matches(materialValidation)) alertResult = "El material debe ser de maximo 15 caracteres"
            else if (!tubos.Calibre.toString().matches(calibreValidation)) alertResult = "El calibre debe ser de máximo 4 dígitos"
            else if (!tubos.Tipo.matches(tipoValidation)) alertResult = "El tipo debe ser de máximo 20 caracteres"
            else if (!tubos.Forma.matches(formaValidation)) alertResult = "La forma debe ser de máximo 20 caracteres"
            else if (!tubos.Cantidad.toString().matches(cantidadValidation)) alertResult = "La cantidad debe ser de maximo 5 dígitos"
            else if (!tubos.Acabado.matches(acabadoValidation)) alertResult = "El acabado debe ser de maximo 30 caracteres"
            else if (!tubos.Medida.matches(medidaValidation)) alertResult = "Las medidas deben ser e maximo 30 caracteres"
            else if (!tubos.Proveedor.matches(proveedorValidation)) alertResult = "El proveedor debe ser de máximo 35 caracteres"
            else{
                try {
                    database.iSRDataBaseQueries.updateTubosExisting(
                        Material = tubos.Material,
                        Calibre = tubos.Calibre,
                        Tipo = tubos.Tipo,
                        Forma = tubos.Forma,
                        Cantidad = tubos.Cantidad,
                        Acabado = tubos.Acabado,
                        Medida = tubos.Medida,
                        Proveedor = tubos.Proveedor,
                        TubosID = tubos.TubosID
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