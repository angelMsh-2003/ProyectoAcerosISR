package io.devexpert.proyectoaceros.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppDatabase
import com.example.ReadTaskExisting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TareasViewModel (private val database: AppDatabase) : ViewModel() {
    private var alertResult : String = ""
    private val numUserValidation : String = "^[0-9]{7}\$"
    private val descriptionActivityValidation = "^[a-zA-Z0-9\\s!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/`~]{1,50}$"
    private val errorActivityValidation = "^[0-9]{1,2}$"
    private val _task = MutableStateFlow<List<ReadTaskExisting>>(emptyList())
    val task: StateFlow<List<ReadTaskExisting>> = _task.asStateFlow()

    fun loadTask() {
        viewModelScope.launch {
            val infoTask = database.iSRDataBaseQueries.readTaskExisting().executeAsList()
            _task.value = infoTask
        }
    }

    fun insertActivity (
        description: String,
        error: String,
        area: String,
        numUser:String,
        estado: String,
        dateInit: String,
        dateFinish: String
    ) : String {
        viewModelScope.launch {
            val exists = database.iSRDataBaseQueries.readEspeficiUserExisting(numUser.toLong()).executeAsOne()
            if (!description.matches(descriptionActivityValidation.toRegex())){
                alertResult = "La descripcion es de maximo 30 caracteres"
            } else if (!error.matches(errorActivityValidation.toRegex())) {
                alertResult = "El error debe ser un porcentaje"
            } else if (!numUser.matches(numUserValidation.toRegex())) {
                alertResult = "El número de empleado debe contener 7 digitos"
            } else if (!exists){
                alertResult = "El usuario no existe"
            } else {
                try {
                    database.iSRDataBaseQueries.insertNewActivity(
                        Descripcion = description,
                        MargenError = error.toLong(),
                        Area = area
                    )
                    alertResult = insertTask(numUser, estado, dateInit, dateFinish)
                } catch (e: Exception) {
                    alertResult = "ErrorInsertActivity"
                }
            }
        }
        return alertResult
    }
    private fun insertTask (numUser:String, estado: String, dateInit: String, dateFinish: String) : String{
        viewModelScope.launch {
            val idActivity = database.iSRDataBaseQueries.validMaxIdActivity().executeAsOne()

                    database.iSRDataBaseQueries.insertNewTask(
                        ActividadId = idActivity,
                        NumEmpleado = numUser.toLong(),
                        Estado = estado,
                        FechaInicio = dateInit,
                        FechaFin = dateFinish
                    )
                    alertResult = "Good"


        }
        return alertResult
    }

    fun deleteTask (idTool : Long) {
        try {
            database.iSRDataBaseQueries.deleteTaskExisting (idTool)
            database.iSRDataBaseQueries.deleteActivityExisting(idTool)
            //alertResult = "eliminado , $idTool"
            loadTask()
        } catch (e:Exception){
            //alertResult = "error"
        }
    }

    fun updateActivity (
        id: String,
        description: String,
        error: String,
        area: String,
        numUser:String,
        estado: String,
        dateInit: String,
        dateFinish: String
    ) : String {
        viewModelScope.launch {
            val exists = database.iSRDataBaseQueries.readEspeficiUserExisting(numUser.toLong()).executeAsOne()
            if (!description.matches(descriptionActivityValidation.toRegex())){
                alertResult = "La descripcion es de maximo 30 caracteres"
            } else if (!error.matches(errorActivityValidation.toRegex())) {
                alertResult = "El error debe ser un porcentaje"
            } else if (!numUser.matches(numUserValidation.toRegex())) {
                alertResult = "El número de empleado debe contener 7 digitos"
            } else if (!exists){
                alertResult = "El usuario no existe"
            } else {
                try {
                    database.iSRDataBaseQueries.updateActivityExisting(
                        Descripcion = description,
                        MargenError = error.toLong(),
                        Area = area,
                        ActividadId = id.toLong()
                    )
                    alertResult = updateTask(id, numUser, estado, dateInit, dateFinish)
                } catch (e: Exception) {
                    alertResult = "ErrorInsertActivity"
                }
            }

        }
        return alertResult
    }

    private fun updateTask (id: String, numUser:String, estado: String, dateInit: String, dateFinish: String) : String{
        viewModelScope.launch {
            try {
                database.iSRDataBaseQueries.updateTaskExisting(
                    NumEmpleado = numUser.toLong(),
                    Estado = estado,
                    FechaInicio = dateInit,
                    FechaFin = dateFinish,
                    ActividadId = id.toLong()
                )
                alertResult = "Good"
            } catch (e: Exception) {
                alertResult = "ErrorInsertTask"
            }
        }
        return alertResult
    }
}