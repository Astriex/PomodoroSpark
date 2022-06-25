package com.astriex.pomodorospark.common.presenter.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.ui.graphics.vector.ImageVector
import com.astriex.pomodorospark.R

sealed class BottomNavDestinations(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object TimerScreen : BottomNavDestinations("timer_screen", R.string.timer, Icons.Outlined.Timer)
    object RewardsScreen :
        BottomNavDestinations("rewards_screen", R.string.rewards, Icons.Outlined.List)
}

sealed class FullScreenDestinations(
    val route: String
) {
    object AddEditRewardScreen : FullScreenDestinations("add_edit_reward_screen")
}

val items = listOf(BottomNavDestinations.TimerScreen, BottomNavDestinations.RewardsScreen)
