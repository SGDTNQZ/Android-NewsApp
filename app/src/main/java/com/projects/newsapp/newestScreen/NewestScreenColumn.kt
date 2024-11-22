package com.projects.newsapp.newestScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
import com.projects.newsapp.R

@Composable
internal fun NewestScreenColumnItem(){
    Row (modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painterResource(R.drawable.img_reading_item),
            contentDescription = "",
            modifier = Modifier
                .size(86.dp)
        )
        Column (
            modifier = Modifier.padding( start = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Entrepreneur",
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
                text = "How to promote business right away in instagram",
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
                    text = "Bella Gonza",
                    fontSize = 11.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 13.sp,
                    color = Color(0xFF828282),
                )
                Spacer(modifier = Modifier.width(11.dp))
                Text(
                    "12 mins",
                    fontSize = 11.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 13.sp,
                    color = Color(0xFF828282),
                )
            }
        }
    }
    HorizontalDivider(
        modifier = Modifier
            .padding(vertical = 24.dp)
            .fillMaxWidth()
            .border(1.dp, color = Color.LightGray)
    )
}