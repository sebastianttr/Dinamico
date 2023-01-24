package com.sebastianttr.dinamico.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sebastianttr.dinamico.R
import com.sebastianttr.dinamico.composable.*
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.ui.theme.MainMedium
import com.sebastianttr.dinamico.ui.theme.Montserrat

@Composable
fun SettingsLayout(){
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = MainMedium
    )

    SetDefaultSystemColors(topBarColor = Color(0xFF111224))

    Surface(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF111224),
                        Color(0xFF25284F)
                    ),
                    startY = LocalConfiguration.current.screenHeightDp * 0.3f,
                    endY = LocalConfiguration.current.screenHeightDp * 1.3f
                )
            )
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        color = Color.Transparent
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            item {
                Text(
                    text = "Your profile",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp,
                        color = Color.White,
                    )
                )
            }
            item {
                STextField(
                    text = "hello",
                    onValueChanged = {},
                    height = 42.dp,
                    inputDescription = "Name"
                )
            }
            item {
                STextField(
                    text = "hello",
                    onValueChanged = {},
                    height = 42.dp,
                    inputDescription = "Email"
                )
            }
            item {
                STextField(
                    text = "hello",
                    onValueChanged = {},
                    height = 42.dp,
                    inputDescription = "Password"
                )
            }
            item {
                SButton(
                    text = "SAVE",
                    height = 40.dp,
                    colors = listOf(
                        Color(0xFFFBAB18),
                        Color(0xFFFEDE00)
                    )
                )
            }
            item {
                Column() {
                    Text(
                        text = "General Settings",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 22.sp,
                            color = Color.White,
                        )
                    )
                    SBorderedColumn {
                        SBorderedColumnSettingsItemToggle("Notifications")
                        SBorderedColumnItemDivider()
                        SBorderedColumnSettingsItemToggle("Dark Theme")
                        SBorderedColumnItemDivider()
                        SBorderedColumnSettingsItemToggle("Open Animation")
                        SBorderedColumnItemDivider()
                        SBorderedColumnSettingsItemToggle("Receive friend requests")
                        SBorderedColumnItemDivider()
                        SBorderedColumnSettingsItemToggle("Set profile to 'Public'")
                    }
                }
            }
            item {
                Column() {
                    Text(
                        text = "Privacy Settings",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 22.sp,
                            color = Color.White,
                        )
                    )
                    SBorderedColumn {
                        SBorderedColumnSettingsItemToggle("Personalization and tracking for advertising")
                    }
                }
            }
            item {
                Column(
                    Modifier.padding(bottom = 60.dp)
                ) {
                        Text(
                        text = "Delete Account",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 22.sp,
                            color = Color.White,
                        )
                    )
                    SBorderedColumn {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Are you sure you want to delete your account? That means all data will be lost (progress, name, friends, etc.).",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                        Box(modifier = Modifier.padding(16.dp)){
                            SButton(
                                text = "DELETE ACCOUNT",
                                height = 40.dp,
                                padding = 16.dp,
                                colors = listOf(
                                    Color(0xFFB91010),
                                    Color(0xFFDC5959)
                                )
                            )
                        }
                    }
                }
            }

        }

    }


}