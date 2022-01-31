package com.astriex.pomodorospark.feature_rewards.presenter

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.astriex.pomodorospark.feature_rewards.domain.models.Reward
import com.astriex.pomodorospark.feature_rewards.presenter.composables.RewardItem
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme

@Composable
fun RewardsScreen() {
    ScreenContent()
}

@Composable
private fun ScreenContent() {
    val dummyRewards = mutableListOf<Reward>()
    repeat(50) { index ->
        dummyRewards += Reward(icon = Icons.Default.Star, "item $index", index)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(contentPadding = PaddingValues(bottom = 16.dp)) {
            items(dummyRewards) { reward ->
                RewardItem(reward = reward)
            }
        }
    }
}

@Preview(name = "Light mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ScreenContentPreview() {
    PomodoroSparkTheme {
        Surface {
            ScreenContent()
        }
    }
}
