package com.sebastianttr.dinamico

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.sebastianttr.dinamico.clients.UserClient
import com.sebastianttr.dinamico.clients.UserClientService
import com.sebastianttr.dinamico.composable.SButton
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.models.User
import com.sebastianttr.dinamico.models.VehicleModel
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.dinamico.ui.theme.Montserrat
import com.sebastianttr.room.database.AppDatabase
import com.sebastianttr.room.database.Database
import kotlinx.coroutines.launch

class PassedQuizActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SetDefaultSystemColors();

            var startAnimationFlag by remember {
                mutableStateOf(false)
            }

            val context = LocalContext.current
            val vehicleData: VehicleModel = intent.getSerializableExtra("carData") as VehicleModel

            var coroutineScope = rememberCoroutineScope()
            val userClientAPI = UserClientService.getInstance().create(UserClient::class.java)

            lateinit var db: AppDatabase
            val ctx = LocalContext.current

            coroutineScope.launch {
                db = Database.getDb(ctx)
            }

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
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.fireworks))

                    LottieAnimation(composition, iterations = LottieConstants.IterateForever, modifier = Modifier.fillMaxWidth().offset(y = 40.dp))

                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .padding(top = 194.dp)
                                .fillMaxWidth()
                                .align(Alignment.TopCenter)
                        ){
                            Text(
                                modifier = Modifier.align(Alignment.TopCenter),
                                text = "Congratulations!",
                                style = TextStyle(
                                    color = Color(0xFF9398E1),
                                    fontWeight = FontWeight.Black,
                                    fontSize = 36.sp,
                                    fontFamily = Montserrat,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxHeight()
                        ){
                            Box(
                                modifier = Modifier
                                    .padding(
                                        top = 48.dp,
                                        start = 4.5.dp,
                                        end = 4.5.dp
                                    )
                                    .fillMaxWidth()
                            ){
                                Image(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(300.dp)
                                    ,
                                    painter = painterResource(id = R.drawable.ic_car_platform),
                                    contentDescription = "car_platform",
                                )
                                Box(modifier = Modifier
                                    .size(300.dp)
                                    .offset(y = 224.dp, x = (-48).dp)
                                    .align(Alignment.Center)
                                ) {
                                    Text(
                                        modifier = Modifier.align(Alignment.TopCenter),
                                        text = vehicleData.name,
                                        style = TextStyle(
                                            fontSize = 32.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Black,
                                            textAlign = TextAlign.Center,
                                            fontStyle = FontStyle.Italic
                                        )
                                    )
                                }

                                Image(
                                    modifier = Modifier
                                        .size(200.dp)
                                        .padding(top = 55.dp, start = 10.dp)
                                        .align(Alignment.Center)
                                        ,
                                    painter = painterResource(id = vehicleData.imgResIdOwn),
                                    contentDescription = "car_picture",
                                )
                            }
                            Text(
                                text = "You have obtained this model",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp,
                                    fontFamily = Montserrat,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .align(Alignment.CenterHorizontally)
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
                                    coroutineScope.launch {
                                        val user = User(
                                            db.optionsDao().findAllByKey("name")[0].value!!,
                                            db.optionsDao().findAllByKey("email")[0].value!!,
                                            db.optionsDao().findAllByKey("password")[0].value!!,
                                            vehicleData.id,
                                        )

                                        userClientAPI.addOwnedCarModel(
                                            user
                                        )
                                    }

                                    context.startActivity(Intent(context,MainActivity::class.java))
                                    finish()
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}