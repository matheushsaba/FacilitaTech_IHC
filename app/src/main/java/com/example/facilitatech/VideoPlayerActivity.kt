package com.example.facilitatech

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class VideoPlayerActivity : ComponentActivity() {

    private lateinit var exoPlayer: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val videoResId = intent.getIntExtra("VIDEO_RESOURCE_ID", -1)

        // Initialize player only if we have a valid video resource ID
        if (videoResId != -1) {
            initializePlayer(videoResId)
        }

        setContent {
            if (videoResId != -1) {
                VideoPlayerScreen()
            } else {
                // Handle the error case here, show an error message or close the activity
            }
        }
    }

    private fun initializePlayer(videoResId: Int) {
        exoPlayer = ExoPlayer.Builder(this).build()

        val videoUri: Uri = Uri.parse("android.resource://$packageName/$videoResId")
        val mediaItem = MediaItem.fromUri(videoUri)

        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    @OptIn(UnstableApi::class) @Composable
    fun VideoPlayerScreen() {
        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    player = exoPlayer
                    useController = true
                    setShowBuffering(PlayerView.SHOW_BUFFERING_WHEN_PLAYING)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::exoPlayer.isInitialized) {
            exoPlayer.release()
        }
    }
}
