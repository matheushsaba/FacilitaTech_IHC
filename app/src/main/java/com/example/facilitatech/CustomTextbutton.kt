package com.example.facilitatech.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facilitatech.R
import com.example.facilitatech.ui.theme.AndroidToolsetTheme
import java.time.format.TextStyle


@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff7493a1)),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .requiredWidth(309.dp)
            .requiredHeight(50.dp)
    ) {
//        Text(
//            text = text,
//            color = Color.White,
//            style = TextStyle(
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold
//            )
//        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCustomTextButton() {
    AndroidToolsetTheme {
        CustomTextButton(
            text = "Continuar na chamada",
            onClick = { }
        )
    }
}
