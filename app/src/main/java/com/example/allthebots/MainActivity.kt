package com.example.allthebots

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.allthebots.ui.theme.AllTheBotsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllTheBotsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainTextBox()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainTextBox() {
    var text by remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Text") },
                singleLine = true,
                modifier = Modifier.width(280.dp)
            )
            Button(
                onClick = {
//                          TODO: use bookmarked git link as example for ai list

                },
                shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp),
                modifier = Modifier
                    .offset(y=-6.dp)
                    .height(height = 40.dp)
                    .width(width = 280.dp)
            ) {
                Text(text = "v", fontSize = 20.sp)
                //todo: replace this with an icon later
            }
        }
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(top = 9.dp, start = 3.dp, bottom = 6.dp)
                .width(width = 65.dp)
                .height(height = 75.dp)
        ) {
            Text(text = "+", fontSize = 30.sp)
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Box(contentAlignment = Alignment.Center) {
//        Text(
//            text = "Hi my name is $name!",
//            modifier = modifier.padding(24.dp),
//            textAlign = TextAlign.Center
//        )
//    }
//}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AllTheBotsTheme {
//        Greeting("Android")
//    }
//}