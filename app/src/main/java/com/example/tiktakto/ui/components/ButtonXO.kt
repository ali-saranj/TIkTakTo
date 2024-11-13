package com.example.tiktakto.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
    XO: Int = 0,
    onClick: () -> Unit = {}
) {
    Card(modifier = modifier.clickable {
        onClick()
    }, colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (XO != 0) {
                Image(
                    modifier = Modifier
                        .padding(20.dp),
                    painter = when (XO) {
                        1 -> painterResource(id = R.drawable.o)
                        2 -> painterResource(id = R.drawable.x)
                        else -> {
                            painterResource(id = R.drawable.o)
                        }
                    }, // Use painter directly since it's not null
                    contentDescription = "XO",
                )
            } else {
                Box(Modifier.size(117.dp))
            }

        }
    }
}


@Preview(name = "ButtonXO")
@Composable
private fun PreviewButtonXO() {
    ButtonXO()
}