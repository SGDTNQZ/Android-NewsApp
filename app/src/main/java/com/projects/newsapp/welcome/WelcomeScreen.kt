
package com.projects.newsapp.welcome

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.newsapp.R


@Composable
fun WelcomeScreen(onEvent: (WelcomeEvent) -> Unit){
    var isExpanded by remember { mutableStateOf(false) }
    val imageHeight by animateDpAsState(
        targetValue = if(isExpanded)300.dp else 150.dp,
        label = "The welcome image height"
    )
    Column( modifier = Modifier
        .padding(top = 40.dp, bottom = 44.dp)
        .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painterResource(R.drawable.new_img),
            contentDescription = "News Icon",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .padding(horizontal = 89.dp)
                .fillMaxWidth()
                .animateContentSize()
                .height(imageHeight)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    isExpanded = !isExpanded
                }

                .clip(RoundedCornerShape(12.dp))
        )
        WelcomeScreenParagraph()
        Spacer(modifier = Modifier.weight(1f))
        WelcomeScreenButton(onEvent)
    }
}

@Composable
fun WelcomeScreenParagraph(){
    Column (modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Text(
                text = stringResource(id = R.string.WelcomeScreenParagraphHeader),
                fontSize = 32.sp,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 32.dp)
            )

            Text(
                modifier = Modifier.padding(4.dp),
                text = stringResource(id = R.string.WelcomeScreenParagraphBody),
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center,
                lineHeight = 28.sp,
                color = Color(0xFF828282)
            )
    }
}

@Composable
fun WelcomeScreenButton(onEvent: (WelcomeEvent) -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        colors = ButtonDefaults.buttonColors(Color.Black),
        shape = RoundedCornerShape(12.dp),
        onClick = {
            onEvent(WelcomeEvent.OnClickToMain(ActionArgs("We are from Welcome Screen")))
        }
    ) {
        Text(
            text = stringResource(id = R.string.WelcomeScreenButtonText),
            fontSize = 16.sp,
            fontWeight = FontWeight(700),
            lineHeight = 28.sp
        )
    }
}


