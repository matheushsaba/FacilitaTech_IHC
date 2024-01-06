package com.example.facilitatech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
fun RecordingButton(
    recordingName: String,
    helperName: String,
    date: String,
    iconId: Int,
    modifier: Modifier = Modifier, // Accept the modifier parameter
    onButtonClick: () -> Unit
) {
    // Fixed background and content colors
    val backgroundColor = Color(0xFF7493A1)
    val contentColor = Color.White

    Button(
        onClick = onButtonClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(16.dp), // Adjust as needed to match design
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7493A1))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "Profile Picture",
                tint = contentColor,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = recordingName,
                    color = contentColor,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Text(
                    text = helperName,
                    color = contentColor,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = date,
                    color = contentColor,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}

@Preview()
@Composable
fun PreviewRecordingButton() {
    AndroidToolsetTheme {
        RecordingButton(
            recordingName = "Pesquisar Instagram",
            helperName = "Beatriz Santos",
            date = "08/12/2023",
            iconId = R.drawable.send_message_icon,
            onButtonClick = { }
        )
    }
}
