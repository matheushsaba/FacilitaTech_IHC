package com.example.facilitatech.components

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.R
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

data class RecordingInfo(
    val recordingName: String,
    val helperName: String,
    val date: String,
    val videoResourceId: Int // Assuming you identify videos by resource IDs
)

@Composable
fun RecordingButton(
    recordingInfo: RecordingInfo,
    onButtonClick: (RecordingInfo) -> Unit
) {
    // Define fixed colors for the button
    val backgroundColor = Color(0xFF7493A1)
    val contentColor = Color.White

    Button(
        onClick = { onButtonClick(recordingInfo) },
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.send_message_icon),
                contentDescription = recordingInfo.recordingName,
                tint = contentColor,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                // ==================
                // TÍTULO DA GRAVAÇÃO
                // ==================
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.dot_circle_recording_icon),
                        contentDescription = recordingInfo.recordingName,
                        tint = contentColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = recordingInfo.recordingName,
                        color = contentColor,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                // ==================
                // AJUDANTE DA GRAVAÇÃO
                // ==================
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.user_icon),
                        contentDescription = recordingInfo.recordingName,
                        tint = contentColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = recordingInfo.helperName,
                        color = contentColor,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.height(3.dp))
                // ==================
                // DATA DA GRAVAÇÃO
                // ==================
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(1.dp))
                    Icon(
                        painter = painterResource(R.drawable.calendar_icon),
                        contentDescription = recordingInfo.recordingName,
                        tint = contentColor,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = recordingInfo.date,
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
}

@Preview(showBackground = true)
@Composable
fun PreviewRecordingButton() {
    AndroidToolsetTheme {
        RecordingButton(
            recordingInfo = RecordingInfo(
                "Pesquisar no Instagram",
                "Beatriz Santos",
                "08/12/2023",
                R.drawable.send_message_icon // Replace with an actual icon resource ID
            ),
            onButtonClick = {}
        )
    }
}

