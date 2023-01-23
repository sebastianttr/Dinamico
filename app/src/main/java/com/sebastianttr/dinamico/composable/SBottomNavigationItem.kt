@file:OptIn(ExperimentalAnimationApi::class)

package com.sebastianttr.dinamico.composable
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sebastianttr.dinamico.R

@Composable
fun SBottomNavigationItem(
    name: String,
    selected: Boolean = false,
    resIdSelected: Int = R.drawable.ic_launcher_foreground,
    resIdUnselected: Int,
    onClick: () -> Unit = {}
) {
    val fadeInTrans: EnterTransition = fadeIn(
        animationSpec = tween(durationMillis = 300, easing = CubicBezierEasing(.42f,0f,1f,1f)),
    )

    val fadeOutTrans: ExitTransition = fadeOut(
        animationSpec = tween(durationMillis = 300, easing = CubicBezierEasing(0f,0f,.58f,1f)),
    )

    Box{
        AnimatedVisibility(
            visible = selected,
            enter = fadeInTrans,
            exit = fadeOutTrans
        ) {
            IconButton(
                modifier = Modifier
                    .fillMaxHeight(),
                onClick = {
                    onClick.invoke()
                }) {
                Image(
                    modifier = Modifier
                        .height(40.dp),
                    painter = painterResource(resIdSelected),
                    contentDescription = name
                )
            }
        }
        AnimatedVisibility(
            visible = !selected,
            enter = fadeInTrans,
            exit = fadeOutTrans
        ) {
            IconButton(
                modifier = Modifier
                    .fillMaxHeight(),
                onClick = {
                    onClick.invoke()
                }) {
                Image(
                    modifier = Modifier
                        .height(40.dp),
                    painter = painterResource(resIdUnselected),
                    contentDescription = name
                )
            }
        }
    }



}