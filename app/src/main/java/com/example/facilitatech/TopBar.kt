package com.example.facilitatech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.ui.theme.AndroidToolsetTheme


@Composable
fun TopBar() {
    Spacer(modifier = Modifier.height(9.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 9.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF7493A1)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Compartilhando tela",
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBarScreen() {
    AndroidToolsetTheme {
        TopBar()
    }
}
