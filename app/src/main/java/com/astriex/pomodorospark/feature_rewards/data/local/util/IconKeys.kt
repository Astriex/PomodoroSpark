package com.astriex.pomodorospark.feature_rewards.data.local.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

object IconKeys {
    const val DEFAULT = "STAR"
    const val CAKE = "CAKE"
    const val BATHTUB = "BATHTUB"
    const val MOVIE = "MOVIE"
}

val rewardIcons = mapOf<String, ImageVector>(
    Pair(IconKeys.CAKE, Icons.Default.Cake),
    Pair(IconKeys.BATHTUB, Icons.Default.Bathtub),
    Pair(IconKeys.MOVIE, Icons.Default.Movie)
)
val defaultRewardIcon = Icons.Default.Star