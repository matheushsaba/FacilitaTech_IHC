package com.example.facilitatech


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.facilitatech.components.BottomRibbon
import com.example.facilitatech.components.WaitPage
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class SelectUserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidToolsetTheme {
                UserScreen { userType ->
                    when (userType) {
                        1 -> navigateToHelperActivity()
                        2 -> navigateToHelpSeekerActivity()
                    }
                }
            }
        }
    }

    private fun navigateToHelperActivity() {
        val intent = Intent(this, HelperHomeActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHelpSeekerActivity() {
        val intent = Intent(this, HelpSeekerHomeActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun UserScreen(onNavigate: (Int) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            User(
                iconId = R.drawable.teacher_2_, // Replace with your actual icon drawable resource
                buttonText = "Sou um ajudante",
                onButtonClick = { onNavigate(1) } // For "Helper" button
            )

            Spacer(modifier = Modifier.height(32.dp))

            User(
                iconId = R.drawable.why_quest, // Replace with your actual icon drawable resource
                buttonText = "Preciso de ajuda",
                onButtonClick = { onNavigate(2) } // For "Help Seeker" button
            )
        }

        BottomRibbon(
            text = "HelpingHand",
            iconId = R.drawable.baseline_handshake_24,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }
}


@Composable
fun User(
    iconId: Int,  // Icon resource ID parameter
    buttonText: String,  // Button text parameter
    onButtonClick: () -> Unit  // Click handler for the button
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.size(309.dp, 199.dp),
            shape = RoundedCornerShape(4.dp),
            // Color and other Surface properties as required
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.size(130.dp),
                    shape = CircleShape,
                    color = Color(0xFF7493A1)
                ) {
                    // Place the Image composable here to display the icon
                    Image(
                        painter = painterResource(id = iconId),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .size(100.dp)
                            , // Center the image within the Surface
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(9.dp))
                Surface(
                    modifier = Modifier.size(309.dp, 60.dp),
                    shape = RoundedCornerShape(15.dp),
                    color = Color(0xFF7493A1)
                ) {
                    Button(
                        onClick = onButtonClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF7493A1), // Background color of the button
                            contentColor = Color.White // Color of the text and icons
                        ),
                        shape = RoundedCornerShape(5.dp) // More boxed shape
                    ) {
                        // Use the buttonText parameter for the Button's text
                        Text(
                            text = buttonText,
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = Color.White,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 10.sp
                            ),
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true, name = "Ajudante")
@Composable
fun PreviewSelectUserScreen() {
    AndroidToolsetTheme {
        // Provide a no-op lambda for the preview since navigation doesn't work in previews
        UserScreen(onNavigate = { userType ->
            // For debugging, you can print which user type was selected
            println("User type $userType selected in Preview")
        })
    }
}