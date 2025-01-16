package io.devexpert.proyectoaceros.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppDatabase
import com.example.Herramienta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HerramientaViewModel (private val database: AppDatabase) : ViewModel() {
    private var alertResult : String = ""
    private val nameToolValidation = "^[a-zA-Z0-9\\s!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/`~]{1,30}$"
    private val countToolValidation = "^[0-9]{1,4}$"
    private val _tools = MutableStateFlow<List<Herramienta>>(emptyList())
    val tools: StateFlow<List<Herramienta>> = _tools.asStateFlow()

    fun loadTools() {
        viewModelScope.launch {
            val infoTools = database.iSRDataBaseQueries.readToolExisting().executeAsList()
            _tools.value = infoTools
        }
    }
    fun insertTool (name: String, count: String, location: String) : String {
        viewModelScope.launch {
            if (!name.matches(nameToolValidation.toRegex())){
                alertResult = "El nombre debe ser de maximo 30 caracteres"
            } else if (!count.matches(countToolValidation.toRegex())) {
                alertResult = "Maximo 4 números"
            } else {
                try {
                    database.iSRDataBaseQueries.insertNewTool(
                        NombreHerramienta = name,
                        Cantidad = count.toLong(),
                        Ubicacion = location
                    )
                    alertResult = "Good"
                } catch (e: Exception) {
                    alertResult = "ErrorInsert"
                }
            }
        }
        return alertResult
    }

    fun nToolsValidation () : Long {
        var n : Long = 0L
        viewModelScope.launch {
            n = database.iSRDataBaseQueries.countToolsExisting().executeAsOne()
        }
        return n
    }

    fun deleteTool (idTool : Long) {
        try {
            database.iSRDataBaseQueries.deleteToolExisting (idTool)
            //alertResult = "eliminado , $idTool"
            loadTools()
        } catch (e:Exception){
            //alertResult = "error"
        }
    }

    fun updateTool (id: Long,name: String, count: String, location: String) : String{
        viewModelScope.launch {
            if (!name.matches(nameToolValidation.toRegex())){
                alertResult = "El nombre debe ser de maximo 30 caracteres"
            } else if (!count.matches(countToolValidation.toRegex())) {
                alertResult = "Maximo 4 números"
            } else {
                try {
                    database.iSRDataBaseQueries.updateToolExisting(
                        NombreHerramienta = name,
                        Cantidad = count.toLong(),
                        Ubicacion = location,
                        HerramientaID = id
                    )
                    alertResult = "Good"
                } catch (e: Exception) {
                    alertResult = "ErrorUpdate"
                }
            }
        }
        return alertResult
    }

}
