package com.example.tiktakto.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartedScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "StartedScreen")
    }
}

@Preview(name = "StartedScreen")
@Composable
private fun PreviewStartedScreen() {
    StartedScreen()
}