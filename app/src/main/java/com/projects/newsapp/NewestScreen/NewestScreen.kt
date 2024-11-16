package com.projects.newsapp.NewestScreen

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.newsapp.HomePageScreen.HomePageScreenCompose
import com.projects.newsapp.HomePageScreen.RowItem
import com.projects.newsapp.R
import com.projects.newsapp.ui.theme.NewsAppTheme

class NewestScreen() : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             NewestScreenComponent()
        }
    }
}

@Composable
fun  NewestScreenComponent(){
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ){
        NewestScreenHeader()
        NewestScreenSelector()
        NewestScreenContent(10)

    }
}
@Composable
fun NewestScreenContent(itemsNumber : Int){
    val itemList = mutableListOf<Any>()
    for (i in 0..itemsNumber){
        itemList.add(Any())
    }
     LazyColumn (
         modifier = Modifier
             .padding(top = 24.dp)
     ) {
         items(itemList.size){
             NewestScreenColumnItem()
         }
     }
}
@Composable
fun NewestScreenSelector(){
    Row (
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        SelectorButton("All")
        SelectorButton("Design")
        SelectorButton("History")
    }
}
@Composable
fun SelectorButton(str: String){
    Button(
        onClick = { },
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
        ,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color(0xff9f9fa0)
        )
    ) {
        Text(
            text = str,
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            lineHeight = 26.sp,
            modifier = Modifier
        )
    }
}
@Composable
fun NewestScreenHeader(){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Newest",
            fontSize = 40.sp,
            fontWeight = FontWeight(700),
            lineHeight = 40.sp
        )
        Image(
            painterResource(R.drawable.ic_profile),
            contentDescription = "Profile icon",
            modifier = Modifier
                .size(48.dp)
        )
    }
}