package com.sebastianttr.dinamico.layouts

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.FirstScreenActivity
import com.sebastianttr.dinamico.clients.UserClient
import com.sebastianttr.dinamico.clients.UserClientService
import com.sebastianttr.dinamico.composable.*
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.models.User
import com.sebastianttr.dinamico.ui.theme.AccentStrong
import com.sebastianttr.dinamico.ui.theme.Montserrat
import com.sebastianttr.dinamico.utils.md5
import com.sebastianttr.dinamico.utils.toHex
import com.sebastianttr.room.database.AppDatabase
import com.sebastianttr.room.database.Database
import com.sebastianttr.room.entites.Options
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SettingsLayout(){
    SetDefaultSystemColors(topBarColor = Color(0xFF111224))

    var generalSettings: List<Options> by remember { mutableStateOf(listOf()) }
    var privacySettings: List<Options> by remember { mutableStateOf(listOf()) }
    val userClientAPI = UserClientService.getInstance().create(UserClient::class.java)

    var user: String by remember {
        mutableStateOf("Guest")
    }

    var newPassword by remember {
        mutableStateOf("")
    }
    var repeatNewPassword by remember {
        mutableStateOf("")
    }
    var errorMessage by remember {
        mutableStateOf("")
    }

    val coroutineScope = rememberCoroutineScope()
    lateinit var db: AppDatabase
    val ctx = LocalContext.current

    coroutineScope.launch {
        db = Database.getDb(ctx)

        generalSettings = db.optionsDao().findAllByTag("General")
        privacySettings = db.optionsDao().findAllByTag("Privacy")
        user = db.optionsDao().findAllByKey("name")[0].value!!
    }

    Surface(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF111224),
                        Color(0xFF25284F)
                    ),
                    startY = LocalConfiguration.current.screenHeightDp * 0.3f,
                    endY = LocalConfiguration.current.screenHeightDp * 1.3f
                )
            )
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        color = Color.Transparent
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            item {
                Column() {
                    if(user != "Guest"){
                        Text(
                            text = "Your profile",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            style = TextStyle(
                                fontFamily = Montserrat,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 22.sp,
                                color = Color.White,
                            )
                        )
                        STextField(
                            text = user,
                            onValueChanged = {
                                user = it
                            },
                            height = 42.dp,
                            inputDescription = "Name"
                        )
                        STextField(
                            text = newPassword,
                            onValueChanged = {
                                newPassword = it
                            },
                            height = 42.dp,
                            inputDescription = "New Password",
                            passwordVisibility = true
                        )
                        STextField(
                            text = repeatNewPassword,
                            onValueChanged = {
                                repeatNewPassword = it
                            },
                            height = 42.dp,
                            inputDescription = "Repeat Password",
                            passwordVisibility = true
                        )
                        Text(
                            text = errorMessage,
                            style = TextStyle(
                                fontFamily = Montserrat,
                                color = AccentStrong,
                                fontSize = 16.sp
                            )
                        )
                        Box(modifier = Modifier.padding(top = 16.dp)){
                            SButton(
                                text = "SAVE",
                                height = 40.dp,
                                colors = listOf(
                                    Color(0xFFFBAB18),
                                    Color(0xFFFEDE00)
                                ),
                                onClick = {
                                    coroutineScope.launch {
                                        db.optionsDao().updateOption(
                                            Options(10,"name",user,"User"),
                                        )

                                        if(user.length >= 10 &&
                                            newPassword == repeatNewPassword){
                                            db.optionsDao().insertOptions(
                                                listOf(
                                                    Options(10,"name",user,"User"),
                                                    Options(12,"password",newPassword,"User"),
                                                )
                                            )

                                            userClientAPI.updateUser(
                                                User(
                                                    name = user,
                                                    email = db.optionsDao().findAllByKey("email")[0].value!!,
                                                    password = md5(newPassword.ifEmpty { db.optionsDao().findAllByKey("password")[0].value!! }).toHex()
                                                )
                                            )
                                        }

                                        if(newPassword.isNotEmpty() && newPassword.length <= 10){
                                            errorMessage = "Password is too short"
                                        }

                                        if(newPassword != repeatNewPassword){
                                            errorMessage = "Repeated Password is not the same!"
                                        }

                                    }
                                }
                            )
                        }
                    }
                }
            }
            item {
                Column() {
                    Text(
                        text = "General Settings",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 22.sp,
                            color = Color.White,
                        )
                    )
                    SBorderedColumn {
                        Column() {
                            var i = 0;
                            for(option in generalSettings){
                                SBorderedColumnSettingsItemToggle(
                                    state = option.value.toBoolean(),
                                    text = option.key!!,
                                    onChange = {
                                        coroutineScope.launch {
                                            db.optionsDao().updateOption(option.copy(value = it.toString()))
                                            generalSettings = db.optionsDao().findAllByTag("General")
                                        }
                                    }
                                )
                                i++;
                                if(i+1 <= generalSettings.size)
                                    SBorderedColumnItemDivider()

                            }
                        }
                    }
                }
            }
            item {
                Column() {
                    Text(
                        text = "Privacy Settings",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 22.sp,
                            color = Color.White,
                        )
                    )
                    SBorderedColumn {
                        var i = 0;
                        for(option in privacySettings){
                            SBorderedColumnSettingsItemToggle(
                                state = option.value.toBoolean(),
                                text = option.key!!,
                                onChange = {
                                    coroutineScope.launch {
                                        db.optionsDao().updateOption(option.copy(value = it.toString()))
                                        privacySettings = db.optionsDao().findAllByTag("Privacy")
                                    }
                                }
                            )
                            i++;
                            if(i+1 <= privacySettings.size)
                                SBorderedColumnItemDivider()

                        }
                    }
                }
            }
            item {
                Column() {
                        Text(
                        text = "Delete Account",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 22.sp,
                            color = Color.White,
                        )
                    )
                    SBorderedColumn {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Are you sure you want to delete your account? That means all data will be lost (progress, name, friends, etc.).",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                        Box(modifier = Modifier.padding(16.dp)){
                            SButton(
                                text = "DELETE ACCOUNT",
                                height = 40.dp,
                                padding = 16.dp,
                                colors = listOf(
                                    Color(0xFFB91010),
                                    Color(0xFFDC5959)
                                ),
                                onClick = {
                                    coroutineScope.launch {

                                        userClientAPI.deleteUser(
                                            User(
                                                db.optionsDao().findAllByKey("name")[0].value!!,
                                                db.optionsDao().findAllByKey("email")[0].value!!,
                                                db.optionsDao().findAllByKey("password")[0].value!!
                                            )
                                        )

                                        db.optionsDao().deleteByKey("name")
                                        db.optionsDao().deleteByKey("email")
                                        db.optionsDao().deleteByKey("password")

                                        val intent = Intent(ctx.applicationContext, FirstScreenActivity::class.java)
                                        ctx.startActivity(intent)
                                    }
                                }
                            )
                        }
                    }
                }
            }

            item {
                Box(modifier = Modifier.padding(bottom = 60.dp)){
                    SButton(
                        text = "LOG OUT",
                        height = 40.dp,
                        colors = listOf(
                            Color(0xFFFBAB18),
                            Color(0xFFFEDE00)
                        ),
                        onClick = {
                            coroutineScope.launch {
                                val userOption:Options = db.optionsDao().findAllByKey("name")[0]
                                userOption.value = ""
                                db.optionsDao().updateOption(userOption)

                                db.optionsDao().deleteByKey("name")
                                db.optionsDao().deleteByKey("email")
                                db.optionsDao().deleteByKey("password")
                            }

                            val intent = Intent(ctx.applicationContext, FirstScreenActivity::class.java)
                            ctx.startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

fun navigateToFirstScreen(){

}