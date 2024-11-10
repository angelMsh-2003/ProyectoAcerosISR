package io.devexpert.proyectoaceros.other

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import io.devexpert.proyectoaceros.R


actual fun getDisplayFontFamily(): FontFamily {
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    return FontFamily(
        Font(
            googleFont = GoogleFont("Poppins"),
            fontProvider = provider
        )
    )
}
actual fun getBodyFontFamily(): FontFamily {
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    return FontFamily(
        Font(
            googleFont = GoogleFont("Nunito Sans"),
            fontProvider = provider
        )
    )
}