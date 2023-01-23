package com.sebastianttr.dinamico.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.R

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
                modifier = Modifier.align(Alignment.CenterEnd).clickable {
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
                .background(if(!textFieldFocused) Color(0xFF806A33) else Color(0xFF000000)),
        )
    }
}