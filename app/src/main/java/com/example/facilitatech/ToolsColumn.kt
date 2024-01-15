package com.example.facilitatech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.R
import com.example.facilitatech.ui.theme.AndroidToolsetTheme


@Composable
fun ToolsColumn(onExitCallClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(6.dp)
            .background(Color(0xFF7493A1))
            .clip(RoundedCornerShape(12.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { onExitCallClick }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_cancel_24),
                contentDescription = "Sair da chamada",
                tint = Color.Red,
            )
        }
        IconButton(onClick = { /* Handle click action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.pencil_outline_edit),
                contentDescription = "Desenhar na tela",
                tint = Color.White,
            )
        }
        IconButton(onClick = { /* Handle click action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.round_delete_24),
                contentDescription = "Apagar comentários",
                tint = Color.White,
            )
        }
        IconButton(onClick = { /* Handle click action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.outline_color_lens_24),
                contentDescription = "Escolher cor",
                tint = Color.White,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewToolscolumnScreen() {
    AndroidToolsetTheme {
        ToolsColumn{ }
    }
}
