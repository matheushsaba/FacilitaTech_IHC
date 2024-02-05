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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.delay

class HelperHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                HelperScreen { navigateToWaitPageActivity() }
            }
        }
    }

    private fun navigateToWaitPageActivity() {
        val intent = Intent(this, HelperWaitPageActivity::class.java)
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
fun HelperScreen(onNavigate: () -> Unit) {
    val context = LocalContext.current
    val activity = context as? HelperHomeActivity
    var initiateSharing by remember { mutableStateOf(false) }

    // Use LaunchedEffect to observe initiateSharing
    LaunchedEffect(initiateSharing) {
        if (initiateSharing) {
            delay(4000) // Wait for 2 seconds
            onNavigate() // Execute navigation
            initiateSharing = false // Reset the state
        }
    }

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
                        activity?.shareText("Gostaria de de uma ajuda? \n" +
                                "Clique neste link para entrar em uma chamada comigo: XXXXX")
                        initiateSharing = true // Trigger the LaunchedEffect
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
                    color = Color(0xff333333),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 8.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                val recentUsers = listOf(
                    "Analice Ferreira",
                    "Márcio Espíndola",
                    "Vanessa Barbosa",
                    "Eduardo Amaral",
                    "Gilberto Linhares",
                    "Renato Magalhães",
                    "Andressa Freitas",
                    "José Souza",
                    "Maria Oliveira",
                    "Antônio Costa",
                    "Teresa Santos",
                    "João Almeida",
                    "Francisca Silva",
                    "Raimundo Pereira",
                    "Sebastiana Lima",
                    "Geraldo Ribeiro",
                    "Lucia Carvalho",
                    "Roberto Rocha"
                )
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
fun PreviewHelperHomeScreen() {
    AndroidToolsetTheme {
        HelperScreen(onNavigate = {})
    }
}