package com.example.datingapp.screens.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.datingapp.components.AppTextButton
@Composable
fun FeedScreen(
    onMatchesClick: () -> Unit,
){
    val stateHolder  = remember { FeedStateHolder() }
    val uiState =  stateHolder.uiState
    val currentProfile = uiState.profiles.firstOrNull()

    Column(
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = "Лента",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp,top = 4.dp,bottom = 12.dp)
            )

            if (uiState.matchName != null) {
                Text(
                    text = "\uD83C\uDF89 Мэтч с ${uiState.matchName}!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                AppTextButton(
                    text = "Ок",
                    onClick = stateHolder :: onMatchDismiss,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }

            if (currentProfile != null) {
                SwipeCard(
                    onSwipeLeft = {stateHolder.onSkipClick()},
                    onSwipeRight = {stateHolder.onLikeClick()},
                    modifier = Modifier.weight(1f)
                ) {
                    ProfileCard(
                        name = currentProfile.name,
                        age = currentProfile.age,
                        city = currentProfile.city,
                        about = currentProfile.about,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            } else {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Анкеты закончились \uD83D\uDE14",
                        fontSize = 18.sp,
                    )
                }
            }
    }

}

@Composable
fun ProfileCard(
    name: String,
    age: Int,
    city: String,
    about: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp,vertical = 8.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            // photo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Фото",
                    color  = Color.Gray,
                    fontSize = 18.sp
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "$name, $age",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = city,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp,bottom = 8.dp)
                )

                HorizontalDivider()

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp)
                        .verticalScroll(rememberScrollState())
                ){
                    Text(
                        text = about,
                        fontSize = 15.sp,
                        color = Color.DarkGray,
                        lineHeight = 22.sp
                    )
                }

            }
        }
    }
}