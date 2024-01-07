package com.example.facilitatech

import android.os.Bundle
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.os.Handler
import android.os.Looper
import androidx.compose.material3.*
import androidx.activity.ComponentActivity
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import com.example.facilitatech.ui.theme.AndroidToolsetTheme
import androidx.compose.ui.tooling.preview.Preview

import com.example.facilitatech.components.BottomRibbon


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                LoginScreen { navigateToNextScreen() }
            }
        }
    }

    private fun navigateToNextScreen() {
        // Navigate to the next screen. Replace `NextActivity::class.java` with the actual class
        val intent = Intent(this, SelectUserActivity::class.java)
//        val intent = Intent(this, VideoPlayerActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center), // This aligns the Column to the center of the Box
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                Button(
                    onClick = {
                        isLoading = true
                        // Simulate a delay for loading
                        Handler(Looper.getMainLooper()).postDelayed({
                            isLoading = false
                            onLoginSuccess()
                        }, 2000) // 2 seconds delay
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF7493A1),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("Login")
                }
            }
        }

        BottomRibbon(
            text = "HelpingHand",
            iconId = R.drawable.baseline_handshake_24, // Replace with your actual icon resource ID
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true, name = "Login Screen Preview")
@Composable
fun PreviewLoginScreen() {
    AndroidToolsetTheme {
        LoginScreen(onLoginSuccess = {})
    }
}

