package com.example.txt_col_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.txt_col_jc.ui.theme.Txt_col_jcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Txt_col_jcTheme {
                AnimText()
            }
        }
    }
}

@Composable
fun AnimText(){
    Box(modifier = Modifier.fillMaxSize()){
        val infTran= rememberInfiniteTransition(label = "Infinite Transition")
        val animColor by infTran.animateColor(
            initialValue = Color.Cyan,
            targetValue = Color.Magenta,
            animationSpec = infiniteRepeatable(tween(2000),RepeatMode.Reverse)
        )

        BasicText(text = "Compose it",
            color = {animColor},
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.align(Alignment.Center).padding(18.dp))
    }
}