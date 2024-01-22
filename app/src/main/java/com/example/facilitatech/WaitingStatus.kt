package com.example.facilitatech.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.HelperWaitPage
import com.example.facilitatech.R
import com.example.facilitatech.ui.theme.AndroidToolsetTheme
import java.time.format.TextStyle



@Composable
fun WaitingStatus(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 310.dp)
            .requiredHeight(height = 380.dp)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.CenterStart)
                .offset(
                    x = 0.dp,
                    y = 165.dp
                )
                .requiredWidth(width = 309.dp)
                .requiredHeight(height = 50.dp)
        )
        Text(
            text = "Seu convite foi enviado. Aguarde a resposta do outro usuário.",
            color = Color(0xff333333),
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(
                    x = 0.dp,
                    y = 0.dp
                )
                .requiredWidth(width = 310.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(
                    x = 0.dp,
                    y = 110.dp
                )
                .requiredSize(size = 200.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(size = 200.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xff8da47e)))
            Image(
                painter = painterResource(id = R.drawable.hourglass),
                contentDescription = "Hourglass",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(
                        x = 40.dp,
                        y = 40.dp
                    )
                    .requiredSize(size = 120.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewWaitingStatus() {
    AndroidToolsetTheme {
        WaitingStatus()
    }
}
