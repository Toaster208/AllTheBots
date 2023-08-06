package com.example.allthebots

import android.annotation.SuppressLint
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
import androidx.compose.material3.Card
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


fun Modifier.conditional(condition : Boolean, modifier : Modifier.() -> Modifier) : Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}
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
    var expanded by remember { mutableStateOf(false) }
    var fixPos by remember { mutableStateOf(true) }
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
            Card(
                shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp),
                modifier = Modifier
                    .offset(y = -6.dp)
                    .width(width = 280.dp)
                    .conditional(fixPos) {
                        height(height = 40.dp)
                    },
                onClick = {
                    expanded = !expanded
                    fixPos = !fixPos
                }
            ) {
                Column {
                    if (!expanded) {
                        Text(text = "v", fontSize = 20.sp, modifier = Modifier.padding(start = 135.dp))
                        //todo: find out how to center + add icon
                    } else if (expanded) {
                        Text(text = "Hi!\n\n\n\n", fontSize = 18.sp)
                        Text(text = "^", fontSize = 20.sp, modifier = Modifier.padding(start = 135.dp))
                    }
                }
            }
        }
        Button(
            onClick = { /*TODO: Upload button*/ },
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
//fun openList() {
//    Column {
//        Text(text = "Hi.")
//    }
//}

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