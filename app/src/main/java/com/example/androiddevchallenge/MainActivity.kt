/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.Home
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.makeTransparentStatusBar()
        setContent {
            MyTheme {
                @Suppress("DEPRECATION")
                if (MaterialTheme.colors.surface.luminance() > 0.5f) {
                    window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { Welcome(navController = navController) }
        composable("login") { Login(navController = navController) }
        composable("home") { Home() }
    }
}

@Composable
fun Welcome(navController: NavController) {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.primary)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(
                    id = R.drawable.ic_welcome_bg
                ),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "welcome bg",
                contentScale = ContentScale.Crop,
            )

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.padding(top = 72.dp, start = 88.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_welcome_illos),
                    contentDescription = "welcome illos",
                    contentScale = ContentScale.Crop,
                )
                Image(
                    modifier = Modifier.padding(top = 48.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = "Beautiful home garden solutions",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.paddingFromBaseline(top = 32.dp),
                    color = MaterialTheme.colors.onPrimary,
                )

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .requiredHeight(48.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Text(
                        text = "Create account",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSecondary
                    )
                }
                TextButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier
                        .padding(top = 24.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }
    }
}

@Composable
fun Login(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Log in with email",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            text = "Email Address", style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onPrimary
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            text = "Password (8+characters)",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onPrimary
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    )
                )
                val annotatedString =
                    AnnotatedString.Builder("By clicking below, you agree to out Terms of Use and consent to out Privacy Policy.")
                        .apply {
                            addStyle(
                                style = SpanStyle(textDecoration = TextDecoration.Underline),
                                36,
                                48
                            )
                        }.apply {
                            addStyle(
                                style = SpanStyle(textDecoration = TextDecoration.Underline),
                                68,
                                82
                            )
                        }
                Text(
                    text = annotatedString.toAnnotatedString(),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .paddingFromBaseline(top = 24.dp, bottom = 0.dp),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.body2
                )
                Button(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .requiredHeight(48.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Preview("WelCome Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightWelcomePreview() {
    val navController = rememberNavController()
    MyTheme {
        Welcome(navController = navController)
    }
}

@Preview("WelCome Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkWelcomePreview() {
    val navController = rememberNavController()
    MyTheme(darkTheme = true) {
        Welcome(navController = navController)
    }
}

fun Window.makeTransparentStatusBar() {
    markAttributes(
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
        true
    )
    decorView.systemUiVisibility = (
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        )
    markAttributes(
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
        false
    )
    statusBarColor = Color.Transparent.toArgb()
    navigationBarColor = Color.Transparent.toArgb()
}

fun Window.markAttributes(bits: Int, value: Boolean) {
    val params = attributes
    if (value) {
        params.flags = params.flags or bits
    } else {
        params.flags = params.flags and bits.inv()
    }
    attributes = params
}
