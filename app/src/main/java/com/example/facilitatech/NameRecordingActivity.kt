package com.example.facilitatech


import PromptNameWindow
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
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class NameRecordingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                NameRecordingScreen( {navigateToRecordedHelps()}, "Você deseja gravar a chamada?")
            }
        }
    }

    private fun navigateToRecordedHelps() {
        val intent = Intent(this, RecordedHelpsActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun NameRecordingScreen(confirmName: () -> Unit, text: String) {
    Box(modifier = Modifier.fillMaxSize()) {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PromptNameWindow( {confirmName()}, "Escolha um nome para a gravação dessa chamada")
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
fun PreviewNameRecordingScreen() {
    AndroidToolsetTheme {
        NameRecordingScreen({}, "Você deseja gravar a chamada?")
    }
}