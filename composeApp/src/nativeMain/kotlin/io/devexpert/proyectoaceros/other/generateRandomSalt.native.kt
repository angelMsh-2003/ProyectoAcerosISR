package io.devexpert.proyectoaceros.other

actual fun generateRandomSalt(): String {
    TODO("Not yet implemented")
}

actual fun validatePassword(
    inputPassword: String,
    storedHash: String,
    storedSalt: String
): Boolean {
    TODO("Not yet implemented")
}

actual fun generateHash(password: String, salt: String): String {
    TODO("Not yet implemented")
}