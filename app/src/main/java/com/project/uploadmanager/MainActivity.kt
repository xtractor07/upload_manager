package com.project.uploadmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlignInRowExample()
        }
    }

    @Composable
    private fun Greeting(name: String) {
        Text(text = name)
    }

    @Preview
    @Composable
    fun PreviewGreeting() {
        AlignInRowExample()
    }

    /**Understanding Layouts*/
    @Composable
    fun MessageCard(name: String) {
        Row {
            Column {
                Text(
                    text = "Hello ",
                    color = Color.White
                )
                Text(
                    text = "$name !",
                    color = Color.White
                )
            }
        }
    }

    @Composable
    fun Counter() {
        var count by remember { mutableStateOf(0) }
        MaterialTheme{
            Row {
                Button(onClick = { count++ }) {
                    Text("I've been clicked $count times.")
                }
            }
        }
    }

    @Composable
    fun BoxExample() {
        Box {
            Text(
                text = "Hello Compose",
                color = Color.White
            )
        }
    }

    @Composable
    fun AlignInRow() {
        Row {
            Text(
                text = "First",
                Modifier.align(Alignment.CenterVertically),
                color = Color.Cyan,
            )
        }
    }

    @Composable
    fun AlignInColumn() {
        Column {
            Text(
                text = "First",
                Modifier.align(Alignment.CenterHorizontally),
                color = Color.Cyan,
            )
            // This Text composable will be centered horizontally in the Column
        }
    }

    @Composable
    fun FillMAxWidthExample() {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Cenetred Text", Modifier.fillMaxWidth())
        }
    }

    @Composable
    fun AlignInRowExample() {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement =  Arrangement.Center
        ) {
            Text (
                "Aligned Text",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}