package com.example.facilitatech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomRibbon(
    text: String,
    iconId: Int,
    backgroundColor: Color = Color(0xFF7493A1), // Default color for the ribbon
    contentColor: Color = Color.White // Default color for text and icon
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = contentColor,
                modifier = Modifier.padding(end = 8.dp)
            )
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "$text Icon",
                tint = contentColor
            )
        }
    }
}
