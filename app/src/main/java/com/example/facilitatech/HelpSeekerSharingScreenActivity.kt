package com.example.facilitatech

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facilitatech.components.PromptUserWindow
import com.example.facilitatech.components.TopBar
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class HelpSeekerSharingScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                HelpSeekerSharingScreenContent{ navigateToConfirmRecordingActivity() }
            }
        }
    }

    private fun navigateToConfirmRecordingActivity() {
        val intent = Intent(this, ConfirmRecordingActivity::class.java)
        startActivity(intent)
    }
}


@Composable
fun HelpSeekerSharingScreenContent(onNavigate: () -> Unit) {
    var showExitDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            TopBar()
            Column(
                modifier = Modifier
                    .padding(6.dp)
                    .background(Color(0xFF7493A1))
                    .clip(RoundedCornerShape(12.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { showExitDialog = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_cancel_24),
                        contentDescription = "Sair da chamada",
                        tint = Color.Red,
                    )
                }
            }
        }

        if (showExitDialog) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                PromptUserWindow(
                    onConfirm = { onNavigate() },
                    onDismiss = { showExitDialog = false },
                    text = "Você tem certeza que deseja sair da chamada?"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHelpSeekerSharingScreenContent() {
    AndroidToolsetTheme {
        HelpSeekerSharingScreenContent{ }
    }
}
