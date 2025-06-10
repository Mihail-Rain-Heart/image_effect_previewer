package ru.effect.imageeffectpreviewer.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainActivityContent() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Hello !"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityContentPreview() {
    MainActivityContent()
}
