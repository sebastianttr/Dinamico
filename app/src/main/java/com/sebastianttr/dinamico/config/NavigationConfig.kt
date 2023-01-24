package com.sebastianttr.dinamico.config

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sebastianttr.dinamico.layouts.DashboardLayout
import com.sebastianttr.dinamico.ui.theme.MainMedium
import com.sebastianttr.dinamico.ui.theme.MainStrong

data class NavigationScreen(val id: Int, val route: String, val layout: String)

val screenList: List<NavigationScreen> = listOf(
    NavigationScreen(0,"dashboard","MainLayout"),
    NavigationScreen(0,"profile","MainLayout"),
    NavigationScreen(0,"settings","MainLayout")
)

sealed class Screen(val view: NavigationScreen) {
    object Dashboard : Screen(screenList[0])
    object Profile : Screen(screenList[1])
    object Settings : Screen(screenList[2])
}

@Composable
fun SetDefaultSystemColors(
    topBarColor: Color = MainMedium,
    navbarColor: Color = MainStrong
){
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = topBarColor
    )

    systemUiController.setNavigationBarColor(
        color = navbarColor
    )
}