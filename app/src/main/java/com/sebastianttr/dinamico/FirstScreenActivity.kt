package com.sebastianttr.dinamico

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.composable.SButton
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.ui.theme.AccentLight
import com.sebastianttr.dinamico.ui.theme.AccentStrong
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.dinamico.ui.theme.Montserrat
import com.sebastianttr.room.database.AppDatabase
import com.sebastianttr.room.database.Database
import com.sebastianttr.room.entites.Options
import kotlinx.coroutines.launch
@SuppressLint("CoroutineCreationDuringComposition")
class FirstScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SetDefaultSystemColors(topBarColor = Color(0xFF111224), navbarColor = AccentLight)

            val coroutineScope = rememberCoroutineScope()
            lateinit var db: AppDatabase
            val ctx = LocalContext.current

            coroutineScope.launch {
                db = Database.getDb(ctx)
            }

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
                                startY = LocalConfiguration.current.screenHeightDp * 0.3f,
                                endY = LocalConfiguration.current.screenHeightDp * 1.3f
                            )
                        ),
                    color = Color.Transparent
                ) {
                    // Top Part.
                    Box(modifier = Modifier){
                        Image(
                            painter = painterResource(id = R.drawable.first_screen_img),
                            contentDescription = "Pic background",
                            modifier = Modifier.height(420.dp).fillMaxWidth().align(Alignment.TopCenter),
                            contentScale = ContentScale.FillHeight
                        )
                        Column(modifier = Modifier.padding(top = 293.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.first_screen_vecotr),
                                contentDescription = "vector round",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentScale = ContentScale.FillWidth
                            )
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .background(AccentLight)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 171.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Text(
                                text = "Welcome",
                                style = TextStyle(
                                    fontSize = 48.sp,
                                    fontWeight = FontWeight.Black,
                                    fontStyle = FontStyle.Italic,
                                    fontFamily = Montserrat,
                                    color = Color.White
                                )
                            )
                            Text(
                                text = "Ready, adventurer?",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Black,
                                    fontStyle = FontStyle.Italic,
                                    fontFamily = Montserrat,
                                    color = AccentStrong
                                )
                            )
                        }
                        Column(modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 80.dp, start = 16.dp, end = 16.dp),
                                verticalArrangement = Arrangement.spacedBy(120.dp)
                            ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(40.dp)
                            ) {
                                SButton(
                                    text = "LOGIN",
                                    colors = listOf(
                                        Color(0xFFF88826),
                                        Color(0xFFFFB472)
                                    ),
                                    onClick = {
                                        startActivity(Intent(this@FirstScreenActivity,LoginActivity::class.java))
                                    }
                                )
                                SButton(
                                    text = "REGISTER",
                                    colors = listOf(
                                        Color(0xFFF88826),
                                        Color(0xFFFFB472)
                                    ),
                                    onClick = {
                                        startActivity(Intent(this@FirstScreenActivity,RegisterActivity::class.java))
                                    }
                                )
                            }
                            SButton(
                                text = "BROWSE AS GUEST",
                                colors = listOf(
                                    Color(0xFFF46833),
                                    Color(0xFFFF936A)
                                ),
                                onClick = {
                                    coroutineScope.launch {
                                        db.optionsDao().insertOption(Options(10,"name","Guest","User"))
                                    }

                                    startActivity(Intent(this@FirstScreenActivity,MainActivity::class.java))
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
