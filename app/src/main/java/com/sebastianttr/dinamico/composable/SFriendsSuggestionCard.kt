package com.sebastianttr.dinamico.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.R
import com.sebastianttr.dinamico.ui.theme.MainStrong
import com.sebastianttr.dinamico.ui.theme.Montserrat

@Composable
fun SFriendsSuggestionCard(){
    Column(modifier = Modifier
        .padding(horizontal = 5.dp)
        .height(165.dp)
        .width(123.dp)
        .fillMaxHeight()
        .border(
            width = 2.dp,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            color = Color(0xFF434456)
        ),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)){
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(MainStrong)
                        .border(
                            shape = CircleShape,
                            width = 2.dp,
                            color = Color.White
                        )
                        .align(Alignment.TopCenter)
                )
                Image(
                    modifier = Modifier.align(Alignment.TopEnd),
                    painter = painterResource(id = R.drawable.ic_cancel),
                    contentDescription = "friend remove suggestion"
                )
            }
            Text(
                text = "User",
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                ),
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Text(
                text = "16 Car Models",
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFF46833)
                ),
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
        SButton(
            text = "ADD",
            fontSize = 12.sp,
            width = 100.dp,
            height = 20.dp,
            colors = listOf(
                Color(0xFFFBAB18),
                Color(0xFFFEDE00)
            )
        )

    }
}