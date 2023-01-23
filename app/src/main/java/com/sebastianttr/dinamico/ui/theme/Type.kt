package com.sebastianttr.dinamico.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.R

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_extralight,FontWeight.ExtraLight),
    Font(R.font.montserrat_extralightitalic,FontWeight.ExtraLight,FontStyle.Italic),
    Font(R.font.montserrat_light,FontWeight.Light),
    Font(R.font.montserrat_lightitalic,FontWeight.Light,FontStyle.Italic),
    Font(R.font.montserrat_thin,FontWeight.Thin),
    Font(R.font.montserrat_thinitalic,FontWeight.Thin,FontStyle.Italic),
    Font(R.font.montserrat_medium,FontWeight.Medium),
    Font(R.font.montserrat_mediumitalic,FontWeight.Medium,FontStyle.Italic),
    Font(R.font.montserrat_semibold,FontWeight.SemiBold),
    Font(R.font.montserrat_bold,FontWeight.Bold),
    Font(R.font.montserrat_extrabold,FontWeight.ExtraBold),
    Font(R.font.montserrat_black,FontWeight.Black),
    Font(R.font.montserrat_blackitalic,FontWeight.Black,FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(                      // Equivalent to Paragraph
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 17.28.sp
    ),
    h6 = TextStyle(                         // Equivalent to VerySmall
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h3 = TextStyle(                         // Equivalent to Subtitle
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    ),
    h1 = TextStyle(                         // Equivalent to Title
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 35.8.sp
    )
)