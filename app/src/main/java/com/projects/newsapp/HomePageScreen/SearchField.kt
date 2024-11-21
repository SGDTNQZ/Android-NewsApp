package com.projects.newsapp.HomePageScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.newsapp.R

@Composable
fun HomePageScreenSearchField() {

    var text by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
        ,
        value = text,
        onValueChange = { newText -> text = newText },
        maxLines = 1,
        label = { Text("Search") },
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {}
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Cancel icon",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { text = "" },
            )

        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        )
    )
    Spacer(modifier = Modifier.height(8.dp))

    Button(
        onClick = {
        },
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text( text = "Add",
            fontSize = 12.sp,
            fontWeight = FontWeight(500),
        )
    }
}