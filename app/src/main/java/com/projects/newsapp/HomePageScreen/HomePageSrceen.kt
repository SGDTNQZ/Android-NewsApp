package com.projects.newsapp.HomePageScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.newsapp.R

class HomePageScreen() : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePageScreenCompose()
        }
    }
}
@Composable
fun HomePageScreenCompose(){
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        HomePageScreenHeader()
        HomePageScreenSearchField()
        HomePageScreenPopularList(10)
        HomePageScreenReadingList(10)
    }
}
@Composable
fun HomePageScreenReadingList(numOfItems: Int){
    Column (modifier = Modifier
        .padding(top = 24.dp)
    ){
        ReadingListHeader()

        val itemList = mutableListOf<Any>()
        for (i in 0..numOfItems){
            itemList.add(Any())
        }
        LazyColumn {
            items(itemList.size){
                ColumnItem()
            }
        }
    }

}
@Composable
fun HomePageScreenPopularList(numOfItems : Int){
    Column (
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    ){
        PopularListHeader()

        val itemList = mutableListOf<Any>()
        for (i in 0..numOfItems){
            itemList.add(Any())
        }
        LazyRow (modifier = Modifier.safeContentPadding())
        {
            items(itemList.size){
                RowItem()
            }
        }
    }
}

@Composable
fun HomePageScreenSearchField() {
    var search by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
        ,
        value = search,
        onValueChange = { newText -> search = newText },
        maxLines = 1,
        label = { Text("Search") },
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {

                }
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        )

    )
}

@Composable
fun HomePageScreenHeader(){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        val timeleft : Int = 25

        Column {
            Text(
                stringResource(R.string.app_name),
                fontSize = 40.sp,
                fontWeight = FontWeight(700),
                lineHeight = 40.sp
            )
            Row {
                Text(
                    stringResource(R.string.TodayReading),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 28.sp,
                    color = Color(0xFF828282)
                )
                Text(
                    text = " $timeleft min left",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 28.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }
        }
        Image(
            painterResource(R.drawable.ic_profile),
            contentDescription = "Profile icon",
            modifier = Modifier
                .size(48.dp)
        )
    }
}