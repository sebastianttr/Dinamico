package com.sebastianttr.dinamico.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sebastianttr.dinamico.ui.theme.MainMedium

@Composable
fun SettingsLayout(){
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = MainMedium
    )


    Text(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .wrapContentHeight(),
        text = "Settings Layout",
        textAlign = TextAlign.Center
    )
}