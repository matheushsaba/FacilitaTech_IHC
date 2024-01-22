package com.example.facilitatech


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.facilitatech.components.BottomRibbon
import com.example.facilitatech.components.PromptUserWindow
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class ConfirmRecordingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                ConfirmRecordingScreen(
                    onConfirm = { navigateToNameRecordingActivity() },
                    onCancel = { navigateToHelpSeekerHomeActivity() },
                    "Você deseja gravar a chamada?")
            }
        }
    }

    private fun navigateToNameRecordingActivity() {
        val intent = Intent(this, NameRecordingActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHelpSeekerHomeActivity() {
        val intent = Intent(this, HelpSeekerHomeActivity::class.java)
        startActivity(intent)
    }
    
}

@Composable
fun ConfirmRecordingScreen(onConfirm: () -> Unit, onCancel: () -> Unit, text: String) {
    Box(modifier = Modifier.fillMaxSize()) {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PromptUserWindow(
                onConfirm = { onConfirm() },
                onDismiss = { onCancel() },
                text = "Você deseja gravar a chamada?"
            )
        }

        BottomRibbon(
            text = "HelpingHand",
            iconId = R.drawable.baseline_handshake_24,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewConfirmRecordingScreen() {
    AndroidToolsetTheme {
        ConfirmRecordingScreen(
            onConfirm = { },
            onCancel = { },
            "Você deseja gravar a chamada?")
    }
}