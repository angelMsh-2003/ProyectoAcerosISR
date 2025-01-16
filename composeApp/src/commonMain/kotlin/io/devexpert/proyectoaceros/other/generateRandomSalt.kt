package io.devexpert.proyectoaceros.other

expect fun generateRandomSalt(): String

expect fun generateHash(password: String, salt: String): String

expect fun validatePassword(
    inputPassword: String,
    storedHash: String,
    storedSalt: String
): Boolean