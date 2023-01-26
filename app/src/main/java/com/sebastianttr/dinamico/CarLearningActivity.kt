package com.sebastianttr.dinamico

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sebastianttr.dinamico.composable.*
import com.sebastianttr.dinamico.layouts.dpToPx
import com.sebastianttr.dinamico.models.VehicleModel
import com.sebastianttr.dinamico.ui.theme.AccentLight
import com.sebastianttr.dinamico.ui.theme.AccentStrong
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.dinamico.ui.theme.Montserrat

class CarLearningActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()

            val context = LocalContext.current

            systemUiController.setStatusBarColor(
                color = Color(0xFFFBAB18)
            )

            val vehicleData: VehicleModel = intent.getSerializableExtra("carData") as VehicleModel

            DinamicoTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(
                            modifier = Modifier
                                .padding(0.dp)
                                .height(80.dp)
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color(0xFFFBAB18),
                                            Color(0xFFFEDE00)
                                        ),
                                        startY = 0.dp.dpToPx(),
                                        endY = 80.dp.dpToPx()
                                    )
                                )
                                .zIndex(2f),
                            title = {
                                Text(
                                    "Learning",
                                    modifier = Modifier.padding(start = 8.dp),
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Black
                                )
                            },
                            backgroundColor = Color.Transparent,
                            actions = {
                                IconButton(
                                    modifier = Modifier.padding(end = 16.dp),
                                    onClick = {
                                        finish()
                                    }
                                ) {
                                    Image(
                                        modifier = Modifier.rotate(90f),
                                        painter = painterResource(id = R.drawable.ic_arrow_down_up),
                                        contentDescription = "arrow_up_down"
                                    )
                                }
                            },
                            elevation = 0.dp
                        )
                        Box(
                            modifier =
                            Modifier
                                .offset(y = 80.dp)
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(
                                    Color(0xFF8E7C00)
                                )
                        )
                    }
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF111224),
                                        Color(0xFF25284F)
                                    ),
                                    startY = 300.dp.dpToPx(),
                                    endY = (LocalConfiguration.current.screenHeightDp.dp + 300.dp).dpToPx()
                                )
                            )
                            .fillMaxHeight()
                    ) {
                        item { IntroductionHeader("${vehicleData.brand} ${vehicleData.name}",vehicleData.coverImgResId) }
                        item {
                            Column(
                                modifier = Modifier.padding(horizontal = 16.dp)
                            ) {
                                Text(
                                    text = "Key information",
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 22.sp,
                                        color = Color.White
                                    )
                                )

                                var i = 0

                                SBorderedColumn {
                                    for(vehicleInfo in vehicleData.vehicleKeyInfo){
                                        SBorderedColumnItemTitle(text = vehicleInfo.category)
                                        for(vehicleStat in vehicleInfo.stat){
                                            SBorderedColumnDescriptionItem(key = vehicleStat.stat, value = vehicleStat.description)
                                        }

                                        i++;
                                        if(i < vehicleData.vehicleKeyInfo.size)
                                            SBorderedColumnItemDivider()
                                    }
                                }

                                ParagraphDivider(32.dp)

                                i = 0

                                for(vehicleDescription in vehicleData.vehicleDescription){
                                    Paragraph(
                                        title = vehicleDescription.title,
                                        content = vehicleDescription.text
                                    )

                                    i++;
                                    if(i < vehicleData.vehicleKeyInfo.size)
                                        ParagraphDivider(32.dp)
                                }
                            }
                        }
                        item {
                            Column(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    modifier = Modifier
                                        .padding(vertical = 40.dp)
                                        .height(36.dp)
                                        .fillMaxWidth(),
                                    painter = painterResource(id = R.drawable.checker), 
                                    contentDescription = "checker"
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.CenterHorizontally)
                                        .padding(vertical = 10.dp),
                                    text = "Are you ready to test yourself and obtain this car?",
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        color = Color.White,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 26.sp,
                                        textAlign = TextAlign.Center
                                    )
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.CenterHorizontally)
                                        .padding(vertical = 16.dp),
                                    text = "Don’t make mistakes or you’ll fail!",
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        color = AccentStrong,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center,
                                    )
                                )
                                Box(modifier = Modifier.padding(top = 120.dp, bottom = 24.dp)){
                                    SButton(
                                        text = "TAKE TEST",
                                        colors = listOf(
                                            Color(0xFFFBA818),
                                            Color(0xFFFEDE00)
                                        ),
                                        onClick = {
                                            // Go to the right quiz.
                                            context.startActivity(
                                                Intent(context,QuizActivity::class.java)
                                                    .putExtra("carData",vehicleData)
                                            )

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

@Composable
fun IntroductionHeader(name: String, img: Int){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) { // Top Image with car text
        val painter = painterResource(img)

        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painter,
            contentScale = ContentScale.FillWidth,
            contentDescription = "car_picture"
        )
        Box(
            modifier = Modifier
                .height(3.dp)
                .fillMaxWidth()
                .background(AccentLight)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-26).dp),
            text = name,
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                color = Color.White,
                shadow = Shadow(
                    color = Color(0xFF000000),
                    blurRadius = 16f
                ),
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun Paragraph(
    title: String,
    content: String
){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        text = title,
        style = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            color = Color.White
        )
    )
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = content,
        style = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )
    )
}

@Composable
fun ParagraphDivider(
    size: Dp
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(size))
}



