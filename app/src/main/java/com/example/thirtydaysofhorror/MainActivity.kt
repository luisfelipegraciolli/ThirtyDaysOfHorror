package com.example.thirtydaysofhorror

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysofhorror.data.HorrorMediaRepository
import com.example.thirtydaysofhorror.ui.theme.ThirtyDaysOfHorrorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
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

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ThirtyDaysOfHorrorTheme(darkTheme = true){
        Scaffold(topBar = { TDOHTopBar() },
            modifier = Modifier.fillMaxSize()) { innerPadding ->
            HorrorFeed(
                horrorList = HorrorMediaRepository.horrorGoodies,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}