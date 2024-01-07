package com.example.facilitatech


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.facilitatech.components.ActionButton
import com.example.facilitatech.components.BottomRibbon
import com.example.facilitatech.components.RecentUser
import com.example.facilitatech.components.RecordingButton
import com.example.facilitatech.components.RecordingInfo
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class RecordedHelpsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                RecordingsScreen()
                }
            }
        }
    }


@Composable
fun RecordingsScreen() {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(2f) // This Column will take the remaining space
                .padding(16.dp)
        ) {
            Text(
                text = "Gravações:",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 8.dp)
            )

            // Example data, replace with your actual video data
            val recordings = listOf(
//                RecordingInfo("Pesquisar no Instagram", "Beatriz Santos", "08/12/2023", R.raw.instagram_video),
//                RecordingInfo("Chamar Uber", "Mateus Oliveira", "02/11/2023", R.drawable.send_message_icon),
//                RecordingInfo("Ver vídeo no Youtube", "Mateus Oliveira", "01/11/2023", R.drawable.send_message_icon),
//                RecordingInfo("Pagar boleto", "Beatriz Santos", "13/04/2023", R.drawable.send_message_icon),
//                RecordingInfo("Ver filme na Netflix", "Beatriz Santos", "13/04/2023", R.drawable.send_message_icon)

                    RecordingInfo("Pesquisar no Instagram", "Beatriz Santos", "08/12/2023", R.raw.instagram_video),
                    RecordingInfo("Chamar Uber", "Mateus Oliveira", "02/11/2023", R.raw.instagram_video),
                    RecordingInfo("Ver vídeo no Youtube", "Mateus Oliveira", "01/11/2023", R.raw.instagram_video),
                    RecordingInfo("Pagar boleto", "Beatriz Santos", "13/04/2023", R.raw.instagram_video),
                    RecordingInfo("Ver filme na Netflix", "Beatriz Santos", "13/04/2023", R.raw.instagram_video)
                        )

            LazyColumn {
                items(recordings) { recordingInfo ->
                    RecordingButton(
                        recordingInfo = recordingInfo,
                        onButtonClick = { info ->
                            // Start the VideoPlayerActivity and pass the video resource ID
                            val intent = Intent(context, VideoPlayerActivity::class.java).apply {
                                putExtra("VIDEO_RESOURCE_ID", info.videoResourceId)
                            }
                            context.startActivity(intent)
                        }
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                }
            }
        }

        BottomRibbon(
            text = "HelpingHand",
            iconId = R.drawable.baseline_handshake_24,
            modifier = Modifier.align(Alignment.CenterHorizontally) // Align this to the bottom of the Column
        )
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewRecordingsScreen() {
    AndroidToolsetTheme {
        RecordingsScreen()
    }
}