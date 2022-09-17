package com.example.instagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularImageWithBorder(
    modifier: Modifier = Modifier,
    imageRes: Int
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = stringResource(
            R.string.profile_image
        ),
        contentScale = ContentScale.Crop,
        modifier = modifier
         //   .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .padding(4.dp)
            .clip(CircleShape)

    )
}