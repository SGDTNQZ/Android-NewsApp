package com.projects.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.SavedStateHandle

class SettingsScreen : ComponentActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsScreenCompose()
        }
    }
}

@Composable
fun SettingsScreenCompose(){
    Column (modifier = Modifier
        .padding(24.dp)
        .fillMaxSize()
    ) {
        SettingsScreenTopComponent()
        SettingsScreenFirstComponent()
        SettingsScreenSecondComponent()
        LogoutBtn()
        Spacer(modifier = Modifier.weight(1f))
    }
}
@Composable
fun SettingsScreenTopComponent(){
    Row ( modifier = Modifier
        .padding(top = 20.dp , end = 145.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painterResource(R.drawable.ic_icon_arrow_back),
            contentDescription = "Arrow back icon",
            modifier = Modifier
                .size(32.dp)
            )
        Text(
            text = stringResource(id = R.string.SettingsScreenHeader),
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            lineHeight = 24.sp,
        )
    }
}
@Composable
fun SettingsScreenFirstComponent(){
    Column(
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxWidth()
    ) {
        SettingsScreenPersonalInfoHeader()
        SettingsScreenOptions(R.drawable.profile_icon, R.string.YourProfile)
        SettingsScreenOptions(R.drawable.ic_lock, R.string.ChangePassword)

    }
}
@Composable
fun SettingsScreenSecondComponent(){
    Column(
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxWidth()
    ) {
        SettingsScreenPersonalInfoHeader()
        SettingsScreenOptions(R.drawable.ic_edit, R.string.AdjustFontSize)
        SettingsScreenOptions(R.drawable.ic_game, R.string.DailyChallenge)

    }
}
@Composable
fun SettingsScreenPersonalInfoHeader(){
    Text(
        text = stringResource(R.string.PersonalInfo),
        fontWeight = FontWeight(600),
        fontSize = 14.sp,
        lineHeight = 19.sp
    )
}
@Composable
fun SettingsScreenOptions(imageId : Int, stringId : Int){
    Row (
        modifier = Modifier
            .padding(top = 32.dp)
    ){
        Image(
            painterResource(id = imageId),
            contentDescription = "Person Icon",
            modifier = Modifier
                .size(24.dp)
            )
        Text(
            text = stringResource(stringId),
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            lineHeight = 19.sp,
            modifier = Modifier
                .padding(start = 24.dp)
        )
    }
    HorizontalDivider(
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    )
}
@Composable
fun LogoutBtn(){
    ClickableText (
        text = AnnotatedString(stringResource(R.string.Logout)),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            lineHeight = 20.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFFEB5757),
            ),
        modifier = Modifier
            .padding(top = 150.dp)
            .fillMaxWidth(),
        onClick = { }

    )
}

@Composable
fun BottomNavigation(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)
        .padding(16.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Temporary placeholder",
            color = Color.White)
    }
}