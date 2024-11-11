package com.example.tiktakto.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiktakto.R

@Composable
fun ButtonXO(
    modifier: Modifier = Modifier,
    painter: Painter = painterResource(id = R.drawable.o),
    onClick: () -> Unit = {}
) {
    Card(modifier = modifier.clickable {
        onClick()
    }, colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(20.dp),
                painter = painter,
                contentDescription = "XO",
            )
        }
    }
}

@Preview(name = "ButtonXO")
@Composable
private fun PreviewButtonXO() {
    ButtonXO()
}