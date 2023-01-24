package com.sebastianttr.dinamico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.composable.SButton
import com.sebastianttr.dinamico.composable.STextField
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.layouts.dpToPx
import com.sebastianttr.dinamico.ui.theme.AccentLight
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.dinamico.ui.theme.Montserrat

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var email by remember { mutableStateOf("") }
            var userName by remember { mutableStateOf("") }
            var passWord by remember { mutableStateOf("") }
            var repeatPassword by remember { mutableStateOf("") }

            SetDefaultSystemColors(topBarColor = AccentLight, navbarColor = Color(0xFF25284F))

            DinamicoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF111224),
                                    Color(0xFF25284F)
                                ),
                                startY = 300.dp.dpToPx(),
                                endY = (LocalConfiguration.current.screenHeightDp.dp + 300.dp).dpToPx()
                            )
                        ),
                    color = Color.Transparent
                ) {
                    Box(modifier = Modifier.fillMaxWidth()){
                        Image(
                            modifier = Modifier
                                .padding(top = 211.dp)
                                .height(36.dp)
                                .fillMaxWidth(),
                            painter = painterResource(id = R.drawable.checker),
                            contentDescription = "checker"
                        )
                        Image(
                            painter = painterResource(id = R.drawable.login_vector),
                            contentDescription = "Pic background",
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.FillWidth
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 112.dp),
                            text = "Register",
                            style = TextStyle(
                                fontSize = 48.sp,
                                fontWeight = FontWeight.Black,
                                fontStyle = FontStyle.Italic,
                                fontFamily = Montserrat,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        )
                        Column(modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 80.dp, start = 16.dp, end = 16.dp)
                            .verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(40.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                STextField(
                                    text = userName,
                                    onValueChanged = {
                                        userName = it
                                    },
                                    height = 42.dp,
                                    inputDescription = "Username"
                                )
                                STextField(
                                    text = email,
                                    onValueChanged = {
                                         email = it
                                    },
                                    height = 42.dp,
                                    inputDescription = "Email"
                                )
                                STextField(
                                    text = passWord,
                                    onValueChanged = {
                                        passWord = it
                                    },
                                    height = 42.dp,
                                    inputDescription = "Password"
                                )
                                STextField(
                                    text = repeatPassword,
                                    onValueChanged = {
                                        repeatPassword = it
                                    },
                                    height = 42.dp,
                                    inputDescription = "Repeat Password"
                                )
                            }
                            Row(Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Box(modifier = Modifier
                                    .fillMaxWidth(0.3f)
                                ){
                                    SButton(
                                        text = "BACK",
                                        colors = listOf(
                                            Color(0xFF646CDB),
                                            Color(0xFF9398E1)
                                        ),
                                        onClick = {
                                            finish()
                                        }
                                    )
                                }
                                Box(modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                ){
                                    SButton(
                                        text = "REGISTER",
                                        colors = listOf(
                                            Color(0xFFFBAB18),
                                            Color(0xFFFEDE00)
                                        ),
                                        onClick = {

                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

