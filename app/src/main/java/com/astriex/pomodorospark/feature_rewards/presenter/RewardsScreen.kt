package com.astriex.pomodorospark.feature_rewards.presenter

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalCarWash
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.feature_rewards.domain.models.Reward
import com.astriex.pomodorospark.feature_rewards.presenter.composables.RewardItem
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme

@Composable
fun RewardsScreen(viewModel: RewardsViewModel = hiltViewModel()) {
    val dummyRewards = viewModel.dummyRewards.collectAsState(emptyList())
    ScreenContent(dummyRewards.value)
}

@Composable
private fun ScreenContent(dummyRewards: List<Reward>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.rewards)) }
            )
        }
    ) {
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
}

@Preview(name = "Light mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ScreenContentPreview() {
    PomodoroSparkTheme {
        Surface {
            ScreenContent(
                listOf(
                    Reward(Icons.Default.Star, "Reward 1", 1),
                    Reward(Icons.Default.LocalCarWash, "Reward 2", 5),
                    Reward(Icons.Default.LocalFireDepartment, "Reward 3", 50)
                )
            )
        }
    }
}
