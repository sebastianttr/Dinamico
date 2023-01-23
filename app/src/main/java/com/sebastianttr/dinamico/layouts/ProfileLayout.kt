package com.sebastianttr.dinamico.layouts

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
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
import androidx.compose.ui.zIndex
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sebastianttr.dinamico.R
import com.sebastianttr.dinamico.composable.*
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.ui.theme.*

@Composable
fun ProfileLayout(){

    SetDefaultSystemColors(Color(0xFF4E1F0E))

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
        item { Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            GarageSection()
            DailyChallengesSection()
            FriendSuggestionItem()
        }}
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

@Composable
fun BasicInfoItem(){
    Text(
        text = "Your Name",
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            fontFamily = Montserrat,
            textAlign = TextAlign.Center,
            color = Color.White
        ),
        modifier = Modifier.padding(vertical = 14.dp)
    )
    Text(
        text = "Joined February 2022",
        style = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            fontFamily = Montserrat,
            textAlign = TextAlign.Center,
            color = Color.White
        ),
        // modifier = Modifier.padding(vertical = 14.dp)
    )

    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "13 Car Models",
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
            text = "28 Enthusiasts",
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
    Column() {
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
                Color(0xFFFF2800),Color(0xFFAAAAAA),
                "Ferrari","Lexus",
                3,4
            )
            SBorderedColumnItemDivider()
            SBorderedColumnGarageItem (
                Color(0xFFBF8F52),Color(0xFF4767D6),
                "Dacia","Bugatti",
                5,1
            )
        }
    }
}

@Composable
fun DailyChallengesSection(){
    Column() {
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
    Column() {
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
            .padding(bottom = 20.dp)
        ){
            SButton(
                text = "SEARCH MORE",
                height = 40.dp,
                colors = listOf(
                    Color(0xFFFBAB18),
                    Color(0xFFFEDE00)
                )
            )
        }
    }
}