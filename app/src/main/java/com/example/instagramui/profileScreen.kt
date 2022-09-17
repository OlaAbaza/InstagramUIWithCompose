package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramui.ui.theme.Blue200
import com.example.instagramui.ui.theme.InstagramUITheme


@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileModel: ProfileModel
) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBarItem(profileName = profileModel.profileName)
        }
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {

            ProfileHeaderSection(
                postsNum = profileModel.postsNum,
                followersNum = profileModel.followersNum,
                followingNum = profileModel.followingNum,
            )

            ProfileDescription(
                profileDesc = profileModel.profileDesc,
                title = profileModel.profileDisplayName,
                url = profileModel.profileDescUrl
            )

            Spacer(modifier = Modifier.height(20.dp))

            HighlightSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 7.dp),
                images = profileModel.highlights
            )
            Spacer(modifier = Modifier.height(20.dp))

            ProfileContentTabView(
                tabs = listOf(
                    Icons.Outlined.DateRange,
                    Icons.Outlined.Star,
                    Icons.Outlined.PlayArrow,
                    Icons.Outlined.AccountBox
                ),
                onTabSelected = {
                    selectedIndex = it
                }

            )
            when (selectedIndex) {
                0 -> LazyVerticalImagesGrid(images = profileModel.contentImageList)
            }

        }
    }
}

@Composable
fun TopAppBarItem(profileName: String) {
    return TopAppBar(
        title = {
            Text(
                text = profileName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                Icons.Filled.CheckCircle, "check Circle Icon",
                tint = Blue200
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, "back Icon")
            }
        },
        backgroundColor = Color.Black,
        contentColor = Color.White,
        elevation = 10.dp,
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Notifications, "notification Icon")
            }

            IconButton(onClick = {}) {
                Icon(Icons.Filled.MoreVert, "menu Icon")
            }

        }
    )
}

@Composable
fun ProfileDescription(
    modifier: Modifier = Modifier,
    profileDesc: String,
    title: String,
    url: String?,
    textColor: Color = Color.White
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = title,
            color = textColor,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = profileDesc,
            color = textColor,
            textAlign = TextAlign.Start
        )

        url?.let {
            Text(
                text = it,
                color = Color(0xFF3A3AC7),
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    images: List<Pair<Int, String>>,
    textColor: Color = Color.White
) {
    LazyRow(
        modifier = modifier
    ) {
        items(images) { image ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 7.dp)
            ) {
                CircularImageWithBorder(
                    modifier
                        .size(71.dp)
                        .border(3.dp, Color(0xFF7E7B7B), CircleShape),
                    imageRes = image.first
                )
                Text(
                    text = image.second,
                    color = textColor,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            }

        }
    }
}

@Composable
fun ProfileContentTabView(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
    tabs: List<ImageVector>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }

    TabRow(
        modifier = modifier,
        selectedTabIndex = selectedIndex,
        backgroundColor = backgroundColor,
        contentColor = contentColor
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                selected = selectedIndex == index,
                onClick = {
                    onTabSelected(index)
                    selectedIndex = index
                }
            ) {
                Icon(
                    tab,
                    "tab Number $index",
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalImagesGrid(
    modifier: Modifier = Modifier,
    images: List<Int>
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f),
        // content padding
        contentPadding = PaddingValues(
            start = 10.dp,
            top = 15.dp,
            end = 10.dp,
            bottom = 16.dp
        ),
        content = {
            items(images) { image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        //                      .size(100.dp)
//                        .padding(3.dp)
                        .aspectRatio(1f)
                        .border(
                            width = 1.dp,
                            color = Color.Black
                        )
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    InstagramUITheme(darkTheme = true) {
        ProfileScreen(
            profileModel = getDisneyProfileModel()
        )
    }
}
