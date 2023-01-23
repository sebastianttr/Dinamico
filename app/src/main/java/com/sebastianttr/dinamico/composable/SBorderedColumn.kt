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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.R
import com.sebastianttr.dinamico.layouts.dpToPx
import com.sebastianttr.dinamico.ui.theme.Montserrat

@Composable
fun SBorderedColumn(
    content: @Composable () -> Unit
) {
    Column(modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth()
        .border(
            width = 2.dp,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            color = Color(0xFF434456)
        )
    ){
        content()
    }
}

@Composable
fun SBorderedColumnItemTitle(
    text: String
){
    Text(
        text = text,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        style = TextStyle(
            fontFamily = Montserrat,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    )
}

@Composable
fun SBorderedColumnDescriptionItem(
    key: String,
    value: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ){
        Text(
            text = key,
            style = TextStyle(
                fontFamily = Montserrat,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        )
        Text(
            text = value,
            style = TextStyle(
                fontFamily = Montserrat,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Right
            )
        )
    }
}

@Composable
fun SBorderedColumnItemDivider(){
    Box(
        modifier = Modifier
            .height(2.dp)
            .background(color = Color(0xFF434456))
            .fillMaxWidth(),
    )
}

@Composable
fun SBorderedColumnGarageItem(
    colorLeft: Color,
    colorRight: Color,
    textLeft: String,
    textRight: String,
    amountLeft: Int,
    amountRight: Int,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32.dp)
                    .background(colorLeft)
                    .align(Alignment.CenterVertically)
            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    text = amountLeft.toString(),
                    style = TextStyle(
                        fontFamily = Montserrat,
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Text(
                text = textLeft,
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontSize = 16.sp,
                    color = colorLeft,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic
                ),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = textRight,
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontSize = 16.sp,
                    color = colorRight,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic
                ),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32.dp)
                    .background(colorRight)
                    .align(Alignment.CenterVertically)
            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    text = amountRight.toString(),
                    style = TextStyle(
                        fontFamily = Montserrat,
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}

@Composable
fun SBorderedColumnDailyChallenges(
    imgResId: Int,
    title: String,
    fraction: Int,
    total: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row() {
            Image(
                painter = painterResource(id = imgResId),
                contentDescription = "",
                modifier = Modifier.height(45.dp),
                contentScale = ContentScale.FillHeight
            )
            Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = Montserrat,
                        color = Color.White
                    )
                )
                val fract = fraction.toFloat() / total.toFloat()
                Box(
                    modifier = Modifier
                        .height(14.dp)
                        .clip(RoundedCornerShape(100f))
                ){
                    Box(
                        Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight()
                            .background(Color(0xFF434456))
                    )
                    Box(
                        Modifier
                            .fillMaxWidth(fract * 0.8f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(100f))
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFFFF936A),
                                        Color(0xFFF46833)
                                    )
                                )
                            )
                    )
                }
            }
        }
        Text(
            text = "$fraction / $total",
            modifier = Modifier.align(Alignment.Bottom),
            style = TextStyle(
                fontFamily = Montserrat,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFF46833)
            )
        )
    }
}




