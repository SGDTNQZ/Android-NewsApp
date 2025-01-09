package com.projects.newsapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.projects.newsapp.R

@Composable
fun ReadingListHeader(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Reading List",
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
internal fun ColumnItem(item: ColumnNewsItem){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = item.image,
            contentDescription = "",
            modifier = Modifier
                .size(86.dp)
        )
        Column (
            modifier = Modifier.padding( start = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.category,
                fontSize = 11.sp,
                fontWeight = FontWeight(500),
                lineHeight = 13.sp,
                color = Color(0xFF828282),
                modifier = Modifier
                    .background(
                        color = Color(0xFFF1F2F3),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .padding(vertical = 2.dp, horizontal = 4.dp)

            )
            Text(
                text = item.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                lineHeight = 20.sp,
                modifier = Modifier
                    .padding(top = 8.dp)
            )
            Row (modifier = Modifier.padding(top = 8.dp)){
                Text(
                    text = item.author,
                    fontSize = 11.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 13.sp,
                    color = Color(0xFF828282),
                )
                Spacer(modifier = Modifier.width(11.dp))
                Text(
                    text = item.readTime,
                    fontSize = 11.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 13.sp,
                    color = Color(0xFF828282),
                )
            }
        }
    }
}




