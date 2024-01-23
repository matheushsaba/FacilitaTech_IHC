package com.example.facilitatech

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facilitatech.components.PromptUserWindow
import com.example.facilitatech.components.ToolsColumn
import com.example.facilitatech.components.TopBar
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class HelperSharingScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                HelperSharingScreenContent{ navigateToHomeActivity() }
            }
        }
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HelperHomeActivity::class.java)
        startActivity(intent)
    }
}


@Composable
fun HelperSharingScreenContent(onNavigate: () -> Unit) {
    var showExitDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.image_bill), // Replace with your actual image resource ID
            contentDescription = null, // Background images typically do not need a content description
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Adjust the scaling as needed
        )

        Column {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            ToolsColumn(onExitCallClick = { showExitDialog = true })
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
fun PreviewHelperSharingScreenContent() {
    AndroidToolsetTheme {
        HelperSharingScreenContent{ }
    }
}
