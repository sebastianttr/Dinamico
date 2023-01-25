@file:OptIn(ExperimentalFoundationApi::class)

package com.sebastianttr.dinamico.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.R
import com.sebastianttr.dinamico.layouts.listOfCars
import com.sebastianttr.dinamico.models.VehicleModel

@Composable
fun DashboardVehicleItem(
    item: VehicleModel,
    onClick: () -> Unit = {}
){
    Box(
        modifier = Modifier.padding(
            top = 48.dp,
            start = 4.5.dp,
            end = 4.5.dp
        )
            .clickable { onClick.invoke() }
    ){
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_car_platform),
            contentDescription = "car_platform"
        )
        Box(modifier = Modifier
            .width(100.dp)
            .offset(y = 54.dp, x = (-28).dp)
            .align(Alignment.Center)
        ) {
            Text(
                modifier = Modifier.align(Alignment.TopCenter),
                text = item.name,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic
                )
            )
        }

        Image(
            modifier = Modifier
                .size(130.dp)
                .padding(top = 25.dp, start = 10.dp)
                .align(Alignment.Center),
            painter = painterResource(id = item.imgResId),
            contentDescription = "car_picture"
        )
    }

}