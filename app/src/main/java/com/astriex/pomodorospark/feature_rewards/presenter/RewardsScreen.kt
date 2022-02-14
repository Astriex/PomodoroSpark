package com.astriex.pomodorospark.feature_rewards.presenter

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.astriex.pomodorospark.R
import com.astriex.pomodorospark.common.presenter.composables.CustomTopAppBar
import com.astriex.pomodorospark.feature_rewards.data.local.util.IconKeys
import com.astriex.pomodorospark.feature_rewards.domain.model.Reward
import com.astriex.pomodorospark.feature_rewards.presenter.composables.RewardsList
import com.astriex.pomodorospark.ui.theme.PomodoroSparkTheme

@Composable
fun RewardsScreen(viewModel: RewardsViewModel = hiltViewModel()) {
    val rewards = viewModel.rewards.collectAsState(initial = emptyList<Reward>())
    ScreenContent(rewards.value)
}

@Composable
private fun ScreenContent(dummyRewards: List<Reward>) {
    Scaffold(
        topBar = {
            CustomTopAppBar(title = stringResource(id = R.string.rewards))
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add)
                )
            }
        }
    ) {
        RewardsList(dummyRewards)
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
                    Reward(iconKey = IconKeys.CAKE, title = "CAKE", chanceInPercent = 1),
                    Reward(iconKey = IconKeys.BATHTUB, title = "BATHTUB", chanceInPercent = 5),
                    Reward(iconKey = IconKeys.MOVIE, title = "MOVIE", chanceInPercent = 50)
                )
            )
        }
    }
}
