package com.projects.newsapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.newsapp.R


@Composable
fun HomeScreen(
    onEvent: (HomeEvent) -> Unit,
    state: HomeState
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when(state.columnData){
            is ColumnUIState.OnGetNews ->{
                LazyColumn (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                        .padding(top = 56.dp)
                ) {
                    item { HomeScreenHeader() }
                    item { HomeScreenSearchField(onEvent,state) }
                    item { HomeScreenPopularList(state.rowData.news) }
                }
            }
        }


    }
}

@Composable
fun HomeScreenPopularList(list: List<RowNewsItem>){
    Column (
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    ){
        PopularListHeader()

        LazyRow (Modifier.safeContentPadding())
        {
            items(list.size){
                    key -> RowItem(list[key])
            }
        }
    }
}

@Composable
fun HomeScreenHeader(){
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