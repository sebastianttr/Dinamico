package com.sebastianttr.dinamico.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.R
import com.sebastianttr.dinamico.ui.theme.Montserrat

@Composable
fun STextFieldMinimal(
    hint:String,
    text:String,
    onValueChanged: (value:String) -> Unit
){
    var txt:String by remember { mutableStateOf("")}
    var textFieldFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .height(28.dp)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
                .align(Alignment.CenterStart)
                .onFocusChanged {
                    textFieldFocused = it.isFocused
                },
            value = text,
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
            maxLines = 1,
            onValueChange = {
                txt = it
                if(it.length <= 40)
                    onValueChanged.invoke(it)
            },
        )
        if(text.isEmpty())
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = "Search the car model for this brand",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color(0xFF806A33)
                )
            )
        if(txt.isNotEmpty())
            Icon(
                Icons.Filled.Close,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable {
                        txt = ""
                        onValueChanged.invoke(txt)
                    },
                contentDescription = "clear_input",
            )
        else
            Image(
                modifier = Modifier.align(Alignment.CenterEnd),
                painter = painterResource(id = R.drawable.ic_magnifyingglass),
                contentDescription = "magnifying_glasses",
                colorFilter = ColorFilter.tint(if(!textFieldFocused) Color(0xFF806A33) else Color(0xFF000000))
            )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(2.dp)
                .background(if (!textFieldFocused) Color(0xFF806A33) else Color(0xFF000000)),
        )
    }
}


@Composable
fun STextField(
    hint:String = "",
    text:String,
    onValueChanged: (value:String) -> Unit,
    height: Dp = 28.dp,
    inputDescription: String = ""
){
    var txt:String by remember { mutableStateOf("")}
    var textFieldFocused by remember { mutableStateOf(false) }

    Column(

    ) {
        if(inputDescription.isNotEmpty())
            Text(
                inputDescription,
                style = TextStyle(
                    color = Color(0xFF686A87),
                    fontFamily = Montserrat,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                ),
                modifier = Modifier.padding(vertical = 10.dp)
            )
        Box(
            modifier = Modifier
                .height(height)
                .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                    color = Color(0xFF434456)
                )


        ) {
            Box(modifier = Modifier.background(Color(0xFF25284F)).fillMaxHeight()){
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .align(Alignment.CenterStart)
                        .onFocusChanged {
                            textFieldFocused = it.isFocused
                        },
                    value = text,
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White
                    ),
                    maxLines = 1,
                    onValueChange = {
                        txt = it
                        if(it.length <= 40)
                            onValueChanged.invoke(it)
                    },
                    cursorBrush = SolidColor(Color.White)
                )
                if(text.isEmpty())
                    Text(
                        modifier = Modifier.align(Alignment.CenterStart),
                        text = hint,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFF806A33)
                        )
                    )
                if(txt.isNotEmpty())
                    Icon(
                        Icons.Filled.Close,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .clickable {
                                txt = ""
                                onValueChanged.invoke(txt)
                            }
                            .padding(end = 16.dp),
                        contentDescription = "clear_input",
                        tint = Color.White
                    )
            }
        }
    }

}