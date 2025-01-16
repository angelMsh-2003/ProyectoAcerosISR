package io.devexpert.proyectoaceros.other

import android.os.Build
import androidx.annotation.RequiresApi
import java.security.SecureRandom
import java.security.spec.KeySpec
import javax.crypto.SecretKeyFactory
import java.util.Base64
import javax.crypto.spec.PBEKeySpec


private const val ALGORITHM = "PBKDF2WithHmacSHA512"
private const val ITERATIONS = 120_000
private const val KEY_LENGTH = 256
private const val SECRET = "SomeRandomSecret"

@RequiresApi(Build.VERSION_CODES.O)
actual fun generateRandomSalt(): String {
    val random = SecureRandom()
    val salt = ByteArray(16)
    random.nextBytes(salt)
    return Base64.getEncoder().encodeToString(salt)
}

@RequiresApi(Build.VERSION_CODES.O)
actual fun generateHash(password: String, salt: String): String {
    val saltBytes = Base64.getDecoder().decode(salt)
    val factory: SecretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM)
    val spec: KeySpec = PBEKeySpec(password.toCharArray(), saltBytes, ITERATIONS, KEY_LENGTH)
    val key = factory.generateSecret(spec).encoded
    return Base64.getEncoder().encodeToString(key)
}

@RequiresApi(Build.VERSION_CODES.O)
actual fun validatePassword(inputPassword: String, storedHash: String, storedSalt: String): Boolean {
    val hashToValidate = generateHash(inputPassword, storedSalt)
    return hashToValidate == storedHash
}

