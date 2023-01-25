package com.sebastianttr.dinamico

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebastianttr.dinamico.clients.UserClient
import com.sebastianttr.dinamico.clients.UserClientService
import com.sebastianttr.dinamico.composable.SButton
import com.sebastianttr.dinamico.composable.STextField
import com.sebastianttr.dinamico.config.SetDefaultSystemColors
import com.sebastianttr.dinamico.layouts.dpToPx
import com.sebastianttr.dinamico.models.User
import com.sebastianttr.dinamico.ui.theme.AccentLight
import com.sebastianttr.dinamico.ui.theme.AccentStrong
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.dinamico.ui.theme.Montserrat
import com.sebastianttr.dinamico.utils.md5
import com.sebastianttr.dinamico.utils.toHex
import com.sebastianttr.room.database.AppDatabase
import com.sebastianttr.room.database.Database
import com.sebastianttr.room.database.dbOptions
import com.sebastianttr.room.entites.Options
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RegisterActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            var email by remember { mutableStateOf("") }
            var userName by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var repeatPassword by remember { mutableStateOf("") }
            val userClientAPI = UserClientService.getInstance().create(UserClient::class.java)
            val coroutineScope: CoroutineScope = rememberCoroutineScope()
            var errorMessage by remember {
                mutableStateOf("")
            }

            SetDefaultSystemColors(topBarColor = AccentLight, navbarColor = Color(0xFF25284F))

            lateinit var db: AppDatabase
            val ctx = LocalContext.current

            coroutineScope.launch {
                db = Database.getDb(ctx)
            }

            DinamicoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF111224),
                                    Color(0xFF25284F)
                                ),
                                startY = 300.dp.dpToPx(),
                                endY = (LocalConfiguration.current.screenHeightDp.dp + 300.dp).dpToPx()
                            )
                        ),
                    color = Color.Transparent
                ) {
                    Box(modifier = Modifier.fillMaxWidth()){
                        Image(
                            modifier = Modifier
                                .padding(top = 211.dp)
                                .height(36.dp)
                                .fillMaxWidth(),
                            painter = painterResource(id = R.drawable.checker),
                            contentDescription = "checker"
                        )
                        Image(
                            painter = painterResource(id = R.drawable.login_vector),
                            contentDescription = "Pic background",
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.FillWidth
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 112.dp),
                            text = "Register",
                            style = TextStyle(
                                fontSize = 48.sp,
                                fontWeight = FontWeight.Black,
                                fontStyle = FontStyle.Italic,
                                fontFamily = Montserrat,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        )
                        Column(modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 80.dp, start = 16.dp, end = 16.dp)
                            .verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(40.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                STextField(
                                    text = userName,
                                    onValueChanged = {
                                        userName = it
                                    },
                                    height = 42.dp,
                                    inputDescription = "Username"
                                )
                                STextField(
                                    text = email,
                                    onValueChanged = {
                                         email = it
                                    },
                                    height = 42.dp,
                                    inputDescription = "Email"
                                )
                                STextField(
                                    text = password,
                                    onValueChanged = {
                                        password = it
                                    },
                                    height = 42.dp,
                                    inputDescription = "Password",
                                    passwordVisibility = true
                                )
                                STextField(
                                    text = repeatPassword,
                                    onValueChanged = {
                                        repeatPassword = it
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
                            }
                            Row(Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Box(modifier = Modifier
                                    .fillMaxWidth(0.3f)
                                ){
                                    SButton(
                                        text = "BACK",
                                        colors = listOf(
                                            Color(0xFF646CDB),
                                            Color(0xFF9398E1)
                                        ),
                                        onClick = {
                                            finish()
                                        }
                                    )
                                }
                                Box(modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                ){
                                    SButton(
                                        text = "REGISTER",
                                        colors = listOf(
                                            Color(0xFFFBAB18),
                                            Color(0xFFFEDE00)
                                        ),
                                        onClick = {
                                            if(password.length >= 8
                                                && password == repeatPassword
                                                && email.isNotEmpty() && email.contains("@")
                                                && userName.isNotEmpty()
                                            ) {
                                                Log.i("Register","Registering")
                                                // all good, send request
                                                coroutineScope.launch {
                                                    userClientAPI.addUser(
                                                        User(
                                                            name = userName,
                                                            email = email,
                                                            password = md5(password).toHex()
                                                        )
                                                    )

                                                    // set the user profile
                                                    db.optionsDao().insertOptions(
                                                        listOf(
                                                            Options(10,"name",userName,"User"),
                                                            Options(11,"email",email,"User"),
                                                            Options(12,"password",md5(password).toHex(),"User"),
                                                        )
                                                    )

                                                    // move to a different activity.
                                                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                                                    startActivity(intent)
                                                    finish()
                                                }
                                            }
                                            if (password.length < 8) {
                                                errorMessage = "Password is too short!"
                                            }
                                            if (password != repeatPassword) {
                                                errorMessage = "Repeated password is not the same!"
                                            }
                                            if (!email.contains("@")){
                                                errorMessage = "Invalid email!"
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

