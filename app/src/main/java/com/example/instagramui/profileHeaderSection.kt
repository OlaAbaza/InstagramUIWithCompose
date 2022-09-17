package com.example.instagramui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramui.ui.theme.InstagramUITheme

@Composable
fun ProfileHeaderSection(
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    postsNum: String,
    followersNum: String,
    followingNum: String
) {
    val linearGradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFFFEC218), Color(0xFFFF3B3F), Color(0xFFD600BE))
    )

    Row(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        CircularImageWithBorder(
            modifier = modifier
                .size(90.dp)
                .border(3.dp, linearGradientBrush, CircleShape),
            imageRes = R.drawable.disney_profile_pic
        )

        Spacer(modifier = Modifier.width(17.dp))
        HeaderText(
            text1 = postsNum,
            text2 = stringResource(R.string.posts),
            textColor = textColor
        )
        HeaderText(
            text1 = followersNum,
            text2 = stringResource(R.string.followers),
            textColor = textColor
        )
        HeaderText(
            text1 = followingNum,
            text2 = stringResource(R.string.following),
            textColor = textColor
        )

    }

}

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    text1: String,
    text2: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(10.dp)
    ) {
        Text(
            text = text1,
            color = textColor,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = text2,
            color = textColor,
            fontSize = 14.sp
        )
    }
}

//uiMode = Configuration.UI_MODE_NIGHT_YES,
@Preview(showBackground = true)
@Composable
fun PreviewHeaderDisplay() {
    InstagramUITheme(darkTheme = true) {
        ProfileHeaderSection(
            postsNum = "7,443",
            followersNum = "34.4M",
            followingNum = "113",
            textColor = Color.Black
        )
    }
}