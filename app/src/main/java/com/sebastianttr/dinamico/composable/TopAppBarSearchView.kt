package com.sebastianttr.dinamico.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.sebastianttr.dinamico.layouts.dpToPx
import com.sebastianttr.dinamico.R


@Composable
fun TopAppBarSearchView(
    searchSectionState: Boolean
) {
    var carList = mapOf<String, Int>(
        "Lexus" to R.drawable.lexus_logo,
        "Dacia" to R.drawable.dacia_logo,
        "Porsche" to R.drawable.porsche_logo,
        "Bugatti" to R.drawable.bugatti_logo,
        "Bugatti2" to R.drawable.bugatti_logo,
        "Bugatti3" to R.drawable.bugatti_logo,
        "Bugatti4" to R.drawable.bugatti_logo,
    )

    val scrollState: ScrollState = rememberScrollState()
    var searchTextValue by remember { mutableStateOf("") }
    var textFieldFocused by remember { mutableStateOf(false) }


    AnimatedVisibility(
        visible = searchSectionState,
        enter = expandVertically (
            animationSpec = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            clip = true
        ),
        exit = shrinkVertically (
            animationSpec = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            clip = true
        )
    ) {
        Box(
            modifier = Modifier
                .zIndex(1f)
                .height(120.dp)
        ) {
            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFEDE00),
                                Color(0xFFFFD181)
                            ),
                            startY = 0.dp.dpToPx(),
                            endY = 100.dp.dpToPx()
                        )
                    )
            ) {
                Column() {
                    Row(
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .horizontalScroll(scrollState)
                    ){
                        Spacer(modifier = Modifier.width(32.dp))
                        carList.forEach{
                            Image(
                                modifier = Modifier.height(36.dp),
                                painter = painterResource(id = it.value),
                                contentDescription = it.key
                            )
                            Spacer(modifier = Modifier.width(32.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    STextFieldMinimal(
                        hint = "Search the car model for this brand",
                        text = searchTextValue,
                        onValueChanged = {
                            searchTextValue = it
                        }
                    )
                }
            }
            Box(
                modifier =
                Modifier
                    .offset(y = 118.dp)
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(
                        Color(0xFFA78A53)
                    )
            )
        }
    }
}