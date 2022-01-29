package com.astriex.pomodorospark.common.presenter.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.ui.graphics.vector.ImageVector
import com.astriex.pomodorospark.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object TimerScreen : Screen("timer_screen", R.string.timer, Icons.Outlined.Timer)
    object RewardsScreen : Screen("rewards_screen", R.string.rewards, Icons.Outlined.List)
}

val items = listOf(Screen.TimerScreen, Screen.RewardsScreen)
