package com.example.thirtydaysofhorror

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysofhorror.model.HorrorMedia
import com.example.thirtydaysofhorror.model.HorrorMediaRepository
import com.example.thirtydaysofhorror.ui.theme.ThirtyDaysOfHorrorTheme


@Composable
fun HorrorRecommendationsCard(day: Int, horrorMedia: HorrorMedia, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Column {
            Text(text = "Day $day")


            Text(text = stringResource(horrorMedia.titleStringId))
            Image(
                painter = painterResource(horrorMedia.imageResId),
                contentDescription = null
            )
            Text(
                text = stringResource(horrorMedia.descriptionStringId)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DarkThemePreview(){
    ThirtyDaysOfHorrorTheme() {
        HorrorRecommendationsCard(1, HorrorMediaRepository.horrorGoodies[0])
    }
}