package com.example.geoquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geoquiz.ui.theme.GeoquizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GeoquizTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    GeoQuizApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

data class Question(val text: String, val answer: Boolean)

@Composable
fun GeoQuizApp(modifier: Modifier = Modifier) {
    val questions = listOf(
        Question("Canberra is the capital of Australia.", true),
        Question("The Pacific Ocean is larger than the Atlantic Ocean.", true),
        Question("The Suez Canal connects the Red Sea and the Indian Ocean.", false),
        Question("The source of the Nile River is in Egypt.", false),
        Question("The Amazon River is the longest river in the Americas.", true),
        Question("Lake Baikal is the world's oldest and deepest freshwater lake.", true)
    )

    var currentIndex by remember { mutableStateOf(0) }
    var answered by remember { mutableStateOf(false) }

    val currentQuestion = questions[currentIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 32.dp)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = currentQuestion.text,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    answered = true
                },
                enabled = !answered,
                modifier = Modifier
                    .width(150.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("True", color = Color.White)
            }

            Button(
                onClick = {
                    answered = true
                },
                enabled = !answered,
                modifier = Modifier
                    .width(150.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("False", color = Color.White)
            }
        }
    }
}