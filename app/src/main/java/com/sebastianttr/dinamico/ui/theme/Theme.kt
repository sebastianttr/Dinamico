package com.sebastianttr.dinamico.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.sebastianttr.dinamico.R

private val Montserrat1 = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_extralight, FontWeight.ExtraLight),
    Font(R.font.montserrat_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_thinitalic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_black, FontWeight.Black),
    Font(R.font.montserrat_blackitalic, FontWeight.Black, FontStyle.Italic),
)

private val DarkColorPalette = darkColors(
    primary = MainMedium,
    primaryVariant = MainLight,
    secondary = AccentMedium,
    background = MainMedium,
    onSecondary = AccentStrong
)


private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun DinamicoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit) {

    MaterialTheme(

        colors = DarkColorPalette,
        typography = Typography(
            defaultFontFamily = Montserrat
        ),
        shapes = Shapes,
        content = content,
    )
}