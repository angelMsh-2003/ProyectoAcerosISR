package io.devexpert.proyectoaceros.Funtion

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.devexpert.proyectoaceros.other.Theme

fun ColorsSegmentedButton () : SegmentedButtonColors{
    return SegmentedButtonColors(
        activeContainerColor = Theme.tertiaryColor,
        activeContentColor = Theme.textColorWhite,
        activeBorderColor = Theme.textColorBlack,
    // enabled & inactive
        inactiveContainerColor = Theme.backgroundColor,
        inactiveContentColor = Theme.textColorBlack,
        inactiveBorderColor = Theme.tertiaryColor,
    // disable & active
        disabledActiveContainerColor = Theme.errorColor,
        disabledActiveContentColor = Theme.errorColor,
        disabledActiveBorderColor = Theme.errorColor,
    // disable & inactive
        disabledInactiveContainerColor = Theme.errorColor,
        disabledInactiveContentColor = Theme.errorColor,
        disabledInactiveBorderColor = Theme.errorColor
    )
}

@Composable
fun ColorsTextFiel () : TextFieldColors {
    return TextFieldDefaults.colors(
        focusedTextColor = Theme.tertiaryColor,
        unfocusedTextColor = Theme.tertiaryColor,

        focusedContainerColor = Theme.backgroundColorThree,
        unfocusedContainerColor = Theme.backgroundColorThree,

        focusedLabelColor = Theme.textColorBlack,
        unfocusedLabelColor = Theme.textColorBlack,

        cursorColor = Theme.tertiaryColor,
        selectionColors = TextSelectionColors(
            Theme.tertiaryColor,
            Theme.tertiaryColor.copy(alpha = 0.3f)
        ),

        focusedIndicatorColor = Theme.tertiaryColor,
        unfocusedIndicatorColor = Theme.tertiaryColor,
    )

}
