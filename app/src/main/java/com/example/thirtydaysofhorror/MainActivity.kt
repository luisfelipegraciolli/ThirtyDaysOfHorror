package com.example.thirtydaysofhorror

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofhorror.model.HorrorMediaRepository
import com.example.thirtydaysofhorror.ui.theme.ThirtyDaysOfHorrorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun App(){
    ThirtyDaysOfHorrorTheme {
        Scaffold(topBar = { TDOHTopBar() },
            modifier = Modifier.fillMaxSize()) { innerPadding ->
                HorrorFeed(
                    horrorList = HorrorMediaRepository.horrorGoodies,
                    modifier = Modifier.padding(innerPadding)
                )
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}