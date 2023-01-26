package com.sebastianttr.dinamico

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.composable.SButton
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.dinamico.ui.theme.Montserrat
import kotlin.concurrent.timer

class FailedQuizActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SetDefaultSystemColors();

            var startAnimationFlag by remember {
                mutableStateOf(false)
            }

            val context = LocalContext.current

            val appearAnimation: Float by animateFloatAsState(
                targetValue = if (startAnimationFlag) 1f else 0f,
                animationSpec = tween(
                    durationMillis = 400,
                    easing = FastOutSlowInEasing
                )
            )

            val appearAnimationButton: Float by animateFloatAsState(
                targetValue = if (startAnimationFlag) 1f else 0f,
                animationSpec = tween(
                    delayMillis = 800,
                    durationMillis = 400,
                    easing = FastOutSlowInEasing
                )
            )

            object: CountDownTimer(100, 10){
                override fun onTick(p0: Long) {}
                override fun onFinish() {
                    startAnimationFlag = true
                }
            }.start()

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
                        )
                        .alpha(appearAnimation),
                    color = Color.Transparent
                ) {
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxHeight()
                        ){
                            Image(modifier = Modifier.fillMaxWidth(),
                                painter = painterResource(id = R.drawable.failed_img),
                                contentDescription = "Failure",
                                contentScale = ContentScale.FillWidth,
                            )
                            Text(
                                text = intent.getStringExtra("msg") ?: "No msg",
                                style = TextStyle(
                                    color = Color(0xFFDC5959),
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp,
                                    fontFamily = Montserrat,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }
                        Box(modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 70.dp)
                            .alpha(appearAnimationButton)
                        ){
                            SButton(
                                text = "TO GARAGE",
                                colors = listOf(
                                    Color(0xFFFBAB18),
                                    Color(0xFFFEDE00)
                                ),
                                onClick = {
                                    context.startActivity(Intent(context,MainActivity::class.java))
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}
