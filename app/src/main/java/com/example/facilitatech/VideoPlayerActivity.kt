package com.example.facilitatech


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.facilitatech.components.ActionButton
import com.example.facilitatech.components.BottomRibbon
import com.example.facilitatech.components.RecentUser
import com.example.facilitatech.components.RecordingButton
import com.example.facilitatech.ui.theme.AndroidToolsetTheme

class VideoPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player) // Set the layout that contains your VideoView

        val videoView: VideoView = findViewById(R.id.videoView) // Get the VideoView by ID

        // Get the video resource ID passed from the previous Activity
        val videoResId = intent.getIntExtra("VIDEO_RESOURCE_ID", -1)

        if (videoResId != -1) {
            // Create a URI for the video resource and set it to the VideoView
            val uri = Uri.parse("android.resource://$packageName/$videoResId")
            videoView.setVideoURI(uri)

            // Start playing the video
            videoView.start()
        } else {
            // Handle the error case where the video resource ID wasn't passed correctly
            // For example, you could show an error message or close the activity
            finish()
        }
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun PreviewRecordingsScreen() {
//    AndroidToolsetTheme {
//        // Provide a no-op lambda for the preview
//        RecordingsScreen(onNavigate = {})
//    }
//}