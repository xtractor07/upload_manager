package com.project.uploadmanager

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradient
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MessageCard(name = "Compose !")
//            Modifiers()
        }

    }

    @Composable
    private fun Greeting(name: String) {
        Text(text = name)
    }

    @Preview
    @Composable
    fun Preview() {
        val painter = painterResource(id = R.drawable.conquer)
        val description = "Basic Android Compose wrapped together"
        val title = "Android-Compose"

        Box(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(16.dp)
        ) {
            ImageCard(
                painter = painter,
                contentDescription = description,
                title = title,
                modifier = Modifier.clickable {
                    println("Hello-World!")
                }
            )
        }
    }

    @Composable
    fun ImageCard(
        painter: Painter,
        contentDescription: String,
        title: String,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp,
        ) {
            Box (modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.White
                                ),
                                startY = 300f
                            )
                        )
                )
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }

    /**Understanding Layouts*/
    @Composable
    fun MessageCard(name: String) {
        Row (
            modifier = Modifier
                .width(400.dp)
                .fillMaxHeight(.7f)
                .background(Color.Gray),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
//            Column (
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Green),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround
//            ) {
                Text(
                    text = "Hello ",
                    color = Color.Black,
                    fontSize = 25.sp
                )
                Text(
                    text = "$name !",
                    color = Color.Black,
                    fontSize = 25.sp
                )
                Text(
                    text = "Hello",
                    color = Color.Black,
                    fontSize = 25.sp
                )
//            }
        }
    }

    @Composable
    fun Modifiers() {
        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxHeight(.5f)
                .fillMaxWidth()
                .padding(top = 16.dp)
                .border(5.dp, Color.Black)
                .padding(5.dp)
                .border(10.dp, Color.Blue,)
                .padding(16.dp)
//                .width(600.dp)
//                .requiredWidth(300.dp)
        ) {
            Text(
                text = "Hello",
                fontFamily = FontFamily(Typeface.MONOSPACE),
                fontSize = 20.sp,
                modifier = Modifier.clickable {
                    println("Hello Compose!")
                }
            )
//            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Compose!",
                fontFamily = FontFamily(Typeface.MONOSPACE),
                fontSize = 20.sp
            )
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