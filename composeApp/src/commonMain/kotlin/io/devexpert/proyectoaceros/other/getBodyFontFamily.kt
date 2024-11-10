package io.devexpert.proyectoaceros.other

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily

expect fun getDisplayFontFamily(): FontFamily
expect fun getBodyFontFamily(): FontFamily

class getBody {
    companion object typographyTheme {
        private val baseline = Typography()

        val AppTypographyInstance = Typography(
            displayLarge = baseline.displayLarge.copy(fontFamily = getDisplayFontFamily()),
            displayMedium = baseline.displayMedium.copy(fontFamily = getDisplayFontFamily()),
            displaySmall = baseline.displaySmall.copy(fontFamily = getDisplayFontFamily()),
            headlineLarge = baseline.headlineLarge.copy(fontFamily = getDisplayFontFamily()),
            headlineMedium = baseline.headlineMedium.copy(fontFamily = getDisplayFontFamily()),
            headlineSmall = baseline.headlineSmall.copy(fontFamily = getDisplayFontFamily()),
            titleLarge = baseline.titleLarge.copy(fontFamily = getDisplayFontFamily()),
            titleMedium = baseline.titleMedium.copy(fontFamily = getDisplayFontFamily()),
            titleSmall = baseline.titleSmall.copy(fontFamily = getDisplayFontFamily()),

            bodyLarge = baseline.bodyLarge.copy(fontFamily = getBodyFontFamily()),
            bodyMedium = baseline.bodyMedium.copy(fontFamily = getBodyFontFamily()),
            bodySmall = baseline.bodySmall.copy(fontFamily = getBodyFontFamily()),
            labelLarge = baseline.labelLarge.copy(fontFamily = getBodyFontFamily()),
            labelMedium = baseline.labelMedium.copy(fontFamily = getBodyFontFamily()),
            labelSmall = baseline.labelSmall.copy(fontFamily = getBodyFontFamily()),

            )
    }
}