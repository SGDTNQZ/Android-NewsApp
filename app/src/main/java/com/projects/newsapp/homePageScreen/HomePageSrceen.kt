package com.projects.newsapp.homePageScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.newsapp.R
import com.projects.newsapp.views.NewsItemView

class HomePageScreen : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePageScreenCompose()
        }
    }
}

@Composable
fun HomePageScreenCompose(){
    val inputText = remember { mutableStateOf("") }

    val list = remember {
        mutableStateOf(
            listOf(
                NewsItemView("Hello World"),
            )
        )
    }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        HomePageScreenHeader()
        HomePageScreenSearchField(inputText,list)


        HomePageScreenPopularList(list)
        HomePageScreenReadingList(list)
    }
}


@Composable
fun HomePageScreenReadingList(list: MutableState<List<NewsItemView>>){
    Column (modifier = Modifier
        .padding(top = 24.dp)
    ){
        ReadingListHeader()

        LazyColumn (
            Modifier.safeContentPadding()
                .wrapContentHeight()
        ){
            items(list.value){
                item -> ColumnItem(name = item.itemName)
            }
        }
    }

}
@Composable
fun HomePageScreenPopularList(list: MutableState<List<NewsItemView>>){
    Column (
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    ){
        PopularListHeader()

        LazyRow (Modifier.safeContentPadding())
        {
            items(list.value){
                    item -> RowItem(name = item.itemName)
            }
        }
    }
}



@Composable
fun HomePageScreenHeader(){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        val timeleft = 25

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