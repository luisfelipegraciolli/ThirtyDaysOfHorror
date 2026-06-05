package com.example.thirtydaysofhorror

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.thirtydaysofhorror.model.HorrorMedia
import com.example.thirtydaysofhorror.model.HorrorMediaRepository
import com.example.thirtydaysofhorror.ui.theme.ThirtyDaysOfHorrorTheme

@Composable
private fun MediaItemButton(expandend: Boolean, modifier: Modifier = Modifier){
    IconButton(
        onClick = {  },

        ) {
        Icon(
            imageVector = Icons.Filled.ExpandLess,
            contentDescription = null
        )
    }
}

@Composable
fun HorrorRecommendationsCard(day: Int, horrorMedia: HorrorMedia, modifier: Modifier = Modifier){
    Card(modifier = modifier.fillMaxWidth()) {
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Day $day",
                    modifier = Modifier.weight(1f)
                )
                MediaItemButton(
                    expandend = false,
                    modifier = Modifier.clip(shape = RoundedCornerShape(16.dp))
                )
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(horrorMedia.titleStringId))

                Spacer(modifier = Modifier.size(16.dp))

                Box(
                    modifier = Modifier
                        .size(256.dp)
                        .clip(MaterialTheme.shapes.small)
                ) {
                    Image(
                        painter = painterResource(horrorMedia.imageResId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(horrorMedia.descriptionStringId),
                    style = MaterialTheme.typography.bodySmall
                )
            }

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