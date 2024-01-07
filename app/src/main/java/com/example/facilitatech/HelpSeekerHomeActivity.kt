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
                // HelpSeekerScreen { navigateToWaitPageActivity() }
                // this is not the correct way to go to the waitPage,
                // but the way above is not working, i don't know why
                HelpSeekerScreen { i ->
                    when (i) {
                        1 -> navigateToWaitPageActivity()
                    }
                }
            }
        }
    }

    private fun navigateToWaitPageActivity() {
        val intent = Intent(this, WaitPageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHelpSeekerActivity() {
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
fun HelpSeekerScreen(onNavigate: (Int) -> Unit) {
    val context = LocalContext.current
    val activity = context as? HelpSeekerHomeActivity  // Cast context to your activity

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f) // This Box will take up the space available minus the space the bottom part takes
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Conditionally add ActionButtons based on your logic
                ActionButton(
                    text = "Enviar link para uma nova ajuda",
                    iconId = R.drawable.send_message_icon, // Replace with actual icon id
                    onButtonClick = {
                        activity?.shareText("This is the text I want to share.")
                    }
                )
                ActionButton(
                    text = "Ver ajudas gravadas",
                    iconId = R.drawable.send_message_icon, // Replace with actual icon id
                    onButtonClick = {
                        activity?.navigateToRecordedHelpsActivity()
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2f) // This Column will take the remaining space
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

            // List of recent users inside a LazyColumn
            LazyColumn(
                modifier = Modifier
                    .weight(1f) // Take up all available space
            ) {
                // Replace this list with your actual data source
                val recentUsers = listOf("Mateus Oliveira", "Ana Clara Souza", "Rafael Lima", "Beatriz Santos", "Thiago Silva")
                items(recentUsers) { name ->
                    // this onNavigate is not working
                    RecentUser(name = name, onButtonClick = { onNavigate(1) })
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
fun PreviewHelpSeekerHomeScreen() {
    AndroidToolsetTheme {
        // Provide a no-op lambda for the preview
        HelpSeekerScreen(onNavigate = {})
    }
}