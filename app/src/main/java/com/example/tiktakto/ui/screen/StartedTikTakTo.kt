package com.example.tiktakto.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiktakto.R
import com.example.tiktakto.ui.components.ButtonXO

@Composable
fun StartedTikTakTo(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.backgrand),
            contentScale = ContentScale.Crop,
            contentDescription = "Background"
        )
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                Spacer(modifier = Modifier.fillMaxHeight(0.33f))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "TIC-TAC-TOE",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Column {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                    text = "Pick who goes first?",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    var context = LocalContext.current
                    ButtonXO(
                        XO = 1
                    ) {
                        Toast.makeText(context, "x", Toast.LENGTH_SHORT).show()
                    }
                    ButtonXO(
                        XO = 2
                    ) {
                        Toast.makeText(context, "o", Toast.LENGTH_SHORT).show()
                    }
                }
                Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            }

        }
    }
}

@Preview(name = "StartedTikTakTo")
@Composable
private fun PreviewStartedTikTakTo() {
    StartedTikTakTo()
}