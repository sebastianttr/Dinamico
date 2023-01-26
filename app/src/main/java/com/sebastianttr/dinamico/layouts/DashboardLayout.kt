@file:OptIn(ExperimentalFoundationApi::class)

package com.sebastianttr.dinamico.layouts

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.GridLayout
import android.widget.GridView
import androidx.annotation.Px
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Rect.Companion.Zero
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.horizontalGradient
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat.startActivity
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sebastianttr.dinamico.CarLearningActivity
import com.sebastianttr.dinamico.QuizActivity
import com.sebastianttr.dinamico.R
import com.sebastianttr.dinamico.clients.UserClient
import com.sebastianttr.dinamico.clients.UserClientService
import com.sebastianttr.dinamico.composable.DashboardVehicleItem
import com.sebastianttr.dinamico.composable.SButton
import com.sebastianttr.dinamico.composable.TopAppBarSearchView
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.models.User
import com.sebastianttr.dinamico.models.VehicleModel
import com.sebastianttr.dinamico.models.listOfCars
import com.sebastianttr.dinamico.ui.theme.*
import com.sebastianttr.room.database.AppDatabase
import com.sebastianttr.room.database.Database
import com.sebastianttr.room.database.dbOptions
import kotlinx.coroutines.launch

@Composable
fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition",
    "UnrememberedMutableState"
)
@Preview
@Composable
fun DashboardLayout(){
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    var searchSectionState by remember { mutableStateOf(false)}
    var topButtonText by remember { mutableStateOf("OWNED MODELS") }

    val arrowRotateAnimation: Float by animateFloatAsState(
        targetValue = if (searchSectionState) -180f else 0f,
        animationSpec = tween(
            durationMillis = 0,
            easing = FastOutSlowInEasing
        )
    )

    val context = LocalContext.current

    var carsList by remember {
        mutableStateOf(listOfCars)
    };

    val coroutineScope = rememberCoroutineScope()
    val userClientAPI = UserClientService.getInstance().create(UserClient::class.java)

    lateinit var db: AppDatabase
    val ctx = LocalContext.current

    var ownedModels by remember {
        mutableStateOf(emptyList<Int>())
    }

    coroutineScope.launch {
        db = Database.getDb(ctx)




        if(db.optionsDao().findAllByKey("name")[0].value != "Guest"){
            val user = User(
                db.optionsDao().findAllByKey("name")[0].value!!,
                db.optionsDao().findAllByKey("email")[0].value!!,
                db.optionsDao().findAllByKey("password")[0].value!!,
            )

            Log.i("dwa","Getting: ${user.email} ${user.name}")

            ownedModels = userClientAPI.getOwnedCarModel(
                User(
                    db.optionsDao().findAllByKey("name")[0].value!!,
                    db.optionsDao().findAllByKey("email")[0].value!!,
                    db.optionsDao().findAllByKey("password")[0].value!!,
                )
            ).body()!!
        }

        Log.i("dwa","Got it")


    }

    SetDefaultSystemColors(Color(0xFFFBAB18))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(0.dp)
                    .height(80.dp)
                    .background(
                        verticalGradient(
                            colors = listOf(
                                Color(0xFFFBAB18),
                                Color(0xFFFEDE00)
                            ),
                            startY = 0.dp.dpToPx(),
                            endY = 80.dp.dpToPx()
                        )
                    )
                    .zIndex(2f)
                ,
                title = {
                    Image(
                        modifier = Modifier.height(60.dp),
                        painter = painterResource(id = R.drawable.ic_ferrari_logo),
                        contentDescription = "Ferrari",
                    )
                    Text(
                        "FERRARI",
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
                            searchSectionState = !searchSectionState;
                        }
                    ) {
                        Image(
                            modifier = Modifier.rotate(arrowRotateAnimation),
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
    ){
        Column(
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
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LazyColumn(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                item {
                    Box(
                        modifier = Modifier.padding(top = 32.dp)
                    ){
                        SButton(
                            text = topButtonText,
                            width = 350.dp,
                            onClick = {
                                if(topButtonText == "OWNED MODELS"){
                                    topButtonText = "ALL CARS"

                                    // get all models and filter

                                    carsList = listOfCars.filter { it.id in ownedModels }
                                }else {
                                    topButtonText = "OWNED MODELS"
                                    carsList = listOfCars
                                }
                            }
                        )
                    }
                }
                items(carsList.size) { index ->
                    if(index % 2 == 0){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ){
                            DashboardVehicleItem(
                                item = carsList[index],
                                owned = carsList[index].id in ownedModels,
                                onClick = {
                                context.startActivity(
                                    Intent(context,CarLearningActivity::class.java)
                                        .putExtra("carData",carsList[index])
                                )
                            })
                            if(index + 1 < carsList.size)
                                DashboardVehicleItem(
                                    item = carsList[index+1],
                                    owned = carsList[index+1].id in ownedModels,
                                    onClick = {
                                    context.startActivity(
                                        Intent(context,CarLearningActivity::class.java)
                                            .putExtra("carData",carsList[index+1])
                                    )
                                })
                        }
                    }
                }
                item {
                    Box(modifier = Modifier
                        .height(62.dp)
                        .fillMaxWidth())
                }
            }
        }
        TopAppBarSearchView(searchSectionState = searchSectionState)
    }

}