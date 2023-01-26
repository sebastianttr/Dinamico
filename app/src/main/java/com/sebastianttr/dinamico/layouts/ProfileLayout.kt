package com.sebastianttr.dinamico.layouts

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sebastianttr.dinamico.R
import com.sebastianttr.dinamico.composable.*
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.ui.theme.*
import com.sebastianttr.room.database.AppDatabase
import com.sebastianttr.room.database.Database
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ProfileLayout(){

    SetDefaultSystemColors(Color(0xFF4E1F0E))

    val coroutineScope = rememberCoroutineScope()
    lateinit var db: AppDatabase
    val ctx = LocalContext.current
    var user: String by remember {
        mutableStateOf("Guest")
    }

    coroutineScope.launch {
        db = Database.getDb(ctx)

        user = db.optionsDao().findAllByKey("name")[0].value!!
    }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
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
            .padding(bottom = 42.dp)
    ){
        item { ProfileHeader() }
        item { BasicInfoItem() }
        if(user != "Guest"){
            item { Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ConnectionsSection()
                GarageSection()
                DailyChallengesSection()
                FriendSuggestionItem()
            }}
        }
        else item {
            Box(modifier = Modifier.fillMaxWidth().height(400.dp)){
                Text(text = "Please log in to use all features",
                    style = TextStyle(
                        fontFamily = Montserrat,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AccentStrong,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileHeader(){   // Top Image with banner an
    Box(modifier = Modifier){
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.profile_background),
                contentScale = ContentScale.FillWidth,
                contentDescription = "car_picture"
            )
            Box(
                modifier = Modifier
                    .height(4.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )
            Image(
                painter = painterResource(id = R.drawable.edit_img),
                contentDescription = "Edit Image Profile Picture",
                modifier = Modifier
                    .size(24.dp)
                    .offset(x = 10.dp, y = (-12).dp)
            )
        }
        Box(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(top = 96.dp)
        ){
            Box(
                modifier = Modifier
                    .size(124.dp)
                    .clip(CircleShape)
                    .background(MainStrong)
                    .border(
                        shape = CircleShape,
                        width = 4.dp,
                        color = Color.White
                    )
            )
            Image(
                painter = painterResource(id = R.drawable.edit_img),
                contentDescription = "Edit Image Profile Picture",
                modifier = Modifier
                    .size(24.dp)
                    .offset(x = 95.dp, y = 10.dp)
            )
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BasicInfoItem(){
    val coroutineScope = rememberCoroutineScope()
    lateinit var db: AppDatabase
    val ctx = LocalContext.current

    var userName by remember {
        mutableStateOf("")
    }

    coroutineScope.launch {
        db = Database.getDb(ctx)
        userName = db.optionsDao().findAllByKey("name")[0].value!!
    }


    Text(
        text = userName,
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 26.sp,
            fontFamily = Montserrat,
            textAlign = TextAlign.Center,
            color = Color.White
        ),
        modifier = Modifier.padding(top = 14.dp)
    )
}

@Composable
fun ConnectionsSection(){
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "0 Car Models",
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                fontFamily = Montserrat,
                textAlign = TextAlign.Center,
                color = AccentStrong
            ),
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 14.dp)
        )
        Text(
            text = "69 Enthusiasts",
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                fontFamily = Montserrat,
                textAlign = TextAlign.Center,
                color = AccentStrong
            ),
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 14.dp)
        )
    }
}

@Composable
fun GarageSection(){
    Column(modifier = Modifier.padding(top = 26.dp)) {
        Text(
            text = "Garage",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.White,
            )
        )
        SBorderedColumn {
            SBorderedColumnGarageItem (
                "Ferrari","Volkswagen",
                0,0
            )
            SBorderedColumnItemDivider()
            SBorderedColumnGarageItem (
                "BMW","Audi",
                0,0
            )
            SBorderedColumnItemDivider()
            SBorderedColumnGarageItem (
                "Porsche","Bugatti",
                0,0
            )
            SBorderedColumnItemDivider()
            SBorderedColumnGarageItem (
                "Mercedes","Lamborghini",
                0,0
            )
            SBorderedColumnItemDivider()
            SBorderedColumnGarageItem (
                "McLaren","Dacia",
                0,0
            )

        }
    }
}

@Composable
fun DailyChallengesSection(){
    Column(modifier = Modifier.padding(top = 40.dp)) {
        Text(
            text = "Daily Challenges",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.White,
            )
        )
        SBorderedColumn {
            SBorderedColumnDailyChallenges(R.drawable.challenge_fire,"Learn about 2 car models",1,2)
            SBorderedColumnItemDivider()
            SBorderedColumnDailyChallenges(R.drawable.challenge_brain,"Read at least 20 minutes",14,20)
            SBorderedColumnItemDivider()
            SBorderedColumnDailyChallenges(R.drawable.cahllenge_book,"Pass 3 tests with flying colors",1,3)
        }
    }
}

@Composable
fun FriendSuggestionItem(){
    Column(modifier = Modifier.padding(top = 40.dp)) {
        Text(
            text = "Enthusiasts suggestions",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.White,
            )
        )
        Row(
            Modifier
                .horizontalScroll(rememberScrollState())
                .padding(top = 16.dp, bottom = 20.dp)
        ) {
            SFriendsSuggestionCard()
            SFriendsSuggestionCard()
            SFriendsSuggestionCard()
            SFriendsSuggestionCard()
            SFriendsSuggestionCard()
            SFriendsSuggestionCard()
        }
        Box(modifier = Modifier
            .padding(top = 40.dp, bottom = 40.dp)
        ){
            SButton(
                text = "SEARCH MORE",
                colors = listOf(
                    Color(0xFFFBAB18),
                    Color(0xFFFEDE00)
                )
            )
        }
    }
}