package com.example.kmmcoinapp.android

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmmcoinapp.presentation.home.GetAllCoinsViewModel
import org.koin.androidx.compose.getViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Greeting("hiii")
        }
    }
}

@Composable
fun Greeting(
    text: String,
    viewModel: GetAllCoinsViewModel = getViewModel()
) {
    Text(text = text)
     viewModel.getAllCoins(1, 10)

}

@Preview
@Composable
fun DefaultPreview() {

        Greeting("Hello, Android!")

}
