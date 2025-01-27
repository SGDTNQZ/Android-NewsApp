package com.projects.newsapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.projects.newsapp.R


@Composable
fun PopularListHeader(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Popular List",
            fontSize = 24.sp,
            lineHeight = 30.sp,
            fontWeight = FontWeight(600)
        )
        Text(
            text = "See All",
            fontSize = 12.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF828282),
        )
    }
}

@Composable
internal fun RowItem(item: RowNewsItem){
    Column (modifier = Modifier.padding(top = 24.dp, end = 8.dp)){
        AsyncImage(
            model = item.imageSrc,
            contentDescription = "Row item",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 130.dp,164.dp)
                .clip(RoundedCornerShape(32.dp))
        )
        Text(
            text = item.title,
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            lineHeight = 28.sp,
            color = Color(0xFF828282),
            modifier = Modifier
                .padding(top = 8.dp)
        )
        Text(
            text = item.subTitle,
            maxLines = 2,
            modifier = Modifier.width(140.dp),
            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight(600)
        )
    }
}
