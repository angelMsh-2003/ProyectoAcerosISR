package io.devexpert.proyectoaceros.other

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
actual fun convertLongToDate (timestamp: Long?): String {
    return if (timestamp != null) {
        val adjustedTimestamp = timestamp + 86400000
        val zoneId = ZoneId.of("America/Mexico_City")
        val localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(adjustedTimestamp), zoneId)
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())
        localDateTime.format(formatter)
    } else {
        "Sin fecha"
    }
}