package com.example.facilitatech


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.widget.TextView
import androidx.activity.ComponentActivity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

//@Composable
//fun FigmaToCodeApp() {
//    AndroidToolsetTheme {
//            Ajudante()
//        }
//}

@Composable
fun Ajudante(textName: String, IconId:Int) {
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.size(309.dp, 199.dp),
            shape = RoundedCornerShape(4.dp),
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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Image(
                            painter = painterResource(IconId),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.height(9.dp))
                Surface(
                    modifier = Modifier.size(309.dp, 60.dp),
                    shape = RoundedCornerShape(15.dp),
                    color = Color(0xFF7493A1)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Button(onClick = {
                            isLoading = true
                            // Simulate a delay for loading
                            Handler(Looper.getMainLooper()).postDelayed({
                                isLoading = false
                            }, 2000) // 2 seconds delay
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF7493A1), // Background color of the button
                                contentColor = Color.White // Color of the text and icons
                            ),
                            shape = RoundedCornerShape(5.dp) // More boxed shape
                        ) {
                            Text(
                                text = textName,
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
}

@Preview(showBackground = true, name = "Ajudante")
@Composable
fun AjudanteScreen() {
    AndroidToolsetTheme {
       Ajudante(textName = "Sou um ajudante", IconId = R.drawable.send_message_icon)
    }
}