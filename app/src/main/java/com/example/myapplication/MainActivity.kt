package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var counter1 by remember { mutableStateOf(0) }
    var counter2 by remember { mutableStateOf(0) }
    var counter3 by remember { mutableStateOf(0) }
    var lastClickedButtom by remember { mutableStateOf("None") }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(16.dp)) {
        Row (modifier) {
            Text(text = "Counter 1: $counter1")
            Text(text = "Counter 2: $counter2")
            Text(text = "Counter 3: $counter3")
        }
        Row {
            Button(onClick = { counter1++; lastClickedButtom = "Button 1" }) {
                Text("Button 1");
            }
            Button(onClick = { counter2++; lastClickedButtom = "Button 2" }) {
                Text("Button 2")
            }
            Button(onClick = { counter3++; lastClickedButtom = "Button 3" }) {
                Text("Button 3")
            }
        }

        Text("Last clicked button: $lastClickedButtom")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}