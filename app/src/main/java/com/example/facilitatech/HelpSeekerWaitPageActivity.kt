package com.example.facilitatech

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.components.BottomRibbon
import com.example.facilitatech.components.CustomTextButton
import com.example.facilitatech.components.WaitingStatus
import com.example.facilitatech.ui.theme.AndroidToolsetTheme


class HelpSeekerWaitPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                HelpSeekerWaitPage(
                    onNavigate = { navigateToHelpSeekerShareScreenActivity() },
                    onCancel = { finish() }
                )
            }
        }
    }

    private fun navigateToHelpSeekerShareScreenActivity() {
        val intent = Intent(this, HelpSeekerSharingScreen::class.java)
        startActivity(intent)
    }
}

@Composable
fun HelpSeekerWaitPage(onNavigate: () -> Unit, onCancel: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WaitingStatus()
            CustomTextButton(text = "Cancelar convite", onClick = onCancel)
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextButton(text = "Continuar na chamada", onClick = onNavigate)
        }

        BottomRibbon(
            text = "HelpingHand",
            iconId = R.drawable.baseline_handshake_24,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview( showBackground = true)
@Composable
private fun HelpSeekerWaitPagePreview() {
    AndroidToolsetTheme {
        HelpSeekerWaitPage(
            onNavigate = { },
            onCancel = { }
        )
    }
}