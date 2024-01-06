package com.example.facilitatech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun ActionButton(text: String, iconId: Int, onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(30.dp), // Adjust as needed to match design
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7493A1))
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier.size(24.dp) // Adjust size as needed
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold, // Make text bold
                fontSize = 22.sp // Set text size
            )
        )
    }
    Spacer(modifier = Modifier.height(8.dp)) // Space between buttons
}

@Preview()
@Composable
fun PreviewActionButtonScreen() {
    AndroidToolsetTheme {
        ActionButton(text = "Enviar link para uma nova ajuda", iconId = R.drawable.send_message_icon, onButtonClick = { })
    }
}
