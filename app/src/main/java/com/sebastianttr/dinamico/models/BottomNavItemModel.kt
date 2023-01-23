package com.sebastianttr.dinamico.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.sebastianttr.dinamico.config.Screen

data class BottomNavItemModel(
    val screen: Screen,
    val selectedResId: Int,
    val unselectedResId: Int,
    val selected: MutableState<Boolean> = mutableStateOf(false)
)