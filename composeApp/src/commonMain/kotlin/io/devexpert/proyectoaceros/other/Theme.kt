package io.devexpert.proyectoaceros.other

import androidx.compose.ui.graphics.Color

class Theme {
    companion object {
        val primaryColor : Color = Color(0xFF1E6586)
        val secondaryColor : Color = Color (0xFF046B5C)
        val tertiaryColor : Color = Color (0xFF27B0FF)
        val errorColor : Color = Color (0xFFFF4C4C)
        val fourthColor : Color = Color (0xFF7D7D7D)
        val fifthColor : Color = Color (0xFF333333)
        val backgroundColor : Color = Color (0xFFF6FAFE)
        val backgroundColorTwo : Color = Theme.primaryColor.copy(alpha = 0.1f)
        val backgroundColorThree : Color = Theme.secondaryColor.copy(alpha = 0.1f)
        val textColorBlue : Color = Color (0xFF0F3B50)
        val textColorBlack : Color = Color (0xFF000000)
        val textColorWhite : Color = Color (0xFFFFFFFF)
        var iconColorSecundary: Color = Color (0xFFA8D6C8)
    }
}