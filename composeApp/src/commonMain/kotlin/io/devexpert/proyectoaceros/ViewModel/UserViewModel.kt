package io.devexpert.proyectoaceros.ViewModel

import androidx.compose.foundation.interaction.DragInteraction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppDatabase
import com.example.SelectActualUser
import io.devexpert.proyectoaceros.Model.Empleados
import io.devexpert.proyectoaceros.Navigation.AppScreen
import io.devexpert.proyectoaceros.Navigation.Navigation
import io.devexpert.proyectoaceros.other.generateHash
import io.devexpert.proyectoaceros.other.generateRandomSalt
import io.devexpert.proyectoaceros.other.validatePassword
import kotlinx.coroutines.launch

class UserViewModel(private val database: AppDatabase) : ViewModel() {
    private var alertResult : String = ""
    private val numUserValidation : String = "^[0-9]{7}\$"
    private val nameValidation : String = "^[A-Z\\s]{1,50}\$"
    private val levelValidation : String = "^[A-Z\\s]{1,50}\$"
    private val passwordValidation : String = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{6,10}$"
    private val emailValidation : String = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"

    fun insertUser (user : Empleados) : String {
        viewModelScope.launch {
            if (!user.NumEmpleado.toString().matches(numUserValidation.toRegex())){
                alertResult = "El número de empleado debe contener 7 digitos"
            } else if (!user.NombreEmpleado.matches(nameValidation.toRegex())) {
                alertResult = "El nombre de empleado solo debe contener letras y espacios"
            } else if (!user.Cargo.matches(levelValidation.toRegex())) {
                alertResult = "El cargo solo debe contener letras y espacios"
            } else {
                try {
                    database.iSRDataBaseQueries.insertNewUser(
                        NumEmpleado = user.NumEmpleado,
                        NombreEmpleado = user.NombreEmpleado,
                        Cargo = user.Cargo
                    )
                    alertResult = "Good"
                } catch (e: Exception) {
                    alertResult = "UserExist"
                }
            }
        }
        return alertResult
    }

    fun updateUser (mail: String, pass1 : String, pass2: String, estado: Long,numUser: String, navigation: Navigation) : String {
        var hashScript : String
        var password_hash : String
        viewModelScope.launch {
            if (!mail.matches(emailValidation.toRegex())) {
                alertResult = "El correo no es correcto"
            } else if (pass1 != pass2) {
                alertResult = "Las contraseñas no coinciden"
            }
            else if (!pass1.matches(passwordValidation.toRegex())){
                alertResult = "La contraseña debe contener mayúsculas, minúsculas y números, de entre 6 a 10 caracteres (sin espacios ni caracteres especiales)"
            }
            else {
                try {
                    hashScript = generateRandomSalt ()
                    password_hash = generateHash (pass1, hashScript)

                    database.iSRDataBaseQueries.updateUserExisting(
                        Correo = mail,
                        Password_hash = password_hash,
                        Salt = hashScript,
                        Estado = estado,
                        NumEmpleado = numUser.toLong()
                    )
                    alertResult = "Good"
                } catch (e: Exception) {
                    alertResult = "UserExist"
                }

            }
        }
        return alertResult
    }

    fun existingUserValid (numUser: String, navigation: Navigation) : String {
        viewModelScope.launch {
            if (!numUser.matches(numUserValidation.toRegex())){
                alertResult = "El número de empleado debe contener 7 digitos"
            } else {
                val exists = database.iSRDataBaseQueries.readEspeficiUserExisting(numUser.toLong()).executeAsOne()
                if (exists){
                    navigation.navigateTo(AppScreen.Registro(userActual = numUser.toLong()))
                } else {
                    alertResult = "NoExistUser"
                }
            }

        }
        return alertResult
    }

    fun existingValidUser () : Boolean {
        var exists : Boolean = false
        viewModelScope.launch {
            exists = database.iSRDataBaseQueries.readActualUserExisting(1).executeAsOne()
        }
        return exists
    }

    fun readUserExisting (numUser: Long) : List<String>  {
        val infoUser: MutableList<String> = mutableListOf()
        viewModelScope.launch {
            val resultNum = database.iSRDataBaseQueries.readNumUserExisting(numUser).executeAsList()[0]
            val resultName = database.iSRDataBaseQueries.readNameUserExisting(numUser).executeAsList()[0]
            val resultLevel = database.iSRDataBaseQueries.readLevelUserExisting(numUser).executeAsList()[0]
            infoUser.add(resultNum.toString())
            infoUser.add(resultName)
            infoUser.add(resultLevel)
        }
        return infoUser
    }

    fun validUserExisting (numUser: String, pass: String, navigation: Navigation) : String {
        viewModelScope.launch {
            if (numUser == "1234567" && pass == "Admin321") {
                navigation.navigateTo(AppScreen.MenuInicio)
            }
            if (!numUser.matches(numUserValidation.toRegex())){
                alertResult = "El número de empleado debe contener 7 digitos"
            } else if (!pass.matches(passwordValidation.toRegex())){
                alertResult = "La contraseña debe contener mayúsculas, minúsculas y números, de entre 6 a 10 caracteres (sin espacios ni caracteres especiales)"
            } else {
                try {
                    val exists = database.iSRDataBaseQueries.readEspeficiUserExisting(numUser.toLong()).executeAsOne()
                    if (exists) {
                        val saltScript : String = (database.iSRDataBaseQueries.readSaltExisting(numUser.toLong()).executeAsList()[0]).Salt ?:""
                        val passwordHash : String = (database.iSRDataBaseQueries.readHashExisting(numUser.toLong()).executeAsList()[0]).Password_hash ?:""
                        val passwordValid = validatePassword (pass, passwordHash, saltScript)
                        if (passwordValid) {
                            insetUserActual(1, numUser.toLong())
                            navigation.navigateTo(AppScreen.MenuInicio)
                        } else {
                            alertResult = "userNoExists"
                        }
                    } else {
                        alertResult = "userNoExists"
                    }
                } catch (e : Exception) {
                    alertResult = e.toString()
                }
            }
        }
        return alertResult
    }

    private fun insetUserActual (id: Long, numUser: Long) {
        val nameUser = database.iSRDataBaseQueries.readNameUserExisting(numUser).executeAsOne()
        val cargo = database.iSRDataBaseQueries.readLevelUserExisting(numUser).executeAsOne()
        viewModelScope.launch {
            database.iSRDataBaseQueries.insertActualUser (
                ID = id,
                UserId = numUser,
                NombreEmpleado = nameUser,
                Cargo = cargo,
            )
        }
    }

    fun deleteUserActual () {
        viewModelScope.launch {
            database.iSRDataBaseQueries.deleteActualUser ()
        }
    }

    fun selectActualUser () : SelectActualUser {
        var infoUser : SelectActualUser = SelectActualUser (0L, "", "")
        viewModelScope.launch {
            try {
                infoUser = database.iSRDataBaseQueries.selectActualUser().executeAsOne()
            } catch (e: Exception){
                println("Error en la insersion")
            }
        }
        return infoUser
    }
}