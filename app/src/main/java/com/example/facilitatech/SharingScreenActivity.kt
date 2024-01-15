package com.example.facilitatech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.components.PromptUserWindow
import com.example.facilitatech.components.ToolsColumn
import com.example.facilitatech.components.TopBar
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class SharingScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                SharingScreenContent()
            }
        }
    }
}


@Composable
fun SharingScreenContent() {
    var showExitDialog by remember { mutableStateOf(false) }
    // Add additional state variables as needed

    if (showExitDialog) {
        ExitDialog(
            onConfirm = { /* Handle confirm action */ },
            onDismiss = { showExitDialog = false }
        )
//        PromptUserWindow(
//            onButtonClick = { },
//            text = "Você tem certeza que deseja sair da chamada?"
//        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            ToolsColumn(onExitCallClick = { showExitDialog = true })
        }
    }
}

@Composable
fun ExitDialog(onConfirm: () -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Confirmação") },
        text = { Text("Você tem certeza que deseja sair da chamada?") },
        confirmButton = {
            Button(onClick = onConfirm) { Text("Sim") }
        },
        dismissButton = {
            Button(onClick = onDismiss) { Text("Não") }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewSharingScreenContent() {
    AndroidToolsetTheme {
        SharingScreenContent()
    }
}
