package io.devexpert.proyectoaceros.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppDatabase
import com.example.Laminas
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LaminasViewModel (private val database: AppDatabase) : ViewModel ()  {
    private var alertResult : String = ""
    private val tipoMaterialValidation ="""^.{1,20}$""".toRegex()
    private val calibreValidation = """^\d{1,4}$""".toRegex()
    private val acabadoValidation = """^.{1,20}$""".toRegex()
    private val cantidadRegex = """^\d{1,5}$""".toRegex()
    private val medidaValidation = """^.{1,30}$""".toRegex()
    private val provedorValidation = """^.{1,35}$""".toRegex()

    private val _Sheet = MutableStateFlow<List<Laminas>>(emptyList())
    val Sheet: StateFlow<List<Laminas>> = _Sheet.asStateFlow()

    fun insertNewSheet (laminas : Laminas) : String{
        viewModelScope.launch {
            if (!laminas.TipoMaterial.matches(tipoMaterialValidation)) {
                alertResult = "El material debe ser de máximo 20 caracteres"
            } else if (!laminas.Calibre.toString().matches(calibreValidation)) {
                alertResult = "EL calibre debe ser de máximo 4 números"
            } else if (!laminas.Acabado.matches(acabadoValidation)) {
                alertResult = "El acabado debe ser de máximo 20 caracteres"
            } else if (!laminas.Cantidad.toString().matches(cantidadRegex)) {
                alertResult = "La cantidad debe ser de máximo 5 números"
            } else if (!laminas.Medida.matches(medidaValidation)) {
                alertResult = "EL calibre debe ser de máximo 4 caracteres"
            }else if (!laminas.Proveedor.matches(provedorValidation)) {
                alertResult = "El proveedor debe ser de máximo 35 caracteres"
            } else{
                try {
                    database.iSRDataBaseQueries.insertNewSheet(
                        TipoMaterial = laminas.TipoMaterial,
                        Calibre = laminas.Calibre,
                        Acabado = laminas.Acabado,
                        Cantidad = laminas.Cantidad,
                        Medida = laminas.Medida,
                        Proveedor = laminas.Proveedor
                    )
                    alertResult = "Good"
                } catch (e: Exception) {
                    alertResult = "ErrorInsert"
                }

            }
        }
        return alertResult
    }

    fun loadSheet() {
        viewModelScope.launch {
            val infoSheet = database.iSRDataBaseQueries.readSheetExisting().executeAsList()
            _Sheet.value = infoSheet
        }
    }

    fun deleteSheet (idSheet : Long) {
        try {
            database.iSRDataBaseQueries.deleteSheetExisting (idSheet)
            //alertResult = "eliminado , $idTool"
            loadSheet()
        } catch (e:Exception){
            //alertResult = "error"
        }
    }

    fun updateSheet (laminas: Laminas) : String {
        viewModelScope.launch {
            if (!laminas.TipoMaterial.matches(tipoMaterialValidation)) {
                alertResult = "El material debe ser de máximo 20 caracteres"
            } else if (!laminas.Calibre.toString().matches(calibreValidation)) {
                alertResult = "EL calibre debe ser de máximo 4 dígitos"
            } else if (!laminas.Acabado.matches(acabadoValidation)) {
                alertResult = "El acabado debe ser de máximo 20 caracteres"
            } else if (!laminas.Cantidad.toString().matches(cantidadRegex)) {
                alertResult = "La cantidad debe ser de máximo 5 caracteres"
            } else if (!laminas.Medida.matches(medidaValidation)) {
                alertResult = "EL calibre debe ser de máximo 4 dígitos"
            }else if (!laminas.Proveedor.matches(provedorValidation)) {
                alertResult = "El proveedor debe ser de máximo 35 caracteres"
            } else{
                try {
                    database.iSRDataBaseQueries.updateSheetExisting(
                        TipoMaterial = laminas.TipoMaterial,
                        Calibre = laminas.Calibre,
                        Acabado = laminas.Acabado,
                        Cantidad = laminas.Cantidad,
                        Medida = laminas.Medida,
                        Proveedor = laminas.Proveedor,
                        LaminasID = laminas.LaminasID
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