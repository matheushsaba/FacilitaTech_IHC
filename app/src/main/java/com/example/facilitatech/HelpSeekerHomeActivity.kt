package com.example.facilitatech


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.facilitatech.components.ActionButton
import com.example.facilitatech.components.BottomRibbon
import com.example.facilitatech.components.RecentUser
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class HelpSeekerHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                HelpSeekerScreen { navigateToConfirmRecordingActivity() }
            }
        }
    }

    private fun navigateToConfirmRecordingActivity() {
        val intent = Intent(this, ConfirmRecordingActivity::class.java)
        startActivity(intent)
    }

    fun navigateToRecordedHelpsActivity() {
        val intent = Intent(this, RecordedHelpsActivity::class.java)
        startActivity(intent)
    }

    fun shareText(text: String) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }
}

@Composable
fun HelpSeekerScreen(onNavigate: () -> Unit) {
    val context = LocalContext.current
    val activity = context as? HelpSeekerHomeActivity

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ActionButton(
                    text = "Enviar convite para uma nova ajuda",
                    iconId = R.drawable.share_icon,
                    onButtonClick = {
                        activity?.shareText("Estou precisando de uma ajuda. \n" +
                                "Clique neste link para entrar em uma chamada comigo: XXXXX")
                        onNavigate()
                    }
                )
                ActionButton(
                    text = "Ver ajudas gravadas",
                    iconId = R.drawable.saved_recordings_icon,
                    onButtonClick = {
                        activity?.navigateToRecordedHelpsActivity()
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2f)
                .padding(16.dp)
        ) {
            Text(
                text = "Recentes:",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 8.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                val recentUsers = listOf("Mateus Oliveira", "Ana Clara Souza", "Rafael Lima", "Beatriz Santos", "Thiago Silva")
                items(recentUsers) { name ->
                    RecentUser(name = name, onButtonClick = { onNavigate() })
                }
            }
        }

        BottomRibbon(
            text = "HelpingHand",
            iconId = R.drawable.baseline_handshake_24,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHelpSeekerHomeScreen() {
    AndroidToolsetTheme {
        HelpSeekerScreen(onNavigate = {})
    }
}