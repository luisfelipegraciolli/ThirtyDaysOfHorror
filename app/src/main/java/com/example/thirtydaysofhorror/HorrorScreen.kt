package com.example.thirtydaysofhorror

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.thirtydaysofhorror.model.HorrorMedia
import com.example.thirtydaysofhorror.ui.theme.ThirtyDaysOfHorrorTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TDOHTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${stringResource(R.string.app_name)} \uD83C\uDF83",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )
            }
        },
        modifier = modifier.padding(16.dp)
    )
}

@Composable
private fun MediaItemButton(expanded: Boolean, onClick: () -> (Unit), modifier: Modifier = Modifier){
    IconButton(
        onClick = onClick,
        modifier = modifier
        ) {
        Icon(
            imageVector = if(expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
    
}

@Composable
fun HorrorRecommendationsCard(day: Int, horrorMedia: HorrorMedia, modifier: Modifier = Modifier){
    var expanded: Boolean by remember { mutableStateOf(false) }
    val color: Color by animateColorAsState(targetValue =
        if (expanded) {
            MaterialTheme.colorScheme.surfaceContainerHigh
        } else{
            MaterialTheme.colorScheme.surfaceContainerLow
        }
    )

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ,modifier = modifier
    ) {
        Column (
            modifier = Modifier
                .heightIn(64.dp)
                .fillMaxWidth()
                .background(color = color)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Day $day",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.headlineSmall,
                )
                MediaItemButton(
                    expanded = expanded,
                    modifier = Modifier.clip(shape = RoundedCornerShape(16.dp)),
                    onClick = {
                        expanded = !expanded
                    }
                )
            }

            if (expanded){
                Spacer(modifier = Modifier.size(8.dp))
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Text(
                        text = stringResource(horrorMedia.titleStringId),
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Black
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    Box(
                        modifier = Modifier
                            .size(256.dp)
                            .clip(MaterialTheme.shapes.small)
                    ) {
                        Image(
                            painter = painterResource(horrorMedia.imageResId),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(
                        text = stringResource(horrorMedia.descriptionStringId),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }
            }


        }
    }
}


@Composable
fun HorrorFeed(horrorList: List<HorrorMedia>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(horrorList) {
            HorrorRecommendationsCard(horrorList.indexOf(it)+1,
                horrorMedia = it,
                modifier = Modifier.padding(top=8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                )
        }
    }
}

