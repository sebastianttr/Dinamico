package com.sebastianttr.dinamico

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.room.util.appendPlaceholders
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.ui.theme.AccentLight
import com.sebastianttr.dinamico.ui.theme.AccentStrong
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.room.database.Database
import com.sebastianttr.room.entites.Options
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetDefaultSystemColors(
                topBarColor = Color(0xFF111224),
                navbarColor = Color(0xFF25284F)
            )

            lifecycleScope.launchWhenCreated {
                delay(2000)

                // Do something like load everything into the states.
                val db = Database.getDb(applicationContext)
                val userNameOption: List<Options> = db.optionsDao().findAllByKey("name")

                if(userNameOption.isNotEmpty() && userNameOption[0].value!!.isNotEmpty()){
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    val intent = Intent(this@SplashActivity, FirstScreenActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            var animateState by remember {
                mutableStateOf(false)
            }

            val animatedOpacity = animateFloatAsState(
                targetValue = if (animateState) 1.0f else 0f,
                animationSpec = tween(
                    durationMillis = 400,
                    delayMillis = 400,
                    easing = FastOutSlowInEasing
                )
            )

            object: CountDownTimer(100, 10){
                override fun onTick(p0: Long) {}
                override fun onFinish() {
                    animateState = true
                }
            }.start()


            DinamicoTheme {
                Box(
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
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dinamico_logo_big),
                        contentDescription = "Splashscreen",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .alpha(animatedOpacity.value)
                            .fillMaxWidth(0.8f)

                    )
                }
            }
        }
    }
}