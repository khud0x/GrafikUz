package com.example.grafikuz.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.grafikuz.data.Lesson
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun LessonDetailScreen(
    lesson: Lesson,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF020617),
                        Color(0xFF0F172A),
                        Color(0xFF1E293B)
                    )
                )
            )
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Button(onClick = onBack) {
            Text("Orqaga")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = lesson.title,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = lesson.subtitle,
            color = Color(0xFFCBD5E1),
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(22.dp))

        YouTubeVideoBox(videoUrl = lesson.youtubeVideoId)

        Spacer(modifier = Modifier.height(14.dp))

        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(lesson.youtubeVideoId))
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFDC2626)
            )
        ) {
            Text(
                text = "▶ YouTube’da ochish",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.08f)
            )
        ) {
            Text(
                text = lesson.content,
                color = Color.White,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(18.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun YouTubeVideoBox(videoUrl: String) {
    val videoId = remember(videoUrl) {
        extractYoutubeVideoId(videoUrl)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(215.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        if (videoId == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Video link noto‘g‘ri",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        } else {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    YouTubePlayerView(context).apply {
                        addYouTubePlayerListener(
                            object : AbstractYouTubePlayerListener() {
                                override fun onReady(youTubePlayer: YouTubePlayer) {
                                    youTubePlayer.cueVideo(videoId, 0f)
                                }

                                override fun onError(
                                    youTubePlayer: YouTubePlayer,
                                    error: PlayerConstants.PlayerError
                                ) {
                                    // Embed blok bo‘lsa, ekranda YouTube tugmasi bor.
                                }
                            }
                        )
                    }
                }
            )
        }
    }
}

fun extractYoutubeVideoId(url: String): String? {
    return when {
        url.contains("youtu.be/") -> {
            url.substringAfter("youtu.be/")
                .substringBefore("?")
                .substringBefore("&")
                .trim()
        }

        url.contains("youtube.com/watch?v=") -> {
            url.substringAfter("v=")
                .substringBefore("&")
                .substringBefore("?")
                .trim()
        }

        url.length == 11 -> url.trim()

        else -> null
    }
}