package com.example.facilitatech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.R
import com.example.facilitatech.ui.theme.AndroidToolsetTheme


@Composable
fun BottomRibbon(
    text: String,
    iconId: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF7493A1),
    contentColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = contentColor,
                modifier = Modifier.padding(end = 8.dp),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 22.sp
                )
            )
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "$text Icon",
                tint = contentColor
            )
        }
    }
}
@Preview()
@Composable
fun PreviewLoginScreen() {
    AndroidToolsetTheme {
        BottomRibbon(text = "HelpingHand",
            iconId = R.drawable.baseline_handshake_24)
    }
}
