package com.sebastianttr.dinamico.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.sebastianttr.dinamico.layouts.dpToPx
import com.sebastianttr.dinamico.ui.theme.Montserrat
import com.sebastianttr.dinamico.ui.theme.Typography
import java.util.concurrent.CancellationException

@Preview
@Composable
fun SButton(
    text: String = "Button",
    width: Dp = LocalConfiguration.current.screenWidthDp.dp,
    height: Dp = 44.dp,
    colors: List<Color> = listOf(
        Color(0xFF646CDB),
        Color(0xFF9398E1)
    ),
    fontColor: Color = Color.Black,
    onClick: () -> Unit = {},
    fontSize: TextUnit = Typography.h3.fontSize,
    padding: Dp = 0.dp
){
    var onClickOffset by remember {
        mutableStateOf(0.dp)
    }

    Box() {
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
        ){
            Box(modifier = Modifier.align(Alignment.TopCenter)
                .clip(RoundedCornerShape(8.dp))
                .background(colors[0])
                .height(height-4.dp)
                .width(width))
        }
        Box(
            modifier = Modifier.padding(top = onClickOffset)
        ){
            Box(modifier = Modifier.clip(RoundedCornerShape(8.dp))){
                Box(modifier = Modifier
                    .width(width)
                    .height(height-4.dp)
                    .align(Alignment.TopCenter)
                    .background(
                        Brush.verticalGradient(
                            colors,
                            startY = 0.dp.dpToPx(),
                            endY = (height - 4.dp).dpToPx()
                        )
                    )
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                onClickOffset = 4.dp;
                                //start
                                val released = try {
                                    tryAwaitRelease()
                                } catch (c: CancellationException) {
                                    false
                                }
                                if (released) {
                                    //ACTION_UP
                                    onClickOffset = 0.dp;
                                } else {
                                    //CANCELED
                                }
                            },
                            onTap = {
                                onClick()
                            },
                        )
                    }
                ){
                    Text(
                        text,
                        style = TextStyle(
                            color = fontColor,
                            fontStyle = FontStyle.Italic,
                            fontSize = fontSize,
                            fontWeight = FontWeight.Black,
                            textAlign = TextAlign.Center,
                            fontFamily = Montserrat,
                        ),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}