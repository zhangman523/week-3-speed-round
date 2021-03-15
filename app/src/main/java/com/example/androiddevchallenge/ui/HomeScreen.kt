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
package com.example.androiddevchallenge.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.androiddevchallenge.ui.theme.MyTheme

val browseThemes = listOf(
    BrowseThemes(
        "Desert chic",
        "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    BrowseThemes(
        "Tiny terrariums",
        "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    BrowseThemes(
        "Jungle vibes",
        "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    BrowseThemes(
        "Easy care",
        "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"

    ),
    BrowseThemes(
        "Statements",
        "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    )
)

val homeGardens = listOf(
    HomeGarden(
        "Monstera",
        "This is a description",
        "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        true
    ),
    HomeGarden(
        "Aglonema",
        "This is a description",
        "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        false
    ),
    HomeGarden(
        "Peace lily",
        "This is a description",
        "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        false
    ),
    HomeGarden(
        "Fiddle leaf tree",
        "This is a description",
        "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        false
    ),
    HomeGarden(
        "Snake plant",
        "This is a description",
        "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        false
    ),
    HomeGarden(
        "Pothos",
        "This is a description",
        "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        false
    ),
)

@Composable
fun Home() {

    val menuList = listOf(
        "Home" to Icons.Filled.Home,
        "Favourites" to Icons.Sharp.Favorite,
        "Profile" to Icons.Filled.AccountCircle,
        "Card" to Icons.Filled.ShoppingCart,
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary
            ) {
                menuList.forEach { (label, icon) ->
                    BottomNavigationItem(
                        selected = (label == "Home"),
                        onClick = { /*TODO*/ },
                        icon = { Icon(icon, contentDescription = "icon") },
                        label = {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                    )
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 58.dp),
            content = {
                item {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp, start = 16.dp, end = 16.dp),
                        value = "",
                        onValueChange = { },
                        label = {
                            Text(
                                text = "Search",
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.onPrimary
                            )
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Sharp.Search,
                                contentDescription = ""
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MaterialTheme.colors.surface,
                            unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                        ),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
                    )
                }
                item {
                    browseItem()
                }
                item {
                    homeGardenItem()
                }
            }
        )
    }
}

data class BrowseThemes(val name: String, val imageUrl: String)
data class HomeGarden(
    val title: String,
    val subTitle: String,
    val imageUrl: String,
    val checked: Boolean
)

@Composable
fun browseItem() {
    Text(
        "Browse themes",
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onPrimary,
        modifier = Modifier
            .padding(start = 8.dp)
            .paddingFromBaseline(top = 32.dp)
    )
    LazyRow(
        content = {
            browseThemes.forEachIndexed { index, browseItem ->
                item {
                    browseThemesItem(
                        item = browseItem,
                        Modifier
                            .padding(
                                start = if (index == 0) 16.dp else 8.dp,
                                top = 16.dp,
                                bottom = 1.dp,
                                end = if (index == browseThemes.size - 1) 16.dp else 0.dp
                            )
                            .size(width = 136.dp, height = 136.dp)
                            .background(color = MaterialTheme.colors.background),
                    )
                }
            }
        }
    )
}

@Composable
fun homeGardenItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Discover your home garden",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(16.dp)
        )
        IconButton(onClick = { }) {
            Icon(
                Icons.Filled.FilterList,
                contentDescription = "",
                Modifier.size(24.dp)
            )
        }
    }
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        (homeGardens + homeGardens).forEachIndexed { index, item ->
            homeGardenItem(item = item)
        }
    }
}

@Composable
fun browseThemesItem(item: BrowseThemes, modifier: Modifier) {
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    Glide.with(LocalContext.current).asBitmap()
        .load(item.imageUrl)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmap = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp,
    ) {
        Column(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            if (bitmap != null) {
                Image(
                    bitmap!!.asImageBitmap(),
                    modifier = Modifier
                        .height(96.dp)
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colors.background),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )
            } else {
                Box(
                    modifier = Modifier
                        .width(136.dp)
                        .height(96.dp)
                ) {
                    Text(
                        "Loading...",
                        modifier = Modifier.align(Alignment.Center),
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = item.name,
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

@Composable
fun homeGardenItem(item: HomeGarden) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(top = 8.dp)
            .background(color = MaterialTheme.colors.background),
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp
    ) {
        var bitmap by remember { mutableStateOf<Bitmap?>(null) }
        Glide.with(LocalContext.current).asBitmap()
            .load(item.imageUrl)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    bitmap = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (bitmap != null) {
                Image(
                    bitmap!!.asImageBitmap(),
                    modifier = Modifier
                        .height(64.dp)
                        .width(64.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )
            } else {
                Box(
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                ) {
                    Text(
                        "Loading...", modifier = Modifier.align(Alignment.Center),
                        style = MaterialTheme.typography.body2, textAlign = TextAlign.Center
                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(
                    item.title,
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    item.title,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary
                )
            }
            toggleButton(item.checked)
        }
    }
}

@Composable
fun toggleButton(itemChecked: Boolean) {
    var checked by remember { mutableStateOf(itemChecked) }
    Box(
        Modifier
            .height(24.dp)
            .width(40.dp)
            .padding(end = 16.dp)
    ) {
        Button(
            onClick = { checked = !checked },
            modifier =
            Modifier.fillMaxSize(),
            colors = ButtonDefaults.buttonColors(backgroundColor = if (checked) MaterialTheme.colors.secondary else MaterialTheme.colors.background),
            shape = RoundedCornerShape(2.dp)
        ) {}
        if (checked) {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = null, // handled by click label of parent
                tint = MaterialTheme.colors.background,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 5.dp)
            )
        }
    }
}

@Preview("Home Light", widthDp = 360, heightDp = 640)
@Composable
fun HomeLightPreview() {
    MyTheme {
        Home()
    }
}

@Preview("Home Dark", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview() {
    MyTheme(darkTheme = true) {
        Home()
    }
}
