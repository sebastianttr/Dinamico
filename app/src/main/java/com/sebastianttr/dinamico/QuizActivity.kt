@file:OptIn(ExperimentalFoundationApi::class)

package com.sebastianttr.dinamico

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.composable.SButton
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.layouts.listOfCars
import com.sebastianttr.dinamico.models.VehicleQuiz
import com.sebastianttr.dinamico.ui.theme.*
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.cancel
import kotlin.math.pow
import kotlin.math.sin


val quiz:List<VehicleQuiz> = listOf(
    VehicleQuiz(0,"When was the LaFerrari released?", listOf("2012","2018","2013","2010"),3),
    VehicleQuiz(1,"What are the the variants that existed", listOf("Sedan","Coupe & Aperta","Coupe","SUV"),2),
    VehicleQuiz(2,"What was the max power output of the car?", listOf("950hp","900hp","650hp","1000hp"),1),
    VehicleQuiz(3,"The LaFerrari had a Top Speed of ___ km/h.", listOf("312","389","297","352"),4)
)

class QuizActivity : ComponentActivity() {

    private lateinit var timer: CountDownTimer

    companion object {
        var passed = false
        var failed = false
        var revCounterLimitFrequency: Float = 2f
        var failedMessage: String = ""
        val timeToAnswerQuizzes = 20000
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SetDefaultSystemColors()

            var quizIndex by remember { mutableStateOf(0) };
            var selection by remember { mutableStateOf(-1) }
            var revCounter by remember { mutableStateOf(0.0f) }
            var revCounterColor by remember { mutableStateOf(Color(0xFF387938)) }

            var changeActivity by remember {
                mutableStateOf(false)
            };


            val context:Context = LocalContext.current

            val leaveAnimationsState: Float by animateFloatAsState(
                targetValue = if (!changeActivity) 1f else 0f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                ),
                finishedListener = {
                    Log.i("He", "Changing Activity")
                    if(failed){
                        Log.i("Going to FailedQuiz","")
                        finish()
                        context.startActivity(Intent(context,FailedQuizActivity::class.java)
                            .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            .putExtra("msg",failedMessage)
                        )
                    }
                    else if (passed){
                        Log.i("Going to PassedQuiz","")
                        finish()
                        context.startActivity(Intent(context,PassedQuizActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
                    }
                }
            )


            timer = object : CountDownTimer(timeToAnswerQuizzes.toLong(), 10) {
                override fun onTick(millisUntilFinished: Long) {

                    if (revCounter >= .99f && !passed){
                        revCounter = 1.0f
                        failed = true
                        changeActivity = true;
                        Log.i("Change activity now","")
                        failedMessage = "You revved the car too much and your engine failed."
                        cancel()
                    }else{
                        revCounter = (timeToAnswerQuizzes.toFloat() - millisUntilFinished) / timeToAnswerQuizzes.toFloat()

                        if(revCounter < 0.6f)
                            revCounterColor = Color(0xFF387938)
                        else if(revCounter < 0.75f)
                            revCounterColor = Color(0xFFD68A2C)
                        else if (revCounter > 0.75f){
                            revCounterLimitFrequency *= 1.012f
                            //Log.i("Freq", "Frequency : " + sin(2 * Math.PI * revCounterLimitFrequency).toFloat()*0.5f)
                            revCounterColor = Color(0xFFD62C2C)
                                .copy(0.5f + (sin(2 * Math.PI * revCounterLimitFrequency).toFloat()*0.5f))
                        }

                    }
                }
                override fun onFinish() {
                    cancel()
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
                        ),
                    color = Color.Transparent
                ) {
                    Box(modifier = Modifier
                        .alpha(leaveAnimationsState)
                    ){
                        // Top Rev Counter
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .background(Color(0xFF25284F))
                        ){
                            Box(modifier = Modifier
                                .align(Alignment.CenterStart)
                                .fillMaxHeight()
                                .fillMaxWidth(revCounter)
                                .background(revCounterColor)
                            )
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .align(Alignment.Center)
                            ){
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.Center),
                                    text = "${(100f*revCounter).toInt()}00 RPM",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 12.sp,
                                        color = Color.White
                                    )
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(80.dp, Alignment.CenterVertically),
                        ) {
                            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "${quizIndex + 1} / ${quiz.size}",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Black,
                                        fontStyle = FontStyle.Italic,
                                        fontFamily = Montserrat,
                                        color = AccentStrong
                                    )
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = quiz[quizIndex].question,
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Black,
                                        fontFamily = Montserrat,
                                        color = Color.White
                                    )
                                )
                            }
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                content = {
                                    items(4) { index ->
                                        Box(
                                            modifier = Modifier
                                                .size(172.dp)
                                                .border(
                                                    width = 2.dp,
                                                    shape = RoundedCornerShape(
                                                        corner = CornerSize(
                                                            16.dp
                                                        )
                                                    ),
                                                    color =
                                                    if (selection == index)
                                                        AccentStrong
                                                    else
                                                        Color(0xFF434456)
                                                )
                                                .clip(RoundedCornerShape(16.dp))
                                                .clickable {
                                                    selection = index
                                                }
                                        ){
                                            Text(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .fillMaxHeight()
                                                    .wrapContentHeight(align = Alignment.CenterVertically),
                                                text = quiz[quizIndex].answers[index],
                                                textAlign = TextAlign.Center,
                                                color = Color.White
                                            )
                                        }
                                    }
                                },
                                //contentPadding = PaddingValues(10.dp),
                            )
                            Box(modifier = Modifier.alpha(if (selection > -1) 1f else 0f)){
                                SButton(
                                    text = "CONTINUE",
                                    height = 40.dp,
                                    colors = listOf(
                                        Color(0xFFFBAB18),
                                        Color(0xFFFEDE00)
                                    ),
                                    onClick = {
                                        if(quizIndex + 1 < quiz.size && selection + 1 == quiz[quizIndex].correctAnswer){
                                            quizIndex++
                                            selection = -1;
                                            Log.i("Increase", "Increasing: $quizIndex")
                                        }
                                        else if (selection + 1 != quiz[quizIndex].correctAnswer){
                                            selection = -1;
                                            failed = true;
                                            changeActivity = true;
                                            failedMessage = "Your answer was wrong ... that might come costly."
                                        }
                                        else {
                                            passed = true
                                            changeActivity = true;
                                        }
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

